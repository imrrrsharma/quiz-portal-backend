package com.exam.controller;

import com.exam.exception.QuizException;
import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService service;

    @Autowired
    private QuizService quizService;

    //add question
    @PostMapping("/")
    public ResponseEntity<Question> add(@RequestBody Question question) throws QuizException {
        return ResponseEntity.ok(this.service.addQuestion(question));
    }

    //update the question
    @PutMapping("/")
    public ResponseEntity<Question> update(@RequestBody Question question) throws QuizException {
        return ResponseEntity.ok(this.service.updateQuestion(question));
    }

    //get all question of any quid
    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid) {

        Quiz quiz = this.quizService.getQuiz(qid);
        Set<Question> questions = quiz.getQuestions();
        for(Question q: questions){
            q.setAnswer("");
        }
        List list = new ArrayList(questions);

        if (list.size() > Integer.parseInt(quiz.getNumberOfQuestions())) {
            list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestions() + 1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);


    }

    @GetMapping("/quiz/all/{qid}")
    public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qid") Long qid) {
        Quiz quiz = new Quiz();
        quiz.setqId(qid);
        Set<Question> questionsOfQuiz = this.service.getQuestionsOfQuiz(quiz);
        return ResponseEntity.ok(questionsOfQuiz);
    }

    //get single question
    @GetMapping("/{quesId}")
    public Question get(@PathVariable("quesId") Long quesId) {
        return this.service.getQuestion(quesId);
    }

    //delete question
    @DeleteMapping("/{quesId}")
    public void delete(@PathVariable("quesId") Long quesId) {
        this.service.deleteQuestion(quesId);
    }


    //eval quiz
    @PostMapping("/eval-quiz")
    public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions) {
        double marksGot = 0;
        int correctAnswers = 0;
        int attempted = 0;

        // Collect all question IDs
        List<Long> questionIds = questions.stream()
                .map(Question::getQuesId)
                .collect(Collectors.toList());

        // Fetch all original questions in a single query
        List<Question> originalQuestions = new ArrayList<>();
        for(Long id: questionIds){
            originalQuestions.add(this.service.getQuestion(id));
        }

        // Map original questions by ID for quick lookup
        Map<Long, Question> questionMap = originalQuestions.stream()
                .collect(Collectors.toMap(Question::getQuesId, q -> q));

        // Evaluate the answers
        for (Question q : questions) {
            Question originalQuestion = questionMap.get(q.getQuesId());

            if (originalQuestion != null && q.getGivenAnswer() != null &&
                    q.getGivenAnswer().equals(originalQuestion.getAnswer())) {
                correctAnswers++;

                double marksSingle = Double.parseDouble(originalQuestion.getQuiz().getMaxMarks()) / questions.size();
                marksGot += marksSingle;
            }

            if (q.getGivenAnswer() != null) {
                attempted++;
            }
        }

        Map<String, Object> result = Map.of(
                "marksGot", marksGot,
                "correctAnswers", correctAnswers,
                "attempted", attempted
        );

        return ResponseEntity.ok(result);
    }


}

package com.exam.service.impl;

import com.exam.exception.QuizException;
import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.repo.QuizRepository;
import com.exam.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz, Long qid) throws QuizException {
        Optional<Quiz> optionalQuiz = quizRepository.findById(qid);
        if (optionalQuiz.isPresent()) {
            Quiz quiz1 = optionalQuiz.get();
            quiz1.setTitle(quiz.getTitle());
            quiz1.setDescription(quiz.getDescription());
            quiz1.setMaxMarks(quiz.getMaxMarks());
            quiz1.setNumberOfQuestions(quiz.getNumberOfQuestions());
            return quizRepository.save(quiz1);
        } else {
            throw new QuizException("Quiz not found with ID: " + qid);
        }

    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new HashSet<>(this.quizRepository.findAll());
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return this.quizRepository.findById(quizId).get();
    }

    @Override
    public void deleteQuiz(Long quizId) {
        this.quizRepository.deleteById(quizId);
    }

    @Override
    public List<Quiz> getQuizzesOfCategory(Category category) {
        return this.quizRepository.findBycategory(category);
    }


    //get active quizzes

    @Override
    public List<Quiz> getActiveQuizzes() {
        return this.quizRepository.findByActive(true);
    }

    @Override
    public List<Quiz> getActiveQuizzesOfCategory(Category c) {
        return this.quizRepository.findByCategoryAndActive(c, true);
    }

}

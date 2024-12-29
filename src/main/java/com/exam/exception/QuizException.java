package com.exam.exception;

import org.springframework.stereotype.Component;

@Component
public class QuizException extends Exception{
    private static final long serialVersionUID = 1;

    public QuizException(){
        super();
    }

    public QuizException(String errorMessage){
        super(errorMessage);
    }

    public QuizException(Throwable cause){
        super(cause);
    }

    public QuizException(String message, Throwable cause){
        super(message, cause);
    }
}

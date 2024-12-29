package com.exam.service;

import com.exam.exception.QuizException;
import com.exam.model.exam.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    public Category addCategory(Category category) throws QuizException;

    public Category updateCategory(Category category) throws QuizException;

    public List<Category> getCategories() throws QuizException;

    public Category getCategory(Long categoryId) throws QuizException;

    public void deleteCategory(Long categoryId) throws QuizException;
}

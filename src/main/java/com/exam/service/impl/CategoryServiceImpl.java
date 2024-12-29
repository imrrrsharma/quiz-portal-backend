package com.exam.service.impl;

import com.exam.exception.QuizException;
import com.exam.model.exam.Category;
import com.exam.repo.CategoryRepository;
import com.exam.service.CategoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private static final Logger logger = LogManager.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) throws QuizException {
        try{
            categoryRepository.save(category);
        } catch (Exception e){
            logger.error("Exception in addCategory(): ", e);
            throw new QuizException("Exception in adding new category.");
        }
        return category;
    }

    @Override
    public Category updateCategory(Category category) throws QuizException {
        try{
            categoryRepository.save(category);
        } catch (Exception e){
            logger.error("Exception in updateCategory(): ", e);
            throw new QuizException("Exception in updating category.");
        }
        return category;
    }

    @Override
    public List<Category> getCategories() throws QuizException {
        List<Category> categories = null;
        try{
            categories = categoryRepository.findAll();
        } catch (Exception e){
            logger.error("Exception in getCategories(): ", e);
            throw new QuizException("Exception in getting all  category.");
        }
        return categories;
//        return new LinkedHashSet<>(this.categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long categoryId) throws QuizException {
        Category category = null;
        try{
            category = categoryRepository.findById(categoryId).get();
        } catch (Exception e){
            logger.error("Exception in getCategory() by Id: ", e);
            throw new QuizException("Exception in getting category by ID.");
        }
        return category;
//        return this.categoryRepository.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryId) throws QuizException {
        Category category = new Category();
        try{
            category.setCid(categoryId);
            this.categoryRepository.delete(category);
        } catch (Exception e){
            logger.error("Exception in deleteCategory(): ", e);
            throw new QuizException("Exception in deleting category.");
        }
    }
}

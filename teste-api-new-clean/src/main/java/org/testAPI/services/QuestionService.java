package org.testAPI.services;

import org.testAPI.persistence.QuestionType;
import org.testAPI.persistence.model.Question;

import java.util.List;

public interface QuestionService {
    /**
     * Gets the question with the given id
     *
     * @param id the question id
     * @return the question
     */
    Question get(Integer id);

    /**
     * Saves a question
     *
     * @param question the question to save
     * @return the saved question
     */
    Question save(Question question);

    /**
     * Deletes the question
     *
     * @param id the question id
     */
    void delete(Integer id);

    /**
     * Gets a list of the questions
     *
     * @return the question list
     */
    List<Question> list();

    /**
     * Gets a random question within the question type
     *
     * @return a question
     */
    Question getRandomQuestion(List<QuestionType> questionTypes);

}

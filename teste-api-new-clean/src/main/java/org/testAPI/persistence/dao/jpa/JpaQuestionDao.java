package org.testAPI.persistence.dao.jpa;

import org.testAPI.persistence.dao.QuestionDao;
import org.testAPI.persistence.model.Question;

public class JpaQuestionDao extends GenericJPADao<Question> implements QuestionDao {
    /**
     * @see GenericJPADao#GenericJPADao(Class)
     */
    public JpaQuestionDao() {
        super(Question.class);
    }
}

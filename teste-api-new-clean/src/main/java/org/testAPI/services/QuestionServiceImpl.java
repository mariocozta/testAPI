package org.testAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testAPI.persistence.QuestionType;
import org.testAPI.persistence.dao.QuestionDao;
import org.testAPI.persistence.model.Question;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService{

    private QuestionDao questionDao;

    /**
     * Sets the question data access object
     *
     * @param questionDao the account DAO to set
     */
    @Autowired
    public void setQuestionDao(QuestionDao questionDao){
        this.questionDao = questionDao;
    }

    @Override
    public Question get(Integer id){
        return questionDao.findById(id);
    }

    @Transactional
    @Override
    public Question save(Question question) {
        return questionDao.saveOrUpdate(question);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        Question question = Optional.ofNullable(questionDao.findById(id)).orElseThrow(StringIndexOutOfBoundsException::new);

        questionDao.delete(id);
    }

    @Override
    public List<Question> list() {
        return questionDao.findAll();
    }

    @Override
    public Question getRandomQuestion(List<QuestionType> questionTypes) {
        //(int)Math.random()*100;
        int id = (int)Math.random()*100;

        return get(id);
    }


}

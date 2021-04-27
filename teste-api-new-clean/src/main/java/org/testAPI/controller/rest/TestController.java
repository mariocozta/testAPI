package org.testAPI.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.testAPI.persistence.QuestionType;
import org.testAPI.persistence.model.Question;
import org.testAPI.services.QuestionService;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/firstapi")
public class TestController {

    private QuestionService questionService;

    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(method = RequestMethod.GET,path = {"/firstTest"})
    public ResponseEntity<String> testApi(){
        return new ResponseEntity<>("this is a test string", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,path = {"/secondTest"})
    public ResponseEntity<String> testApiTwo(){
        return new ResponseEntity<>("this is a test string number 2", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,path = {"/getObjectTest"})
    public ResponseEntity<Question> testApiGet(){

        Question question = new Question();
        question.setQuestion("What is this?");
        question.setAnswer("This is a test.");
        question.setQuestionType(QuestionType.NORMAL);
        //question.setVersion(1);
        //question.setCreationTime("2017-10-10 10:18:53.819");

        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    /**
     * Adds a question
     *
     * @param question          the question

     * @return the response entity
     */
    @RequestMapping(method = RequestMethod.POST, path = {"/lol", ""})
    public ResponseEntity<?> testDatabase(@Valid @RequestBody @Autowired Question question) {

        if (question.getId() != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        questionService.save(question);


        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

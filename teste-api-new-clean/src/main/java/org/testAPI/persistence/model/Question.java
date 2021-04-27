package org.testAPI.persistence.model;

import org.testAPI.persistence.QuestionType;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Question extends AbstractModel{

    private String question;
    private String answer;
    private QuestionType questionType;

    public String getQuestion(){
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer(){
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionType getQuestionType(){
        return questionType;
    }

    public void setQuestionType(QuestionType questionType){
        this.questionType = questionType;
    }

    @Override
    public String toString() {

        // printing recipients with lazy loading
        // and no session will cause issues
        return "Question{" +
                "question='" + question + '\'' +
                ", anwser='" + answer + '\'' +
                ", questionType='" + questionType + '\'' +
                "} " + super.toString();
    }

}

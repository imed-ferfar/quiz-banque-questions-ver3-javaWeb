/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.utils;

import com.ias.projet_session3.entities.Question;

/**
 *
 * @author BaDRi
 */
public class QuestionDejaPresenteException extends Exception {

    private Question ques;

    public QuestionDejaPresenteException() {
    }

    public QuestionDejaPresenteException(Question ques, String message) {
        super(message+" : "+ques.getId_question());
        this.ques = ques;
    }

    public Question getQues() {
        return ques;
    }
}

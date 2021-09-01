/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.daos;

import com.ias.projet_session3.entities.ListeQuestions;
import com.ias.projet_session3.entities.Question;

/**
 *
 * @author BaDRi
 */
public interface QuestionDao {
    
    ListeQuestions ChargerLesQuestions(String id_enseig); //...4/23  

    public int GetNewIdQuestion();

    public void SetQuestion(Question ques);

    public void DeleteQuestion(Question ques);

    public void EditerQuestion(Question ques);
    
    
}

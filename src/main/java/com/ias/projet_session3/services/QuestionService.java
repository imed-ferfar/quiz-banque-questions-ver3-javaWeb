/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.services;

import com.ias.projet_session3.daos.QuestionDao;
import com.ias.projet_session3.daos.SqlQuestionDao;
import com.ias.projet_session3.entities.ListeQuestions;
import com.ias.projet_session3.entities.Question;

/**
 *
 * @author BaDRi
 */
public class QuestionService {

    // 1)Importer lises des questions ...4/23
    public static ListeQuestions ChargerLesQuestions(String id_enseig) {
        QuestionDao dao = new SqlQuestionDao();
        return dao.ChargerLesQuestions(id_enseig);
    }

    //  2)Generer un nouveau id_question   ...20/23
    public static int NouveauIdQuestion() {
        QuestionDao dao = new SqlQuestionDao();
        return dao.GetNewIdQuestion();
    }

    //  3)Ajouter une nouvelle question   ...21/23
    public static void AjouterQuestion(Question ques) {
        QuestionDao dao = new SqlQuestionDao();
        dao.SetQuestion(ques);
    }

    //   4)Aupprimer une  question   ...22/23
    public static void SupprimerQuestion(Question ques) {
        QuestionDao dao = new SqlQuestionDao();
        dao.DeleteQuestion(ques);
    }

    //  5) Modifier une  question   ...23/23
    public static void ModifierQuestion(Question ques) {
        QuestionDao dao = new SqlQuestionDao();
        dao.EditerQuestion(ques);
    }

}

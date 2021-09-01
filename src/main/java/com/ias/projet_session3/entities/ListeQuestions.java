/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.entities;

import java.util.HashMap;
import java.util.Map;
import com.ias.projet_session3.utils.QuestionDejaPresenteException;

/**
 *
 * @author BaDRi
 */
public class ListeQuestions {

    protected final String TITRE_QCM = "Choisir la ou les bonnes réponses";
    protected final String TITRE_IMG_ERR = "Trouver l'erreur dans ce code";
    protected final String TITRE_RES_EXE = "Trouver le resultat d'execution de ce code";
    private Map<Integer, Question> mapQuestion;

    public ListeQuestions() {
        mapQuestion = new HashMap<>();
    }

    public void ajouterQuestion(Question maQuestion) throws QuestionDejaPresenteException {

        if (verifierDoublon(maQuestion)) {
            throw new QuestionDejaPresenteException(maQuestion, "Question en double!!!");
        } else {
            mapQuestion.put(maQuestion.id_question, maQuestion);
        }
    }

    private boolean verifierDoublon(Question maQuestion) {
        for (Map.Entry monEntry : mapQuestion.entrySet()) {
            if (maQuestion.equals(monEntry.getValue())) {
                return true;
            }
        }
        return false;
    }

    public boolean supprimerQuestion(int cle) {
        if (mapQuestion.containsKey(cle)) {
            mapQuestion.remove(cle);
            System.out.println("La question N : " + cle + " a été bien supprimée");
            return true;
        }
        System.out.println("Désolé le ID_question : " + cle + " est non trouvé");
        return false;
    }

    public Question getQuestionN(int cle) {
        return mapQuestion.get(cle);
    }

    public int getSize() {
        return mapQuestion.size();
    }

    public int[] tableauCles() {
        int[] tab = new int[mapQuestion.size()];
        int i = 0;
        for (Map.Entry monEntry : mapQuestion.entrySet()) {
            tab[i] = (Integer) monEntry.getKey();
            i++;
        }
        return tab;  //   [cle1,cle2,cle3 ........clen]
    }

    public void listerQuestion() {
        System.out.println("=========Listing des questions=========");
        for (Map.Entry monEntry : mapQuestion.entrySet()) {
            System.out.println("clé: " + (Integer)monEntry.getKey() + " | " + monEntry.getValue());
        }
    }
    

    public int minCle() {
        int minVal = tableauCles()[0];
        for (int i = 1; i < tableauCles().length; i++) {
            if (tableauCles()[i] < minVal) {
                minVal = tableauCles()[i];
            }
        }
        return minVal;
    }

    public int maxCle() {
        int maxVal = tableauCles()[0];
        for (int i = 1; i < tableauCles().length; i++) {
            if (tableauCles()[i] > maxVal) {
                maxVal = tableauCles()[i];
            }
        }
        return maxVal;
    }
}

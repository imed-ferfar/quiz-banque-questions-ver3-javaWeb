/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.entities;

import com.ias.projet_session3.utils.QuestionDejaPresenteException;

/**
 *
 * @author Ferfar Imad Eddine
 */
public class Scenario extends ListeQuestions {

    private ListeQuestions listeQuestion;
    private int typeQuestChoisies;   //choisi par l'utilisateur(1,2,3,4,5,6,7) où  1=QCM, 2=ErreurImg, 4=ResExec
    private int[] tabCle;
    int[] tabTemp;

    // Constructeurs
    public Scenario() {
    }

    public Scenario(int nombreQues, ListeQuestions listeQuestion, int typeQuestChoisies) {
        super();
        this.listeQuestion = listeQuestion;
        this.typeQuestChoisies = typeQuestChoisies;
        tabCle = listeQuestion.tableauCles();

        // creer un tableau pour recevoir les reponses
        tabTemp = new int[nombreQues];
        remplirTableauAleatoire(tabTemp, typeQuestChoisies);
        for (int i = 0; i < tabTemp.length; i++) {
            try {
                ajouterQuestion(listeQuestion.getQuestionN(tabTemp[i]));
            } catch (QuestionDejaPresenteException e) {
                System.out.println("erreur : " + e.getMessage());
            }
        }
        listerQuestion(); //test
    }

    private void remplirTableauAleatoire(int[] tab, int typeQuestChoisies) {
        int val;
        int max = listeQuestion.maxCle();
        int min = listeQuestion.minCle();
        System.out.println("min :" + min + ",   max :" + max);
        System.out.println("Lise aleatoire des questions : " + tab.length);//test visuel
        String titre;
        for (int i = 0; i < tab.length; i++) {
            val = (int) ((Math.random() * max - min) + min + 1);
            titre = getTitre(val);
            switch (typeQuestChoisies) {
                case 1:
                    while (!verifierValeur(tab, val, i) || !titre.equalsIgnoreCase("Choisir la ou les bonnes réponses")) {
                        System.out.println(val + "---->" + (verifierValeur(tab, val, i) + "-----" + titre));
                        val = (int) ((Math.random() * max - min) + min + 1);
                        titre = getTitre(val);
                    }
                    break;

                case 2:
                    while ((!verifierValeur(tab, val, i)) || (!titre.equals("Trouver l'erreur dans ce code"))) {
                        val = (int) ((Math.random() * max - min) + min + 1);
                        titre = getTitre(val);
                    }
                    break;
                case 4:
                    while ((!verifierValeur(tab, val, i)) || (!titre.equals("Trouver le resultat d'execution de ce code"))) {
                        val = (int) ((Math.random() * max - min) + min + 1);
                        titre = getTitre(val);
                    }
                    break;
                case 3:
                    while ((!verifierValeur(tab, val, i)) || (titre.equals("Trouver le resultat d'execution de ce code"))) {
                        System.out.println(val + "---->" + (verifierValeur(tab, val, i) + "-----" + titre));
                        val = (int) ((Math.random() * max - min) + min + 1);
                        titre = getTitre(val);
                    }
                    break;
                case 6:
                    while ((!verifierValeur(tab, val, i)) || (titre.equals("Choisir la ou les bonnes réponses"))) {
                        val = (int) ((Math.random() * max - min) + min + 1);
                        titre = getTitre(val);
                    }
                    break;
                case 5:
                    while ((!verifierValeur(tab, val, i)) || (titre.equals("Trouver l'erreur dans ce code"))) {
                        val = (int) ((Math.random() * max - min) + min + 1);
                        titre = getTitre(val);
                    }
                    break;
                case 7:
                    while (!verifierValeur(tab, val, i)) {
                        val = (int) ((Math.random() * max - min) + min + 1);
                        titre = getTitre(val);
                    }
                    break;
                default:
                    System.out.println("Désolé! veuillez répéter svp");
            }
            tab[i] = val;
            System.out.println(tab[i]);//test visuel
        }
    }

    private boolean verifierValeur(int[] tab, int nombre, int position) {
        int i = 0;
        while ((tabCle[i] != nombre) && (i < tabCle.length-1)){
            i++;
        }
        if (tabCle[i] != nombre) {
            return false;
        }

        for (i = 0; i < position; i++) {
            if (tab[i] == nombre) {
                return false;
            }
        }
        return true;
    }

    private String getTitre(int cle) {
        String titre;
        try {
            titre = listeQuestion.getQuestionN(cle).titre;
        } catch (Exception ex) {
            titre = "";
            System.out.println("erreur de clé :" +cle+" ;"+ ex.getMessage());
        }
        return titre;
    }
}

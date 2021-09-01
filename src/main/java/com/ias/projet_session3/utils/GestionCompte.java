/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ias.projet_session3.utils;

import java.util.List;

/**
 *
 * @author BaDRi
 */
public class GestionCompte {
    
     public static String GenererIdPersonne(List<String> list_id)
        {
            String id_pers = Integer.toString ((int)(1000000 + (Math.random()*(9999999 - 1000000)   ))); // ex : 94589626   = int
            while(list_id.contains(id_pers))
                id_pers = Integer.toString ((int)(1000000 + (Math.random() * (9999999 - 1000000))));
            return id_pers;
        }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Beans.Paciente;
import Beans.Receita;
import DAO.ReceitaDAO;

/**
 *
 * @author gomes
 */
public class ReceitasFacade {
    
    private static final ReceitaDAO receitaDAO = new ReceitaDAO();
    
    public static void inserirReceita(Receita receita){
        receitaDAO.inserirReceita(receita);
    }
}

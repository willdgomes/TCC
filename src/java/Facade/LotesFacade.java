/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Beans.Lote;
import DAO.LoteDAO;

/**
 *
 * @author gomes
 */
public class LotesFacade {
    private static final LoteDAO loteDAO = new LoteDAO();
    
    public static void inserir(Lote lote) {
        loteDAO.inserirLote(lote);
    }
}
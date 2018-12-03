/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Beans.Dispensa;
import DAO.DispensaDAO;

/**
 *
 * @author gomes
 */
public class DispensasFacade {
    private static final DispensaDAO dispDAO = new DispensaDAO();
    
    public static Integer inserir(Dispensa dispensa) {
        return dispDAO.inserirDispensa(dispensa);
    }
    
    public static void inserirDispensaMedicamento(Integer idDispensa, Integer idMedicamento, Integer quantidade) {
        dispDAO.inserirDispensaMedicamentos(idDispensa, idMedicamento, quantidade);
    }
    
}

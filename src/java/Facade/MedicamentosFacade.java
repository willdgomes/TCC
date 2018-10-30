/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Beans.Medicamento;
import DAO.MedicamentoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gomes
 */
public class MedicamentosFacade {
    MedicamentoDAO medDAO = new MedicamentoDAO();
    static List<Medicamento> listaMedicamentos = new ArrayList<Medicamento>();
    
    public List<Medicamento> listarMedicamentos(){
        listaMedicamentos = medDAO.listarMedicamentos();
        return listaMedicamentos;
    }
}

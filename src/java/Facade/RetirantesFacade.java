/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Beans.Paciente;
import Beans.Retirante;
import DAO.RetiranteDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gomes
 */
public class RetirantesFacade {
    RetiranteDAO retDAO = new RetiranteDAO();
    static List<Retirante> listaRetirantes = new ArrayList<Retirante>();
    static Retirante ret = new Retirante();
    
    public List<Retirante> listaRetirantes(){
        listaRetirantes = retDAO.listarRetirantes();
        return listaRetirantes;
    }
    
    public List<Paciente> buscarMedicamentoNome(String nomeRetirante){
        return retDAO.buscarRetirantesParam(nomeRetirante);
    }
    
    public Retirante pegarMedicamentoPorId(int idMedicamento){
        return null;//retDAO.buscarMedicamentoId(idMedicamento);
    }
}

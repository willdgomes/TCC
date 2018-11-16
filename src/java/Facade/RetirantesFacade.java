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
    static RetiranteDAO retDAO = new RetiranteDAO();
    static List<Retirante> listaRetirantes = new ArrayList<Retirante>();
    static Retirante ret = new Retirante();
    
    public static List<Retirante> listaRetirantes(){
        listaRetirantes = retDAO.listarRetirantes();
        return listaRetirantes;
    }
    
    public static List<Retirante> buscarMedicamentoNome(String nomeRetirante){
        return retDAO.buscarRetirantesParam(nomeRetirante);
    }
    
    public static Retirante buscarMedicamentoPorId(String idRetirante){
        return retDAO.buscarMedicamentoId(idRetirante);
    }
    
    public static void cadastrarRetirante(Retirante retirante){
        retDAO.inserirRetirante(retirante);
    }
    
     public static void alterarRetirante(Retirante retirante){
        retDAO.alterarRetirante(retirante);
    }
}

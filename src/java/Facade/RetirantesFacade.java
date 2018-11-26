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
    
    public static List<Retirante> buscarRetirantesNome(String nomeRetirante){
        return retDAO.buscarRetirantesParam(nomeRetirante);
    }
    
    public static Retirante buscarRetirantePorId(String idRetirante){
        return retDAO.buscarRetiranteId(idRetirante);
    }
    
    public static boolean buscarRetirantePaciente(String idPaciente, Integer idRetirante){
        return retDAO.buscarRetirantePaciente(idPaciente, idRetirante);
    }
    
    public static Retirante buscarRetirantePorCpf(String cpfRetirante){
        return retDAO.buscarRetiranteCpf(cpfRetirante);
    }
    
    public static void cadastrarRetirante(Retirante retirante){
        retDAO.inserirRetirante(retirante);
    }
    
    public static void inserirRetirantePaciente(String idPaciente, Integer idRetirante){
        retDAO.inserirRetirantePaciente(idPaciente, idRetirante);
    }
    
     public static void alterarRetirante(Retirante retirante){
        retDAO.alterarRetirante(retirante);
    }
}

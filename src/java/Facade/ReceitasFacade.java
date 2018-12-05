/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Beans.Paciente;
import Beans.Receita;
import DAO.ReceitaDAO;
import java.util.List;

/**
 *
 * @author gomes
 */
public class ReceitasFacade {
    
    private static final ReceitaDAO receitaDAO = new ReceitaDAO();
    
    public static void inserirReceita(Receita receita){
        receitaDAO.inserirReceita(receita);
    }
    
    public static void inserirMedicamentosReceitas(Integer idMedicamento, Integer idReceita){
        receitaDAO.inserirMedicamentoReceita(idMedicamento, idReceita);
    }
    
    public static Receita buscarPorIdPaciente(Integer idPaciente){
        return receitaDAO.buscarReceitaPorIdPaciente(idPaciente);
    }
    
    public static List<Receita> buscarReceitaValidaPorPaciente(Integer idPaciente){
        return receitaDAO.buscarReceitaValidaPorPaciente(idPaciente);
    }
    
    public static Integer buscaTotalReceita(){
        return receitaDAO.buscaTotalReceita();
    }
    
    public static List<Receita> buscarMaiorNumReceitas(){
        return receitaDAO.buscarMaiorNumReceitas();
    }
    
}

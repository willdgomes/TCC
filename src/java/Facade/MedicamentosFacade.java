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
   private static final MedicamentoDAO medDAO = new MedicamentoDAO();
    static List<Medicamento> listaMedicamentos = new ArrayList<Medicamento>();
    static Medicamento med = new Medicamento();
    
    public static void cadastrar(Medicamento medicamento){
        medDAO.inserirMedicamento(medicamento);
    }
    
    public static List<Medicamento> listarMedicamentos(){
        listaMedicamentos = medDAO.listarMedicamentos();
        return listaMedicamentos;
    }
    
    public Medicamento pegarMedicamentoPorNome(String nomeMedicamento){
        return medDAO.buscarMedicamentoNomeInsere(nomeMedicamento);
    }
    
    public Medicamento pegarMedicamentoPorId(int idMedicamento){
        return medDAO.buscarMedicamentoId(idMedicamento);
    }
    
    public List<Medicamento> buscarMedicamento(String pesquisa){
        return medDAO.buscarMedicamentosParam(pesquisa);
    }
    
    public static void alterar(Medicamento medicamento) {
        medDAO.atualizarMedicamento(medicamento);
    }
    
    public static Medicamento buscarMedicamentoPorNomeInserir(String nomeMedicamento) {
        return medDAO.buscarMedicamentoNomeInsere(nomeMedicamento);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Beans.Dispensa;
import DAO.DispensaDAO;
import java.util.List;

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
   public static Integer buscaQntdMedMes(Integer idMedicamento, Integer mes ){
        return   dispDAO.buscaQntdMedMes(idMedicamento, mes);
   } 
   
   public static List<Dispensa> buscaDispensa(){
       return dispDAO.buscaDispensa();
   }
   
   public static Integer medicamentoPorDispensa(Integer idDispensa){
     return   dispDAO.buscaMedPorDispensa(idDispensa);
   }
   
   public static Integer buscaTotalSaidaPorMed(Integer idMedicamento){
       return dispDAO.buscaTotalSaidaPorMed(idMedicamento);
   }
}


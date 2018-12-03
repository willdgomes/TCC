/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Beans.Lote;
import DAO.LoteDAO;
import java.util.List;

/**
 *
 * @author gomes
 */
public class LotesFacade {
    private static final LoteDAO loteDAO = new LoteDAO();
    
    public static void inserir(Lote lote) {
        loteDAO.inserirLote(lote);
    }
    
    public static void atualizarLote(Lote lote) {
        loteDAO.atualizarLote(lote);
    }
    
    public static Lote pegarLotePorNumero(Integer numeroLote){
        return loteDAO.buscarLotePorNumero(numeroLote);
    }
    
    public static List<Lote> pegarLotePorVencimento(){
        return loteDAO.listarLotesPorVencimento();
    }
    
    public static Integer buscarQuantidade(String idMed){
        return loteDAO.buscarQuantidadePorMedicamento(idMed);
    }
    
    public static List<Lote> buscarLotesProxVencimento(){
        return loteDAO.lotesProxVenc();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Beans.Log;
import DAO.LogDAO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gomes
 */
public class LogFacade {
    private static final LogDAO logDAO = new LogDAO();
    
    public static void inserir(Log log) {
        logDAO.inserirLog(log);
    }
    
    public static List<Log> buscarLog(Log log) {
       return logDAO.buscarLogs();
    }
    
    public static List<Log> buscarLogPeriodo(Date inicio, Date fim){
        return logDAO.buscarLogPeriodo(inicio,fim);
    }
    
}

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
    
    public static List<Log> buscarLog() {
       return logDAO.buscarLogs();
    }
    
    public static List<Log> buscarLogPeriodo(String inicio, String fim){
        return logDAO.buscarLogPeriodo(inicio,fim);
    }
    
}

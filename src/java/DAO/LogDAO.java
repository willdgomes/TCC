/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Log;
import DAO.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gomes
 */
public class LogDAO {

    Connection con = null;
    PreparedStatement stmt = null;
    PreparedStatement stmt2 = null;
    ResultSet rs = null;
    private String insereLog = "insert into log (idUsuario, mensagem, data) values (?, ?, current_date())";
    private String insereLogSemUsuario  = "insert into log (mensagem, data) values ( ?, current_date())";
    private String buscaLog = "select log.idLog,log.idUsuario, log.mensagem, log.data, usuarios.nomeUsuario from log " +
                                "LEFT JOIN usuarios ON log.idUsuario = usuarios.idUsuario ORDER BY log.idLog DESC;";
    private String buscaLogPeriodo = "select log.idLog,log.idUsuario, log.mensagem, log.data, usuarios.nomeUsuario from log " +
                                "LEFT JOIN usuarios ON log.idUsuario = usuarios.idUsuario where log.data >= ? and log.data <= ?";

    public void inserirLog(Log l) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(insereLog);
            stmt.setString(1, l.getIdusuario().toString());
            stmt.setString(2, l.getMensagem().toString());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir log" + ex.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
    }

    public void inserirLogSemUsuario(Log l) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(insereLogSemUsuario);
            stmt.setString(1, l.getMensagem());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir log" + ex.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
    }
    
    public List<Log> buscarLogs() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Log> listaLogs = new ArrayList<Log>();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(buscaLog);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Log l = new Log();
                l.setId(Integer.parseInt(rs.getString("idLog")));
                if(!rs.getString("idUsuario").isEmpty())
                    l.setIdusuario(Integer.parseInt(rs.getString("idUsuario")));
                if(!rs.getString("nomeUsuario").isEmpty())
                    l.setNomeUsuario(rs.getString("nomeUsuario"));
                l.setMensagem(rs.getString("mensagem"));
                String stringData = rs.getString("data");
                stringData = stringData.replaceAll("-", "/");
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                java.util.Date dt = null;
                java.sql.Date dt2 = null;
                try {
                    dt = format.parse(stringData);
                    dt2 = new java.sql.Date(dt.getTime());
                } catch (Exception ex) {
                    System.out.println("Erro na data");
                }
                l.setData(dt2);
                listaLogs.add(l);
            }
            return listaLogs;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao listar todos os logs" + ex.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
    }

    public List<Log> buscarLogPeriodo(String inicio, String fim) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Log> listaLogs = new ArrayList<Log>();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(buscaLogPeriodo);
            
            //try{
            //inicio = formatter.parse(formatter.format(inicio));
            //fim = formatter.parse(formatter.format(fim));
            //}catch(Exception ex){
              //  System.out.println("Erro na data");
            //}
            stmt.setString(1, inicio.toString());
            stmt.setString(2, fim.toString());
            rs = stmt.executeQuery();
            while (rs.next()) {
                   Log l = new Log();
                l.setId(Integer.parseInt(rs.getString("idLog")));
                if(!rs.getString("idUsuario").isEmpty())
                    l.setIdusuario(Integer.parseInt(rs.getString("idUsuario")));
                if(!rs.getString("nomeUsuario").isEmpty())
                    l.setNomeUsuario(rs.getString("nomeUsuario"));
                l.setMensagem(rs.getString("mensagem"));
                String stringData = rs.getString("data");
                stringData = stringData.replaceAll("-", "/");
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                java.util.Date dt = null;
                java.sql.Date dt2 = null;
                try {
                    dt = format.parse(stringData);
                    dt2 = new java.sql.Date(dt.getTime());
                } catch (Exception ex) {
                    System.out.println("Erro na data");
                }
                l.setData(dt2);
                listaLogs.add(l);
            }
            return listaLogs;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao listar usuario de pesquisa" + ex.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
    }

}

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
    private String insereLog = "insert into log (idUsuario, mensagem, data) values (?, ?, ?)";
    private String buscaLog = "select idLog,idUsuario, mensagem, datainto from log";
    private String buscaLogPeriodo = "select idLog,idUsuario, mensagem, datainto from log where dnPaciente >= ? and dnPaciente <= ?";

    public void inserirLog(Log l) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(insereLog);
            stmt.setString(1, l.getIdusuario().toString());
            stmt.setString(2, l.getMensagem().toString());
            stmt.setDate(3, (Date) l.getData());
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
                l.setIdusuario(Integer.parseInt(rs.getString("idUsuario")));
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

    public List<Log> buscarLogPeriodo(Date inicio, Date fim) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Log> listaLogs = new ArrayList<Log>();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(buscaLogPeriodo);
            stmt.setString(1, inicio.toString());
            rs = stmt.executeQuery();
            while (rs.next()) {
                Log l = new Log();
                l.setId(Integer.parseInt(rs.getString("idLog")));
                l.setIdusuario(Integer.parseInt(rs.getString("idUsuario")));
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Receita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gomes
 */
public class ReceitaDAO {
    
    private final String stmtInserir = "INSERT INTO receitas (nomeMedico, crmMedico, validadeReceita, idPaciente)"
            + "VALUES (?, ?, ?, ?)";
    private final String stmtBuscarReceitaPorPaciente = "";
    
    
    public void inserirReceita(Receita receita) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtInserir);
            stmt.setString(1, receita.getNomeMedico());
            stmt.setString(2, receita.getCrmMedico());
            stmt.setDate(3, receita.getDataVencimentoReceita());
            stmt.setInt(4, receita.getPaciente().getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir um receita no banco de dados. Origem=" + ex.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();;
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
    }
    
    public Receita buscarReceitaPorNome(String nomePaciente) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Receita receita = new Receita();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtBuscarReceitaPorPaciente);
            stmt.setString(1, nomePaciente);
            rs = stmt.executeQuery();
            if (rs.next()) {
                receita.setId(Integer.parseInt(rs.getString("idReceita")));
            }
            return receita;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar receita no banco de dados. Origem=" + ex.getMessage());
        } finally {
            try {
                rs.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar rs. Ex=" + ex.getMessage());
            };
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();;
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }

    }
}

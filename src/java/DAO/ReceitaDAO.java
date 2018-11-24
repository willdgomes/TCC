/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Paciente;
import Beans.Receita;
import Facade.PacientesFacade;
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
    private final String stmtBuscarReceitaPorPaciente = "SELECT idReceita, nomeMedico, crmMedico, validadeReceita, idPaciente FROM receitas WHERE idPaciente=?";
    private final String stmtInserirMedReceita = "INSERT INTO medicamentos_receitas (idMedicamento, idReceita) VALUES (?, ?)";
    
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
    
    public Receita buscarReceitaPorIdPaciente(Integer idPaciente) {
        Connection con = null;
        Paciente paciente = new Paciente();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Receita receita = new Receita();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtBuscarReceitaPorPaciente);
            stmt.setInt(1, idPaciente);
            rs = stmt.executeQuery();
            if (rs.next()) {
                receita.setId(Integer.parseInt(rs.getString("idReceita")));
                paciente = PacientesFacade.buscarId(rs.getString("idPaciente"));
                receita.setNomeMedico(rs.getString("nomeMedico"));
                receita.setCrmMedico(rs.getString("crmMedico"));
                receita.setDataVencimentoReceita(rs.getDate("validadeReceita"));
                receita.setPaciente(paciente);
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
    
    public void inserirMedicamentoReceita(Integer idMedicamento, Integer idReceita) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtInserirMedReceita);
            stmt.setInt(1, idMedicamento);
            stmt.setInt(2, idReceita);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir um medicamento na receita no banco de dados. Origem=" + ex.getMessage());
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
}

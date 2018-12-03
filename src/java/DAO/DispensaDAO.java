/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Dispensa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gomes
 */
public class DispensaDAO {
    private final String stmtInserir = "INSERT INTO dispensas (dataDispensa, idRetirante, idPaciente, idUsuario)"
            + "VALUES (?, ?, ?, ?)";
    private final String stmtPegaUltimoRegistro = "SELECT LAST_INSERT_ID()";
    private final String stmtInserirDispMed = "INSERT INTO dispensas_medicamentos (idDispensa, idMedicamento, quantidade)"
            + "VALUES (?, ?, ?)";
    
    
    public Integer inserirDispensa(Dispensa dispensa) {
        Connection con = null;
        PreparedStatement stmt = null;
        PreparedStatement stmtUltRegistro = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtInserir);
            stmtUltRegistro = con.prepareStatement(stmtPegaUltimoRegistro);
            stmt.setDate(1, (Date) dispensa.getDataDispensa());
            stmt.setInt(2, dispensa.getRetirante().getIdRetirante());
            stmt.setInt(3, dispensa.getPaciente().getId());
            stmt.setInt(4, dispensa.getUsuario().getIdUsuario());
            stmt.executeUpdate();
            rs = stmtUltRegistro.executeQuery();
            if(rs.next()) {
               Integer idDispensa = rs.getInt("LAST_INSERT_ID()");
                return idDispensa;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao registrar a dispensa de medicamento no banco de dados. Origem=" + ex.getMessage());
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
    
    public void inserirDispensaMedicamentos(Integer idDispensa, Integer idMedicamento, Integer quantidade) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtInserirDispMed);
            stmt.setInt(1, idDispensa);
            stmt.setInt(2, idMedicamento);
            stmt.setInt(3, quantidade);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao registrar a dispensa de medicamento no banco de dados. Origem=" + ex.getMessage());
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

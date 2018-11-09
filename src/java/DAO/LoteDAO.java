/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Lote;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gomes
 */
public class LoteDAO {
    private final String stmtInserir = "INSERT INTO lote (lote, idMedicamento, quantidade, dataVencimento)"
            + "VALUES (?, ?, ?, ?)";
    private final String stmtBuscarLotePorNumero = "SELECT * FROM lote";
    
    public void inserirLote(Lote lote) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtInserir);
            stmt.setInt(1, lote.getId());
            stmt.setInt(2, lote.getMedicamento().getId());
            stmt.setInt(3, lote.getQtde());
            stmt.setDate(4, (Date) lote.getDataVencimento());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir um lote no banco de dados. Origem=" + ex.getMessage());
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
    
    public Lote buscarMedicamentoNomeInsere(Integer nLote) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Lote lote = new Lote();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtBuscarLotePorNumero);
            stmt.setInt(1, nLote);
            rs = stmt.executeQuery();
            if (rs.next()) {
                lote.setId(0);
            }
            return lote;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar medicamento no banco de dados. Origem=" + ex.getMessage());
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

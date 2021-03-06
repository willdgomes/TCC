/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Lote;
import Beans.Medicamento;
import Facade.MedicamentosFacade;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author gomes
 */
public class LoteDAO {
    private final String stmtInserir = "INSERT INTO lote (lote, idMedicamento, quantidade, dataVencimento)"
            + "VALUES (?, ?, ?, ?)";
    private final String stmtBuscarLotePorNumero = "SELECT lote, idMedicamento, quantidade, dataVencimento FROM lote WHERE lote = ?";
    private final String stmtAtualizarLote = "UPDATE lote SET quantidade = ? WHERE lote = ?";
    private final String stmtBuscarQntdMedicamento="SELECT SUM(quantidade) FROM lote where idMedicamento = ?";
    private final String stmtBuscarLoteVenc = "SELECT lote, idMedicamento, quantidade, dataVencimento " +
            "FROM lote ORDER BY dataVencimento LIMIT 3";

    private final String stmtLoteVencendoDispensa = "SELECT lote, idMedicamento, quantidade, dataVencimento FROM lote WHERE idMedicamento=? AND quantidade>? AND dataVencimento > (SELECT CURDATE()) ORDER BY dataVencimento ASC";

    
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
    
    public void atualizarLote(Lote lote) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtAtualizarLote);
            stmt.setInt(1, lote.getQtde());
            stmt.setInt(2, lote.getId());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar o lote no banco de dados. Origem=" + ex.getMessage());
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
    
    public Lote buscarLotePorNumero(Integer nLote) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Lote lote = new Lote();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtBuscarLotePorNumero);
            stmt.setInt(1, nLote);
            rs = stmt.executeQuery();
            MedicamentosFacade medFacade = new MedicamentosFacade();
            Medicamento medicamento = new Medicamento();
            if (rs.next()) {
                medicamento = medFacade.pegarMedicamentoPorId(rs.getInt("idMedicamento"));
                lote.setId(Integer.parseInt(rs.getString("lote")));
                lote.setMedicamento(medicamento);
                lote.setQtde(rs.getInt("quantidade"));
                lote.setDataVencimento(rs.getDate("dataVencimento"));
                return lote;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar lote no banco de dados. Origem=" + ex.getMessage());
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
    
    public Lote lotesPorVencimento(Integer idMedicamento, Integer qtde) {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Lote lote = new Lote();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtLoteVencendoDispensa);
            stmt.setInt(1, idMedicamento);
            stmt.setInt(2, qtde);
            rs = stmt.executeQuery();
            if (rs.next()) {
                lote.setId(Integer.parseInt(rs.getString("lote")));
                Medicamento medicamento = new Medicamento();
                medicamento.setId(rs.getInt("idMedicamento"));
                lote.setMedicamento(medicamento);
                lote.setQtde(rs.getInt("quantidade"));
                lote.setDataVencimento(rs.getDate("dataVencimento"));
            }
            return lote;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar lote no banco de dados. Origem=" + ex.getMessage());
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
    
    public Integer buscarQuantidadePorMedicamento(String idMed) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtBuscarQntdMedicamento);
            stmt.setString(1, idMed);
            rs = stmt.executeQuery();
            if (rs.next()) {
               Integer quantidade = rs.getInt("SUM(quantidade)");
                return quantidade;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar quantidade de medicamento no banco de dados. Origem=" + ex.getMessage());
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
    
    public List<Lote> lotesProxVenc(){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtBuscarLoteVenc);
            rs = stmt.executeQuery();
            List<Lote> loteLista = new ArrayList<Lote>();
            while (rs.next()) {
                Lote lote = new Lote();
                Medicamento medicamento = new Medicamento();
                medicamento = MedicamentosFacade.pegarMedicamentoPorId(rs.getInt("idMedicamento"));
                lote.setId(Integer.parseInt(rs.getString("lote")));
                lote.setMedicamento(medicamento);
                lote.setQtde(rs.getInt("quantidade"));
                lote.setDataVencimento(rs.getDate("dataVencimento"));
                loteLista.add(lote);
            }
            return loteLista;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar lote no banco de dados. Origem=" + ex.getMessage());
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

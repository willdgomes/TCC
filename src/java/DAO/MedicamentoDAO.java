/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Medicamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Eu
 */
public class MedicamentoDAO {
      private final String stmtInserir = "INSERT INTO medicamentos (nomeMedicamento, loteMedicamento, dataVencimento, descricao)"
              + "VALUES (?, ?, ?, ?)";
    private final String stmtListarMedicamentos = "SELECT idMedicamento, nomeMedicamento, loteMedicamento, dataVencimento, descricao From medicamentos";
    private final String stmtRemoverMedicamentos = "DELETE FROM medicamentos WHERE idMedicamento = ?";
    private final String stmtAtualizarMedicamentos = "UPDATE medicamentos SET nomeMedicamento = ?, loteMedicamento = ?, dataVencimento = ?, descricao = ? WHERE idMedicamento = ?";
    
    public void inserirMedicamento(Medicamento med) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtInserir);
            stmt.setString(1, med.getNome());
            stmt.setString(2, med.getLote());
            stmt.setDate(3, med.getDataVencimento());
            stmt.setString(4, med.getDescricao());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir um medicamento no banco de dados. Origem=" + ex.getMessage());
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

    public List<Medicamento> listarMedicamentos() {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Medicamento> listaMedicamentos = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtListarMedicamentos);
            rs = stmt.executeQuery();
            listaMedicamentos = new ArrayList<Medicamento>();
            while (rs.next()) {
                Medicamento medicamento = new Medicamento();
                medicamento.setId(rs.getInt("idMedicamento"));
                medicamento.setNome(rs.getString("nomeMedicamento"));
                medicamento.setLote(rs.getString("loteMedicamento"));
                medicamento.setDataVencimento(rs.getDate("dataVencimento"));
                medicamento.setDescricao(rs.getString("descricao"));
                listaMedicamentos.add(medicamento);
            }  
        return listaMedicamentos;
        }
    catch(SQLException ex){
            throw new RuntimeException("Erro ao listar os medicamentos no banco de dados. Origem=" + ex.getMessage());
    }
        finally{
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

    public void removerMedicamento(Medicamento medicamento) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtRemoverMedicamentos);
            stmt.setInt(1, medicamento.getId());
            stmt.executeUpdate();
        }
        catch(SQLException ex){
            throw new RuntimeException("Erro ao excluir o medicamento no banco de dados. Origem=" + ex.getMessage());
        }
        finally{
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

    public void atualizarMedicamento(Medicamento medicamento) {
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtAtualizarMedicamentos);
            stmt.setString(1, medicamento.getNome());
            stmt.setString(2, medicamento.getLote());
            stmt.setDate(3, medicamento.getDataVencimento());
            stmt.setString(4, medicamento.getDescricao());
            stmt.setInt(5, medicamento.getId());
            stmt.executeUpdate();
            
        }
        catch(SQLException ex){
            throw new RuntimeException("Erro ao atualizar o medicamento no banco de dados. Origem=" + ex.getMessage());
        }
        finally{
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

//    public List<Medicamento> buscarMedicamentoNome(String nomeRemedio) {
//        Connection con = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        List<Medicamento> listaMedicamentos = null;
//        String stmtBuscarMedicamento = "select nomePaciente from pacientes"; 
//        try{
//            con = ConnectionFactory.getConnection();  
//            
//            stmt = con.prepareStatement(stmtBuscarMedicamento);
//            rs = stmt.executeQuery();
//            listaMedicamentos = new ArrayList<Medicamento>();
//            while (rs.next()) {
//                Medicamento medicamento = new Medicamento();
//                listaMedicamentos.add(medicamento);
//            }  
//        return listaMedicamentos;            
//        }catch(SQLException ex){
//            throw new RuntimeException("Erro ao listar os clientes no banco de dados. Origem="+ex.getMessage());            
//        }finally{
//            try{rs.close();}catch(Exception ex){System.out.println("Erro ao fechar rs. Ex="+ex.getMessage());};
//            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
//            try{con.close();;}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};                
//        }
//    
//    }

}

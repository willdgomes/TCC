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
import java.util.List;

/**
 *
 * @author Eu
 */
public class MedicamentoDAO {
      private final String stmtInserir = "INSERT INTO pacientes (cpfPaciente, nomePaciente, dnPaciente, telefone, "
            + "cep, cidade, estado, bairro, endereco, numEndereco, complemento, email) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String stmtListarMedicamentos = "select nomePaciente from pacientes";
    private final String stmtRemoverClientes = "DELETE FROM cliente WHERE idCliente = ?";
    private final String stmtAtualizarClientes = "UPDATE cliente SET nome = ?, sobrenome = ?, telefone = ? WHERE idCliente = ?";
    
    public void inserirMedicamento(Medicamento med) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtInserir);
            stmt.setString(1, med.getNome());
            stmt.setString(2, med.getDescricao());
            stmt.setDate(3, med.getDataVencimento());
            stmt.setString(4, med.getDescricao());
            stmt.setString(5, med.getLote());
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
                medicamento.setNome("teste");
                listaMedicamentos.add(medicamento);
            }  
        return listaMedicamentos;
        }
    catch(SQLException ex){
            throw new RuntimeException("Erro ao listar os clientes no banco de dados. Origem=" + ex.getMessage());
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

//    public void removerCliente(Cliente cliente) {
//        Connection con = null;
//        PreparedStatement stmt = null;
//        try {
//            con = ConnectionFactory.getConnection();
//            stmt = con.prepareStatement(stmtRemoverClientes);
//            stmt.setInt(1, cliente.getIdCliente());
//            stmt.executeUpdate();
//        }
//        catch(SQLException ex){
//            throw new RuntimeException("Erro ao excluir o cliente no banco de dados. Origem=" + ex.getMessage());
//        }
//        finally{
//            try {
//                stmt.close();
//            } catch (Exception ex) {
//                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
//            };
//            try {
//                con.close();;
//            } catch (Exception ex) {
//                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
//            };
//        }
//            
//    }
//
//    public void atualizarCliente(Cliente cliente) {
//        Connection con = null;
//        PreparedStatement stmt = null;
//        try{
//            con = ConnectionFactory.getConnection();
//            stmt = con.prepareStatement(stmtAtualizarClientes);
//            stmt.setString(1, cliente.getNome());
//            stmt.setString(2, cliente.getSobrenome());
//            stmt.setString(3, cliente.getTelefone());
//            stmt.setInt(4, cliente.getIdCliente());
//            stmt.executeUpdate();
//            
//        }
//        catch(SQLException ex){
//            throw new RuntimeException("Erro ao atualizar o cliente no banco de dados. Origem=" + ex.getMessage());
//        }
//        finally{
//            try {
//                stmt.close();
//            } catch (Exception ex) {
//                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
//            };
//            try {
//                con.close();;
//            } catch (Exception ex) {
//                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
//            };
//        }
//    }

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

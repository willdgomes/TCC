/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Medicamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Eu
 */
public class MedicamentoDAO {
      private final String stmtInserir = "INSERT INTO pacientes (cpfPaciente, nomePaciente, dnPaciente, telefone, "
            + "cep, cidade, estado, bairro, endereco, numEndereco, complemento, email) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String stmtBuscarClientes = "SELECT idCliente, nome, sobrenome, telefone FROM cliente";
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

//    public List<Medicamento> buscarMedicamento() {
//
//        Connection con = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        List<Cliente> listaClientes = null;
//        try {
//            con = ConnectionFactory.getConnection();
//            stmt = con.prepareStatement(stmtBuscarClientes);
//            rs = stmt.executeQuery();
//            listaClientes = new ArrayList<Cliente>();
//            while (rs.next()) {
//                Cliente cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
//                listaClientes.add(cliente);
//            }  
//        return listaClientes;
//        }
//    catch(SQLException ex){
//            throw new RuntimeException("Erro ao listar os clientes no banco de dados. Origem=" + ex.getMessage());
//    }
//        finally{
//            try {
//            rs.close();
//        } catch (Exception ex) {
//            System.out.println("Erro ao fechar rs. Ex=" + ex.getMessage());
//        };
//        try {
//            stmt.close();
//        } catch (Exception ex) {
//            System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
//        };
//        try {
//            con.close();;
//        } catch (Exception ex) {
//            System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
//        };
//    }
//
//}

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
//
//    public List<Cliente> buscarClientesParam(String parametro, String colunaPesquisa) {
//        Connection con = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        List<Cliente> listaClientes = null;
//        String stmtBuscarClientesParam = "SELECT idCliente, nome, sobrenome, telefone FROM cliente WHERE " + colunaPesquisa + " LIKE ?"; 
//        try{
//            con = ConnectionFactory.getConnection();  
//            
//            stmt = con.prepareStatement(stmtBuscarClientesParam); 
//            stmt.setString(1,'%'+parametro+'%');
//            rs = stmt.executeQuery();
//            listaClientes = new ArrayList<Cliente>();
//            while (rs.next()) {
//                Cliente cliente = new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
//                listaClientes.add(cliente);
//            }  
//        return listaClientes;            
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

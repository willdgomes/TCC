/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gomes
 */
public class PacienteDAO {
    
    private final String stmtInserir = "INSERT INTO pacientes (cpfPaciente, nomePaciente, dnPaciente, telefone, "
            + "cep, cidade, estado, bairro, endereco, numEndereco, complemento, email) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String stmtBuscarPacientess = "SELECT idPaciente, cpfPaciente, nomePaciente, dnPaciente, telefone, "
            + "cep, cidade, estado, bairro, endereco, numEndereco, complemento, email FROM pacientes";
    private final String stmtRemoverClientes = "DELETE FROM cliente WHERE idCliente = ?";
    private final String stmtAtualizarClientes = "UPDATE cliente SET nome = ?, sobrenome = ?, telefone = ? WHERE idCliente = ?";
    
    public void inserirPaciente(Paciente paciente) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtInserir);
            stmt.setString(1, paciente.getCpf());
            stmt.setString(2, paciente.getNome());
            stmt.setDate(3, paciente.getDataNascimento());
            stmt.setString(4, paciente.getTelefone());
            stmt.setString(5, paciente.getCep());
            stmt.setString(6, paciente.getCidade());
            stmt.setString(7, paciente.getEstado());
            stmt.setString(8, paciente.getBairro());
            stmt.setString(9, paciente.getEndereco());
            stmt.setString(10, paciente.getNumEndereco());
            stmt.setString(11, paciente.getComplemento());
            stmt.setString(12, paciente.getEmail());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir um cliente no banco de dados. Origem=" + ex.getMessage());
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
      public List<Paciente> buscarTodosPacientes() {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Paciente> listaPacientes = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtInserir);
            rs = stmt.executeQuery();
            listaPacientes = new ArrayList<Paciente>();
            while (rs.next()) {
                Paciente paciente = new Paciente(rs.getInt(0), rs.getString(2), rs.getString(3), rs.getDate(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),
                rs.getString(11),rs.getString(12),rs.getString(13));
                listaPacientes.add(paciente);
            }  
        return listaPacientes;
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

//    public List<Cliente> buscarClientes() {
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

    public List<Paciente> buscarPacientesParam(/*String parametro, */String pesquisa) {
       // Departamento departamento = new Departamento();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Paciente> listaPacientes = null;
        String stmtBuscarPacientesParam = "SELECT idPaciente, cpfPaciente, nomePaciente, dnPaciente, telefone, "
            + "cep, cidade, estado, bairro, endereco, numEndereco, complemento, email FROM pacientes WHERE nomePaciente LIKE ?"; 
        try{
            con = ConnectionFactory.getConnection();  
            stmt = con.prepareStatement(stmtBuscarPacientesParam); 
            stmt.setString(1,'%'+pesquisa+'%');
            rs = stmt.executeQuery();
            listaPacientes = new ArrayList<Paciente>();
            while (rs.next()) {
                Paciente p = new Paciente();
//                f.setNome(rs.getString("nome"));
//                f.setSobreNome(rs.getString("sobreNome"));
//                f.setCpf(rs.getString("cpf"));
//                f.setRg(rs.getString("rg"));
//                f.setTelefone(rs.getString("telefone"));
//                f.setCargo(rs.getString("cargo"));
//                f.setNivel(rs.getInt("nivel"));
//                f.setDepartamento(rs.getString("Departamento"));
//                listaPacientes.add(f);
            }  
        return listaPacientes;            
        }catch(SQLException ex){
            throw new RuntimeException("Erro ao listar os pacientes no banco de dados. Origem="+ex.getMessage());            
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println("Erro ao fechar rs. Ex="+ex.getMessage());};
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();;}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};                
        }
    
    }

         
}

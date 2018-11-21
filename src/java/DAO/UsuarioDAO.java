/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Usuario;
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
public class UsuarioDAO {
    Connection con = null;
    PreparedStatement stmt = null;
    PreparedStatement stmt2 = null;
    ResultSet rs = null; 
    private String stmtBuscaUsuario = "select idUsuario, nomeUsuario, emailUsuario, login,"
            + "senha, perfil, dataNascimento from usuarios where login = ? and senha = ?"; //"select idUsuario, nome, login, nome, senha from Usuario where login = ? and senha = ?";
    private String stmtBuscaUsuarioParam = "select idUsuario, nomeUsuario, emailUsuario, login,"
            + "perfil, dataNascimento from usuarios where nomeUsuario LIKE ?"; 
    private String stmtBuscaTodosUsuario = "select idUsuario, nomeUsuario, emailUsuario, login,"
            + "perfil, dataNascimento from usuarios"; 
    private String insereUsuario = "insert into usuarios (nomeUsuario, emailUsuario, login, senha, perfil, dataNascimento) values (?, ?, ?, ?, ?, ?)";
    private String atualizarUsuario = "UPDATE usuarios SET nomeUsuario = ?, emailUsuario = ?, login = ?, perfil = ?, dataNascimento = ? WHERE idUsuario = ?";
    private String deletarUsuario = "delete from usuario where idUsuario = ?";
    private String stmtBuscaUsuarioId = "select idUsuario, nomeUsuario, emailUsuario, login,"
            + "perfil, dataNascimento from usuarios where idUsuario = ?";
    public Usuario lerUsuario (String login, String senha){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtBuscaUsuario);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();   
            if (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setNome(rs.getString("nomeUsuario"));
                u.setEmail(rs.getString("emailUsuario"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setPerfil(rs.getString("perfil"));
                u.setDataNascimento(rs.getDate("dataNascimento"));
                return u;
            }
            else {
                return null;
            }
        }
        catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar usuario" + ex.getMessage());
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
    
    public void inserirUsuario (Usuario u){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(insereUsuario);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getLogin());
            stmt.setString(4, u.getSenha());
            stmt.setString(5, u.getPerfil());
            stmt.setDate(6, (Date) u.getDataNascimento());
            stmt.executeUpdate();   
        }
        catch (SQLException ex) {
            throw new RuntimeException("Erro ao cadastrar usuario" + ex.getMessage());
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
    
       public void atualizarUsuario (Usuario u){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(atualizarUsuario);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getLogin());
            stmt.setString(4, u.getPerfil());
            stmt.setDate(5, (Date) u.getDataNascimento());
            stmt.setString(6, u.getIdUsuario().toString());
            stmt.executeUpdate();   
        }
        catch (SQLException ex) {
            throw new RuntimeException("Erro ao cadastrar usuario" + ex.getMessage());
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
    
    public List<Usuario> buscarUsuarios(){
     Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        try {
            con = ConnectionFactory.getConnection();  
            stmt = con.prepareStatement(stmtBuscaTodosUsuario); 
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(Integer.parseInt(rs.getString("idPaciente")));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setLogin(rs.getString("login"));
                u.setPerfil(rs.getString("perfil"));
                String stringData = rs.getString("dnUsuario");  
                stringData = stringData.replaceAll("-", "/");
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                java.util.Date dt = null;
                java.sql.Date dt2 = null;
               try{
                 dt = format.parse(stringData);
                 dt2 = new java.sql.Date(dt.getTime());
               }
               catch(Exception ex){
                 System.out.println("Erro na data");
               }
                u.setDataNascimento(dt2);
                listaUsuarios.add(u);
            }  
        return listaUsuarios;            
        }
        catch (SQLException ex) {
            throw new RuntimeException("Erro ao listar todos usuario" + ex.getMessage());
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
   
    public List<Usuario> buscarUsuarioParam (String pesquisa){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        try {
            con = ConnectionFactory.getConnection();  
            stmt = con.prepareStatement(stmtBuscaUsuarioParam); 
            stmt.setString(1,'%'+pesquisa+'%');
            rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setIdUsuario(Integer.parseInt(rs.getString("idPaciente")));
                u.setNome(rs.getString("nome"));
                u.setEmail(rs.getString("email"));
                u.setLogin(rs.getString("login"));
                u.setPerfil(rs.getString("perfil"));
                String stringData = rs.getString("dnUsuario");  
                stringData = stringData.replaceAll("-", "/");
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                java.util.Date dt = null;
                java.sql.Date dt2 = null;
               try{
                 dt = format.parse(stringData);
                 dt2 = new java.sql.Date(dt.getTime());
               }
               catch(Exception ex){
                 System.out.println("Erro na data");
               }
                u.setDataNascimento(dt2);
                listaUsuarios.add(u);
            }  
        return listaUsuarios;            
        }
        catch (SQLException ex) {
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
    
    public Usuario buscarUsuarioId (Integer id){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = new Usuario();
        try {
            con = ConnectionFactory.getConnection();  
            stmt = con.prepareStatement(stmtBuscaUsuarioId); 
            stmt.setString(1,id.toString());
            rs = stmt.executeQuery();
            while (rs.next()) {
                usuario.setIdUsuario(Integer.parseInt(rs.getString("idPaciente")));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setLogin(rs.getString("login"));
                usuario.setPerfil(rs.getString("perfil"));
                String stringData = rs.getString("dnUsuario");  
                stringData = stringData.replaceAll("-", "/");
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                java.util.Date dt = null;
                java.sql.Date dt2 = null;
               try{
                 dt = format.parse(stringData);
                 dt2 = new java.sql.Date(dt.getTime());
               }
               catch(Exception ex){
                 System.out.println("Erro na data");
               }
                usuario.setDataNascimento(dt2);
            }  
        return usuario;            
        }
        catch (SQLException ex) {
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

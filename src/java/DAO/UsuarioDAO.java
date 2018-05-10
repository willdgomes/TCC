/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Usuario;
import DAO.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gomes
 */
public class UsuarioDAO {
    Connection con = null;
    PreparedStatement stmt = null;
    PreparedStatement stmt2 = null;
    ResultSet rs = null; 
    private String stmtBuscaUsuario = "select login, senha from usuarios where login=? and senha=?"; //"select idUsuario, login, nome, senha from Usuario where login = ? and senha = ?";
    private String insereUsuario = "insert into Usuario (login, nome, senha) values (?, ?, ?)";
    private String deletarUsuario = "delete from usuario where idUsuario = ?";
    
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
                u.setNome(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
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
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getNome());
            stmt.setString(3, u.getSenha());
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
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author gomes
 */
public class UsuarioDAO {
    private String stmtBuscaUsuario = "select idUsuario, login, nome, senha from Usuario where login = ? and senha = ?";
    
    
    
}

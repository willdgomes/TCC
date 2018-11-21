/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Beans.Usuario;
import DAO.UsuarioDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gomes
 */
public class UsuariosFacade {
   private static final UsuarioDAO usuDAO = new UsuarioDAO();
    static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
    static Usuario usu = new Usuario();
    
    public static List<Usuario> listarUsuarios(){
        listaUsuarios = usuDAO.buscarUsuarios();
        return listaUsuarios;
    }
     
    public static Usuario buscarUsuarioPorId(Integer idUsuario){
        return usuDAO.buscarUsuarioId(idUsuario);
    }
    
    public static List<Usuario> buscarUsuario(String pesquisa){
        return usuDAO.buscarUsuarioParam(pesquisa);
    }
    
      public static void cadastrar(Usuario usuario) {
        usuDAO.inserirUsuario(usuario);
    }
    
      public static void alterar(Usuario usuario) {
        usuDAO.atualizarUsuario(usuario);
    }
}

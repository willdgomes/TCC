/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.Date;

/**
 *
 * @author gomes
 */
public class Log  {
    
    private Integer id;
    private Integer idUsuario;
    private String nomeUsuario;
    private String mensagem;
    private Date data;
    
    
    public Log(){
        
    }

    public Log(Integer idUsuario, String mensagem) {
        this.idUsuario = idUsuario;
        this.mensagem = mensagem;
    }
    
    public Log( String mensagem) {
        this.mensagem = mensagem;        
    }
    
    public Integer getIdusuario() {
        return idUsuario;
    }

    public void setIdusuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

     public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
   
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

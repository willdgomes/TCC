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
    private Integer idusuario;
    private String mensagem;
    private Date data;
    
    
    public Log(){
        
    }

    public Log(Integer idusuario, String mensagem) {
        this.id = id;
        this.idusuario = idusuario;
        this.mensagem = mensagem;
        this.data = data;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

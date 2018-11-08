/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author gomes
 */
public class Dispensa implements Serializable {
    
    private Integer id;
    private Integer quantidade;
    private Date dataDispensa;
    private Retirante retirante;
    private Paciente paciente;
    private Usuario usuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataDispensa() {
        return dataDispensa;
    }

    public void setDataDispensa(Date dataDispensa) {
        this.dataDispensa = dataDispensa;
    }

    public Retirante getRetirante() {
        return retirante;
    }

    public void setRetirante(Retirante retirante) {
        this.retirante = retirante;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

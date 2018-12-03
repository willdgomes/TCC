/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.sql.Date;

/**
 *
 * @author gomes
 */
public class Retirante {
    
    private Integer idRetirante;
    private String nomeRetirante;
    private String cpfRetirante;
    private Date dnRetirante;
    private String telefone;
    private String cep;
    private String cidade;
    private String estado;
    private String bairro;
    private String endereco;
    private String numEndereco;
    private String complemento;
    private String email;
    private Paciente paciente;
    private String vincolo;

    public Integer getIdRetirante() {
        return idRetirante;
    }

    public void setIdRetirante(Integer idRetirante) {
        this.idRetirante = idRetirante;
    }
    
     public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getNomeRetirante() {
        return nomeRetirante;
    }

    public void setNomeRetirante(String nomeRetirante) {
        this.nomeRetirante = nomeRetirante;
    }

    public String getCpfRetirante() {
        return cpfRetirante;
    }

    public void setCpfRetirante(String cpfRetirante) {
        this.cpfRetirante = cpfRetirante;
    }

    public Date getDnRetirante() {
        return dnRetirante;
    }

    public void setDnRetirante(Date dnRetirante) {
        this.dnRetirante = dnRetirante;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumEndereco() {
        return numEndereco;
    }

    public void setNumEndereco(String numEndereco) {
        this.numEndereco = numEndereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVincolo() {
        return vincolo;
    }

    public void setVincolo(String vincolo) {
        this.vincolo = vincolo;
    }
}

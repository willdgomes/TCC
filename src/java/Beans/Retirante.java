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
class Retirante {
    
    private int idRetirante;
    private String cpfRetirante;
    private String nomeRetirante;
    private Date dnRetirante;
    private String telefone;
    private String cep;
    private String cidade;
    private String estado;
    private String bairro;
    private String endereco;
    private int numEndereco;
    private String complemento;
    private String email;
    private String vincolo;

    public int getIdRetirante() {
        return idRetirante;
    }

    public void setIdRetirante(int idRetirante) {
        this.idRetirante = idRetirante;
    }

    public String getCpfRetirante() {
        return cpfRetirante;
    }

    public void setCpfRetirante(String cpfRetirante) {
        this.cpfRetirante = cpfRetirante;
    }

    public String getNomeRetirante() {
        return nomeRetirante;
    }

    public void setNomeRetirante(String nomeRetirante) {
        this.nomeRetirante = nomeRetirante;
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

    public int getNumEndereco() {
        return numEndereco;
    }

    public void setNumEndereco(int numEndereco) {
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

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
public class Paciente {

    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String telefone;
    private String cep;
    private String cidade;
    private String estado;
    private String bairro;
    private String endereco;
    private String numEndereco;
    private String complemento;
    private String email;
    private String dn;
    private Integer id;

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }
    
//    public Paciente(String nome, String cpf, String dataNascimento, String cep, String cidade, String estado, String bairro, String endereco, String numEndereco) {
//        this.nome = nome;
//        this.cpf = cpf;
//        this.dataNascimento = dataNascimento;
//        this.cep = cep;
//        this.cidade = cidade;
//        this.estado = estado;
//        this.bairro = bairro;
//        this.endereco = endereco;
//        this.numEndereco = numEndereco;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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
     
    public Paciente() {
    }

    public Paciente(Integer id,String nome, String cpf, Date dataNascimento, String telefone, String cep, String cidade, String estado, String bairro, String endereco, String numEndereco, String complemento, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.bairro = bairro;
        this.endereco = endereco;
        this.numEndereco = numEndereco;
        this.complemento = complemento;
        this.email = email;
    }

}

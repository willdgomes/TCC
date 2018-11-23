/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author gomes
 */
public class Receita implements Serializable {
    
    private Integer id;
    private Paciente paciente;
    private String nomeMedico;
    private String crmMedico;
    private Date dataVencimentoReceita;
    
    public Receita(Paciente paciente, String nomeMedico, String crmMedico, Date dataVencimento){
        this.paciente=paciente;
        this.nomeMedico=nomeMedico;
        this.crmMedico=crmMedico;
        this.dataVencimentoReceita=dataVencimento;
    }
    
    public Receita(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getCrmMedico() {
        return crmMedico;
    }

    public void setCrmMedico(String crmMedico) {
        this.crmMedico = crmMedico;
    }

    public Date getDataVencimentoReceita() {
        return dataVencimentoReceita;
    }

    public void setDataVencimentoReceita(Date dataVencimentoReceita) {
        this.dataVencimentoReceita = dataVencimentoReceita;
    }
}

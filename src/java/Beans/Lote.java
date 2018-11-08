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
public class Lote implements Serializable {
    
    private Integer id;
    private Medicamento medicamento;
    private Integer qtde;
    private Date dataVencimento;
    
    public Lote(){
        
    }
    
    public Lote(Integer id, Medicamento medicamento, Integer qtde, Date dataVencimento){
        this.id=id;
        this.medicamento=medicamento;
        this.qtde=qtde;
        this.dataVencimento=dataVencimento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}

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
public class LoteDAO {
    private final String stmtInserir = "INSERT INTO lote (nomeMedicamento, descricao, nomeFabricante, composicao, dosagem, medida)"
            + "VALUES (?, ?, ?, ?, ?, ?)";
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Retirante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author gomes
 */
public class RetiranteDAO {
    
    private final String stmtInserir = "INSERT INTO retirantes (cpfRetirante, nomeRetirante, dnRetirante, telefone, "
            + "cep, cidade, estado, bairro, endereco, numEndereco, complemento, email, vincolo) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    
    public void inserirPaciente(Retirante retirante) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtInserir);
            stmt.setString(1, retirante.getCpfRetirante());
            stmt.setString(2, retirante.getNomeRetirante());
            stmt.setDate(3, retirante.getDnRetirante());
            stmt.setString(4, retirante.getTelefone());
            stmt.setString(5, retirante.getCep());
            stmt.setString(6,retirante.getCidade());
            stmt.setString(7, retirante.getEstado());
            stmt.setString(8, retirante.getBairro());
            stmt.setString(9, retirante.getEndereco());
            stmt.setString(10, retirante.getNumEndereco());
            stmt.setString(11, retirante.getComplemento());
            stmt.setString(12, retirante.getEmail());
            stmt.setString(13, retirante.getVincolo());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir um retirante no banco de dados. Origem=" + ex.getMessage());
        } finally {
            try {
                stmt.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar stmt. Ex=" + ex.getMessage());
            };
            try {
                con.close();;
            } catch (Exception ex) {
                System.out.println("Erro ao fechar conexão. Ex=" + ex.getMessage());
            };
        }
    }
    
}

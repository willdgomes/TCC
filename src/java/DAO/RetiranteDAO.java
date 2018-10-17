/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Paciente;
import Beans.Retirante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
  
       public List<Paciente> buscarRetirantesParam(/*String parametro, */String pesquisa) {
       // Departamento departamento = new Departamento();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Paciente> listaRetirantes = null;
        String stmtBuscarRetirantesParam = "SELECT idRetirante, cpfRetirante, nomeRetirante, dnRetirante, telefone, "
            + "cep, cidade, estado, bairro, endereco, numEndereco, complemento, email, vincolo FROM retirantes WHERE nomePaciente LIKE ?"; 
        try{
            con = ConnectionFactory.getConnection();  
            stmt = con.prepareStatement(stmtBuscarRetirantesParam); 
            stmt.setString(1,'%'+pesquisa+'%');
            rs = stmt.executeQuery();
            listaRetirantes = new ArrayList<Paciente>();
            while (rs.next()) {
                Paciente p = new Paciente();
                p.setId(Integer.parseInt(rs.getString("idRetirante")));
                p.setNome(rs.getString("nomeRetirante"));
                p.setCpf(rs.getString("cpfRetirannte"));
                String stringData = rs.getString("dnRetirannte");  
                stringData = stringData.replaceAll("-", "/");
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                java.util.Date dt = null;
                java.sql.Date dt2 = null;
               try{
                 dt = format.parse(stringData);
                 dt2 = new java.sql.Date(dt.getTime());
               }
               catch(Exception ex){
                 System.out.println("Erro na data");
               }
                p.setDataNascimento(dt2);
                listaRetirantes.add(p);
            }  
        return listaRetirantes;            
        }catch(SQLException ex){
            throw new RuntimeException("Erro ao listar os retirantes no banco de dados. Origem="+ex.getMessage());            
        }finally{
            try{rs.close();}catch(Exception ex){System.out.println("Erro ao fechar rs. Ex="+ex.getMessage());};
            try{stmt.close();}catch(Exception ex){System.out.println("Erro ao fechar stmt. Ex="+ex.getMessage());};
            try{con.close();;}catch(Exception ex){System.out.println("Erro ao fechar conexão. Ex="+ex.getMessage());};                
        }
    
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Dispensa;
import java.sql.Connection;
import java.sql.Date;
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
public class DispensaDAO {
    private final String stmtInserir = "INSERT INTO dispensas (dataDispensa, idRetirante, idPaciente, idUsuario)"
            + "VALUES (?, ?, ?, ?)";
    private final String stmtPegaUltimoRegistro = "SELECT LAST_INSERT_ID()";
    private final String stmtInserirDispMed = "INSERT INTO dispensas_medicamentos (idDispensa, idMedicamento, quantidade)"
            + "VALUES (?, ?, ?)";
    private final String stmtBuscaQntdMedMes = "SELECT SUM(dispensas_medicamentos.quantidade) " +
"FROM dispensas_medicamentos " +
"INNER JOIN dispensas " +
"ON dispensas.idDispensa = dispensas_medicamentos.idDispensa " +
"WHERE MONTH(dispensas.dataDispensa) = ? " +
"AND dispensas_medicamentos.idMedicamento = ?";
  
    private final String stmtBuscaTotalSaida = "SELECT SUM(dispensas_medicamentos.quantidade) " +
"FROM dispensas_medicamentos " +
"WHERE dispensas_medicamentos.idMedicamento = ? ";
    private final String stmtBuscaDispensa="SELECT * FROM dispensas order by dataDispensa asc";
    private final String stmtBuscaMedPorDispensa="select idMedicamento from dispensas_medicamentos where idDispensa = ? ";
    
    public Integer inserirDispensa(Dispensa dispensa) {
        Connection con = null;
        PreparedStatement stmt = null;
        PreparedStatement stmtUltRegistro = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtInserir);
            stmtUltRegistro = con.prepareStatement(stmtPegaUltimoRegistro);
            stmt.setDate(1, (Date) dispensa.getDataDispensa());
            stmt.setInt(2, dispensa.getRetirante().getIdRetirante());
            stmt.setInt(3, dispensa.getPaciente().getId());
            stmt.setInt(4, dispensa.getUsuario().getIdUsuario());
            stmt.executeUpdate();
            rs = stmtUltRegistro.executeQuery();
            if(rs.next()) {
               Integer idDispensa = rs.getInt("LAST_INSERT_ID()");
                return idDispensa;
            }else{
                return null;
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao registrar a dispensa de medicamento no banco de dados. Origem=" + ex.getMessage());
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
    
    public void inserirDispensaMedicamentos(Integer idDispensa, Integer idMedicamento, Integer quantidade) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtInserirDispMed);
            stmt.setInt(1, idDispensa);
            stmt.setInt(2, idMedicamento);
            stmt.setInt(3, quantidade);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao registrar a dispensa de medicamento no banco de dados. Origem=" + ex.getMessage());
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
    
    public Integer buscaQntdMedMes(Integer idMedicamento, Integer mes){
        Connection con = null;
        PreparedStatement stmt = null;
            ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtBuscaQntdMedMes);
            stmt.setInt(1, mes);
            stmt.setInt(2, idMedicamento);
            rs = stmt.executeQuery();
            Integer qntd =0;
            if (rs.next()) {
                String n = rs.toString();
                qntd = rs.getInt("SUM(dispensas_medicamentos.quantidade)");
            }
            return qntd;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar quantidade medicamentos por mês no banco de dados. Origem=" + ex.getMessage());
        } finally {
            try {
                rs.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar rs. Ex=" + ex.getMessage());
            };
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
    
    public List<Dispensa> buscaDispensa(){
        Connection con = null;
        PreparedStatement stmt = null;
            ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtBuscaDispensa);
            rs = stmt.executeQuery();
            List<Dispensa> dis =  new ArrayList<Dispensa>();
            while (rs.next()) {
                Dispensa d = new Dispensa();
                d.setId(rs.getInt("idDispensa"));              
              
                dis.add(d);
            }
            return dis;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar quantidade medicamentos por mês no banco de dados. Origem=" + ex.getMessage());
        } finally {
            try {
                rs.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar rs. Ex=" + ex.getMessage());
            };
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
    public Integer buscaMedPorDispensa(Integer id){
        Connection con = null;
        PreparedStatement stmt = null;
            ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtBuscaMedPorDispensa);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Integer idMed =  0;
            while (rs.next()) {
               return rs.getInt("idMedicamento");  
            }
            return idMed;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar quantidade medicamentos por mês no banco de dados. Origem=" + ex.getMessage());
        } finally {
            try {
                rs.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar rs. Ex=" + ex.getMessage());
            };
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
    
    public Integer buscaTotalSaidaPorMed(Integer id){
        Connection con = null;
        PreparedStatement stmt = null;
            ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtBuscaTotalSaida);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            Integer total =  0;
            if (rs.next()) {
               total = rs.getInt("SUM(dispensas_medicamentos.quantidade)");  
            }
            return total;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar quantidade medicamentos por mês no banco de dados. Origem=" + ex.getMessage());
        } finally {
            try {
                rs.close();
            } catch (Exception ex) {
                System.out.println("Erro ao fechar rs. Ex=" + ex.getMessage());
            };
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

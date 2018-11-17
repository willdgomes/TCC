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
    String stmtBuscarRetirantesParam = "SELECT cpfRetirante, nomeRetirante, dnRetirante, telefone, "
            + "cep, cidade, estado, bairro, endereco, numEndereco, complemento, email, vincolo FROM retirantes WHERE nomeRetirante LIKE ?";
    private final String stmtListarRetirantes = "SELECT idRetirante, cpfRetirante,nomeRetirante, dnRetirante, telefone, cep, cidade, estado,bairro, endereco, numEndereco, complemento, email, vincolo from retirantes";
    String stmtBuscarRetirantesId = "SELECT cpfRetirante, nomeRetirante, dnRetirante, telefone, "
            + "cep, cidade, estado, bairro, endereco, numEndereco, complemento, email, vincolo FROM retirantes WHERE idRetirante = ?";
    private final String stmtAlterar = "UPDATE retirantes SET cpfRetirante = ?, nomeRetirante = ?, dnRetirante = ?, telefone = ?, "
            + "cep = ?, cidade = ?, estado = ?, bairro = ?, endereco = ?, numEndereco = ?, complemento = ?, email = ?, vincolo = ? WHERE idRetirante LIKE ?";
    
    public void inserirRetirante(Retirante retirante) {
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
            stmt.setString(6, retirante.getCidade());
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

    public List<Retirante> buscarRetirantesParam(/*String parametro, */String pesquisa) {
        // Departamento departamento = new Departamento();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Retirante> listaRetirantes = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtBuscarRetirantesParam);
            stmt.setString(1, '%' + pesquisa + '%');
            rs = stmt.executeQuery();
            listaRetirantes = new ArrayList<Retirante>();
            while (rs.next()) {
                Retirante p = new Retirante();
                p.setIdRetirante(Integer.parseInt(rs.getString("idRetirante")));
                p.setNomeRetirante(rs.getString("nomeRetirante"));
                p.setCpfRetirante(rs.getString("cpfRetirante"));
                p.setEmail(rs.getString("cpfRetirante"));
                p.setTelefone(rs.getString("telefone"));
                p.setCep(rs.getString("cep"));
                p.setCidade(rs.getString("cidade"));
                p.setBairro(rs.getString("bairro"));
                p.setEndereco(rs.getString("endereco"));
                p.setNumEndereco(rs.getString("numEndereco"));
                p.setComplemento(rs.getString("complemento"));
                p.setVincolo(rs.getString("vincolo"));
                p.setEmail(rs.getString("email"));
                String stringData = rs.getString("dnRetirante");
                stringData = stringData.replaceAll("-", "/");
                SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                java.util.Date dt = null;
                java.sql.Date dt2 = null;
                try {
                    dt = format.parse(stringData);
                    dt2 = new java.sql.Date(dt.getTime());
                } catch (Exception ex) {
                    System.out.println("Erro na data");
                }
                p.setDnRetirante(dt2);
                listaRetirantes.add(p);
            }
            return listaRetirantes;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao listar os retirantes no banco de dados. Origem=" + ex.getMessage());
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

    public List<Retirante> listarRetirantes() {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Retirante> listaRetirantes = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtListarRetirantes);
            rs = stmt.executeQuery();
            listaRetirantes = new ArrayList<Retirante>();
            while (rs.next()) {
                Retirante retirante = new Retirante();
                retirante.setIdRetirante(rs.getInt("idRetirante"));
                retirante.setNomeRetirante(rs.getString("nomeRetirante"));
                retirante.setCpfRetirante("cpfRetirante");
                retirante.setEmail(rs.getString("email"));
                retirante.setCep(rs.getString("cep"));
                retirante.setCidade(rs.getString("cidade"));
                retirante.setEmail(rs.getString("estado"));
                listaRetirantes.add(retirante);
            }
            return listaRetirantes;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao listar os retirantes no banco de dados. Origem=" + ex.getMessage());
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

    public Retirante buscarMedicamentoId(String id) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Retirante> listaRetirantes = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtBuscarRetirantesId);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            Retirante retirante = new Retirante();
            while (rs.next()) {
            retirante.setIdRetirante(Integer.parseInt(id));
            retirante.setNomeRetirante(rs.getString("nomeRetirante"));
            retirante.setCpfRetirante(rs.getString("cpfRetirante"));
            retirante.setEmail(rs.getString("cpfRetirante"));
            retirante.setTelefone(rs.getString("telefone"));
            retirante.setCep(rs.getString("cep"));
            retirante.setCidade(rs.getString("cidade"));
            retirante.setBairro(rs.getString("bairro"));
            retirante.setEndereco(rs.getString("endereco"));
            retirante.setNumEndereco(rs.getString("numEndereco"));
            retirante.setComplemento(rs.getString("complemento"));
            retirante.setVincolo(rs.getString("vincolo"));
            retirante.setEmail(rs.getString("email"));
            String stringData = rs.getString("dnRetirante");
            stringData = stringData.replaceAll("-", "/");
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            java.util.Date dt = null;
            java.sql.Date dt2 = null;
            try {
                dt = format.parse(stringData);
                dt2 = new java.sql.Date(dt.getTime());
            } catch (Exception ex) {
                System.out.println("Erro na data");
            }
            retirante.setDnRetirante(dt2);
            }
            return retirante;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao listar os retirantes no banco de dados. Origem=" + ex.getMessage());
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

    public void alterarRetirante(Retirante retirante){
     Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtAlterar);
            stmt.setString(1, retirante.getCpfRetirante());
            stmt.setString(2, retirante.getNomeRetirante());
            stmt.setDate(3, retirante.getDnRetirante());
            stmt.setString(4, retirante.getTelefone());
            stmt.setString(5, retirante.getCep());
            stmt.setString(6, retirante.getCidade());
            stmt.setString(7, retirante.getEstado());
            stmt.setString(8, retirante.getBairro());
            stmt.setString(9, retirante.getEndereco());
            stmt.setString(10, retirante.getNumEndereco());
            stmt.setString(11, retirante.getComplemento());
            stmt.setString(12, retirante.getEmail());
            stmt.setString(13, retirante.getVincolo());
            stmt.setString(14, retirante.getIdRetirante().toString());
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

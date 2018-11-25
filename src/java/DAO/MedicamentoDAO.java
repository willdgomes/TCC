/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.Medicamento;
import Beans.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Eu
 */
public class MedicamentoDAO {

    private final String stmtInserir = "INSERT INTO medicamentos (nomeMedicamento, descricao, nomeFabricante, composicao, dosagem, medida)"
            + "VALUES (?, ?, ?, ?, ?, ?)";
    private final String stmtListarMedicamentos = "SELECT idMedicamento, nomeMedicamento, descricao, nomeFabricante, composicao, dosagem from medicamentos";
    private final String stmtRemoverMedicamentos = "DELETE FROM medicamentos WHERE idMedicamento = ?";
    private final String stmtAtualizarMedicamentos = "UPDATE medicamentos SET nomeMedicamento = ?, descricao = ?, nomeFabricante = ?, composicao = ?, dosagem = ? WHERE idMedicamento = ?";
    private final String stmtBuscarMedicamentosParam = "SELECT idMedicamento, nomeMedicamento, descricao, nomeFabricante, composicao, dosagem, medida FROM medicamentos WHERE nomeMedicamento LIKE ?";
    private final String stmtBuscarMedicamentoPorNome = "SELECT idMedicamento, nomeMedicamento, descricao, nomeFabricante, composicao, dosagem, medida FROM medicamentos WHERE nomeMedicamento=?";
    private final String stmtBuscarMedicamentoId = "SELECT idMedicamento, nomeMedicamento, descricao, nomeFabricante, composicao, dosagem, medida FROM medicamentos WHERE idMedicamento=?";
    
    public void inserirMedicamento(Medicamento med) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtInserir);
            stmt.setString(1, med.getNome());
            stmt.setString(2, med.getDescricao());
            stmt.setString(3, med.getNomeFabricante());
            stmt.setString(4, med.getComposicao());
            stmt.setDouble(5, med.getDosagem());
            stmt.setString(6, med.getMedida());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao inserir um medicamento no banco de dados. Origem=" + ex.getMessage());
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

    public List<Medicamento> listarMedicamentos() {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Medicamento> listaMedicamentos = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtListarMedicamentos);
            rs = stmt.executeQuery();
            listaMedicamentos = new ArrayList<Medicamento>();
            while (rs.next()) {
                Medicamento medicamento = new Medicamento();
                medicamento.setId(Integer.parseInt(rs.getString("idMedicamento")));
                medicamento.setNome(rs.getString("nomeMedicamento"));
                medicamento.setDescricao(rs.getString("descricao"));
                medicamento.setNomeFabricante(rs.getString("nomeFabricante"));
                medicamento.setComposicao(rs.getString("composicao"));
                medicamento.setDosagem(rs.getDouble("dosagem"));
                listaMedicamentos.add(medicamento);
            }
            return listaMedicamentos;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao listar os medicamentos no banco de dados. Origem=" + ex.getMessage());
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

    public void removerMedicamento(Medicamento medicamento) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtRemoverMedicamentos);
            stmt.setInt(1, medicamento.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao excluir o medicamento no banco de dados. Origem=" + ex.getMessage());
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
    
    public void atualizarMedicamento(Medicamento medicamento) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtAtualizarMedicamentos);
            stmt.setString(1, medicamento.getNome());
            stmt.setString(2, medicamento.getDescricao());
            stmt.setString(3, medicamento.getNomeFabricante());
            stmt.setString(4, medicamento.getComposicao());
            stmt.setDouble(5, medicamento.getDosagem()); 
            stmt.setString(6, medicamento.getId().toString());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar o medicamento no banco de dados. Origem=" + ex.getMessage());
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

    public List<Medicamento> buscarMedicamentosParam(String nomeRemedio) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Medicamento> listaMedicamentos = new ArrayList<Medicamento>();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtBuscarMedicamentosParam);
            stmt.setString(1, '%' + nomeRemedio + '%');
            rs = stmt.executeQuery();
            listaMedicamentos = new ArrayList<Medicamento>();
            while (rs.next()) {
                Medicamento p = new Medicamento();
                p.setId(Integer.parseInt(rs.getString("idMedicamento")));
                p.setNome(rs.getString("nomeMedicamento"));
                p.setNomeFabricante(rs.getString("nomeFabricante"));
                p.setComposicao(rs.getString("composicao"));
                p.setDescricao(rs.getString("descricao"));
                p.setDosagem(Double.parseDouble(rs.getString("dosagem")));
                p.setMedida(rs.getString("medida"));
                listaMedicamentos.add(p);
            }
            return listaMedicamentos;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar medicamento no banco de dados. Origem=" + ex.getMessage());
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

    public Medicamento buscarMedicamentoNomeInsere(String nomeRemedio) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Medicamento medicamento = new Medicamento();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtBuscarMedicamentoPorNome);
            stmt.setString(1, nomeRemedio);
            rs = stmt.executeQuery();
            if (rs.next()) {
                medicamento.setId(Integer.parseInt(rs.getString("idMedicamento")));
                medicamento.setNome(rs.getString("nomeMedicamento"));
                medicamento.setNomeFabricante(rs.getString("nomeFabricante"));
                medicamento.setComposicao(rs.getString("composicao"));
                medicamento.setDescricao(rs.getString("descricao"));
                medicamento.setDosagem(Double.parseDouble(rs.getString("dosagem")));
                medicamento.setMedida(rs.getString("medida"));
            }
            return medicamento;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar medicamento no banco de dados. Origem=" + ex.getMessage());
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
    
    public Medicamento buscarMedicamentoId(int idMedicamento) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Medicamento medicamento = new Medicamento();
        try {
            con = ConnectionFactory.getConnection();
            stmt = con.prepareStatement(stmtBuscarMedicamentoId);
            stmt.setInt(1, idMedicamento);
            rs = stmt.executeQuery();
            if (rs.next()) {
                medicamento.setId(Integer.parseInt(rs.getString("idMedicamento")));
                medicamento.setNome(rs.getString("nomeMedicamento"));
                medicamento.setNomeFabricante(rs.getString("nomeFabricante"));
                medicamento.setComposicao(rs.getString("composicao"));
                medicamento.setDescricao(rs.getString("descricao"));
                medicamento.setDosagem(Double.parseDouble(rs.getString("dosagem")));
                medicamento.setMedida(rs.getString("medida"));
            }
            return medicamento;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar medicamento no banco de dados. Origem=" + ex.getMessage());
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

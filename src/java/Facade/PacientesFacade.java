/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Beans.Paciente;
import DAO.PacienteDAO;
import java.util.List;

/**
 *
 * @author gomes
 */
public class PacientesFacade {
    private static final PacienteDAO pacienteDAO = new PacienteDAO();

    public static void inserir(Paciente p) {
        pacienteDAO.inserirPaciente(p);
    }

    public static void alterar(Paciente p) {
        
    }

    public static Paciente buscar(int id) {
        return null;
    }

    public static List<Paciente> buscarTodos() {
        return pacienteDAO.buscarTodosPacientes();
    }
    
    public static List<Paciente> buscaPacientesParam(String pesquisa) {
        return pacienteDAO.buscarPacientesParam(pesquisa);
    }

    public static void remover(int id) {
        
    }

    public static int validar(Paciente p) {
        return 0;
    }

}

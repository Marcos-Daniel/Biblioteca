/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentacao;

import Aplicacao.EmprestimoRepositorio;
import Aplicacao.FuncionarioRepositorio;
import Aplicacao.LivroRepositorio;
import Aplicacao.ReservaRepositorio;
import Persistencia.LivroDao;
import java.sql.SQLException;
import Aplicacao.UsuarioRepositorio;
import Persistencia.EmprestimoDao;
import Persistencia.FuncionarioDao;
import Persistencia.ReservaDao;
import Persistencia.UsuarioDao;

/**
 *
 * @author marcos
 */
public class GerenciadorDeReferencias {
    
    private static UsuarioRepositorio daoUsuarios;
    private static LivroRepositorio daoLivros;
    private static EmprestimoRepositorio daoEmprestimos;
    private static ReservaRepositorio daoReservas;
    private static FuncionarioRepositorio daoFuncionario;
    
    public static UsuarioRepositorio getUsuarios() {
        try {
            if (daoUsuarios == null) {
                daoUsuarios = new UsuarioDao();
            }
            return daoUsuarios;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public static LivroRepositorio getLivros() {
        try {
            if (daoLivros == null) {
                daoLivros = new LivroDao();
            }
            return daoLivros;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    public static EmprestimoRepositorio getEmprestimos() {
        try {
            if (daoEmprestimos == null) {
                daoEmprestimos = new EmprestimoDao();
            }
            return daoEmprestimos;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    public static ReservaRepositorio getReservas() {
        try {
            if (daoReservas == null) {
                daoReservas = new ReservaDao();
            }
            return daoReservas;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    public static FuncionarioRepositorio getFuncionario() {
        try {
            if (daoFuncionario == null) {
                daoFuncionario = new FuncionarioDao();
            }
            return daoFuncionario;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
}

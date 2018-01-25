/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Aplicacao.Emprestimo;
import Aplicacao.EmprestimoRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marcos
 */
public class EmprestimoDao extends DaoGenerica<Emprestimo> implements EmprestimoRepositorio{
    
    public EmprestimoDao() throws SQLException{
            setConsultaCadastrar("INSERT INTO emprestimo(usuarioFk,livroFk,dataEmprestimo,dataDevolucao)VALUES(?,?,?,?)");
            setConsultaEditar("UPDATE emprestimo SET usuarioFk=?, livroFk=?,dataEmprestimo=?, dataDevolucao=?  WHERE id=?");
            setConsultaExcluir("DELETE FROM emprestimo WHERE id=?");
            setConsultaBuscar("SELECT id,usuarioFk,livroFk,dataemprestimo,datadevolucao FROM emprestimo");
            setConsultaFiltrar("SELECT id,usuarioFk,livroFk,dataemprestimo,datadevolucao FROM emprestimo");
        }

    @Override
    protected Emprestimo preencherObjeto(ResultSet resultado) {
        try {
            Emprestimo tmp = new Emprestimo();
            tmp.setId(resultado.getInt(1));
            tmp.setUsuarioFk(resultado.getInt(2));
            tmp.setLivroFk(resultado.getInt(3));
            tmp.setDataEmprestimo(resultado.getString(4));
            tmp.setDataDevolução(resultado.getString(5));
            return tmp;
        } catch (SQLException ex) {
            System.out.println(ex + "ContatosDao preencherObjeto");
        }
        return null;
    }

    @Override
    protected void preencherConsulta(PreparedStatement sql, Emprestimo obj) {
        try {
            sql.setInt(1, obj.getUsuarioFk());
            sql.setInt(2, obj.getLivroFk());
            sql.setString(3, obj.getDataEmprestimo());
            sql.setString(4, obj.getDataDevolução());
            if(obj.getId() > 0) sql.setInt(5, obj.getId());
        } catch (SQLException ex) {
            System.out.println(ex + "ContatosDao preencherConsulta");
        }
    }

    @Override
    protected void preencherFiltros(Emprestimo filtro) {
        if(filtro.getId() > 0) adicionarFiltro("id", "=");
        if(filtro.getUsuarioFk() > 0) adicionarFiltro("usuarioFk", "=");
        if(filtro.getLivroFk() > 0) adicionarFiltro("livroFk", "=");
    }

    @Override
    protected void preencherParametros(PreparedStatement sql, Emprestimo filtro) {
        try {
            int cont=1; 
            if(filtro.getId() > 0){
                sql.setInt(cont, filtro.getId());
                cont++;
            }    
            
            if(filtro.getUsuarioFk() > 0){
                sql.setInt(cont, filtro.getUsuarioFk());
                cont++;
            }
            
            if(filtro.getLivroFk() > 0){
                sql.setInt(cont, filtro.getLivroFk());
                cont++;
            }
                
        } catch (SQLException ex) {
            System.out.println(ex + "ContatosDao preencherParametros");
        }
    }
    
}

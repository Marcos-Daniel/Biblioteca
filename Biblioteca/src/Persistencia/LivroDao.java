/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Aplicacao.Livro;
import Aplicacao.LivroRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marcos
 */
public class LivroDao extends DaoGenerica<Livro> implements LivroRepositorio {
    
      public LivroDao() throws SQLException{
            setConsultaCadastrar("INSERT INTO livro(titulo,autor)VALUES(?,?)");
            setConsultaEditar("UPDATE livro SET titulo=?, autor=? WHERE id=?");
            setConsultaExcluir("DELETE FROM livro WHERE id=?");
            setConsultaBuscar("SELECT id,titulo,autor FROM livro");
            setConsultaFiltrar("SELECT id,titulo,autor FROM livro");
        }

    @Override
    protected Livro preencherObjeto(ResultSet resultado) {
        try {
            Livro tmp = new Livro();
            tmp.setId(resultado.getInt(1));
            tmp.setTitulo(resultado.getString(2));
            tmp.setAutor(resultado.getString(3));
            return tmp;
        } catch (SQLException ex) {
            System.out.println(ex + "ContatosDao preencherObjeto");
        }
        return null;
    }

    @Override
    protected void preencherConsulta(PreparedStatement sql, Livro obj) {
        try {
            sql.setString(1, obj.getTitulo());
            sql.setString(2, obj.getAutor());
            if(obj.getId() > 0) sql.setInt(3, obj.getId());
        } catch (SQLException ex) {
            System.out.println(ex + "ContatosDao preencherConsulta");
        }
    }

    @Override
    protected void preencherFiltros(Livro filtro) {
        if(filtro.getId() > 0) adicionarFiltro("id", "=");
        if(filtro.getTitulo()!= null) adicionarFiltro("titulo", "=");
        if(filtro.getAutor()!= null) adicionarFiltro("autor", "=");
    }

    @Override
    protected void preencherParametros(PreparedStatement sql, Livro filtro) {
         try {
            int cont=1; 
            if(filtro.getId() > 0){
                sql.setInt(cont, filtro.getId());
                cont++;
            }    
            
            if(filtro.getTitulo()!= null){
                sql.setString(cont, filtro.getTitulo());
                cont++;
            }
            
            if(filtro.getAutor()!= null){
                sql.setString(cont, filtro.getAutor());
                cont++;
            }
                
        } catch (SQLException ex) {
            System.out.println(ex + "ContatosDao preencherParametros");
        }
    }
    
}

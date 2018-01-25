/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Aplicacao.Entidade;
import Aplicacao.Funcionario;
import Aplicacao.FuncionarioRepositorio;
import Aplicacao.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marcos
 */
public class FuncionarioDao extends DaoGenerica<Funcionario> implements FuncionarioRepositorio{
     
    public FuncionarioDao() throws SQLException{
            setConsultaCadastrar("INSERT INTO funcionario(nome,telefone,cpf,cep,nresidencia)VALUES(?,?,?,?,?)");
            setConsultaEditar("UPDATE funcionario SET nome=?,telefone=?,cpf=?,cep=?,nresidencia=? WHERE id=?");
            setConsultaExcluir("DELETE FROM funcionario WHERE id=?");
            setConsultaBuscar("SELECT id,nome,telefone,cpf,cep,nresidencia FROM funcionario");
            setConsultaFiltrar("SELECT id,nome,telefone,cpf,cep,nresidencia FROM funcionario");
        }

    @Override
    protected void preencherConsulta(PreparedStatement sql, Funcionario obj) {
        try {
            sql.setString(1, obj.getNome());
            sql.setString(2, obj.getTelefone());
            sql.setString(3, obj.getCPF());
            sql.setString(4, obj.getCEP());
            sql.setString(5, obj.getNumeroResidencia());
            if(obj.getId() > 0) sql.setInt(6, obj.getId());
        } catch (SQLException ex) {
            System.out.println(ex + "ContatosDao preencherConsulta");
        }
    }

    @Override
    protected void preencherFiltros(Funcionario filtro) {
        if(filtro.getId() > 0) adicionarFiltro("id", "=");
        if(filtro.getNome() != null) adicionarFiltro("nome", "=");
        if(filtro.getCPF()!= null) adicionarFiltro("CPF", "=");
    }

    @Override
    protected void preencherParametros(PreparedStatement sql, Funcionario filtro) {
         try {
            int cont=1; 
            if(filtro.getId() > 0){
                sql.setInt(cont, filtro.getId());
                cont++;
            }    
            
            if(filtro.getNome() != null){
                sql.setString(cont, filtro.getNome());
                cont++;
            }
            
            if(filtro.getCPF()!= null){
                sql.setString(cont, filtro.getCPF());
                cont++;
            }
                
        } catch (SQLException ex) {
            System.out.println(ex + "ContatosDao preencherParametros");
        }
    }

    @Override
    protected Funcionario preencherObjeto(ResultSet resultado) {
          try {
            Funcionario tmp = new Funcionario();
            tmp.setId(resultado.getInt(1));
            tmp.setNome(resultado.getString(2));
            tmp.setTelefone(resultado.getString(3));
            tmp.setCPF(resultado.getString(4));
            tmp.setCEP(resultado.getString(5));
            tmp.setNumeroResidencia(resultado.getString(6));
            return tmp;
        } catch (SQLException ex) {
            System.out.println(ex + "ContatosDao preencherObjeto");
        }
        return null;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Aplicacao.Reserva;
import Aplicacao.ReservaRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marcos
 */
public class ReservaDao extends DaoGenerica<Reserva> implements ReservaRepositorio {
    
    public ReservaDao() throws SQLException{
            setConsultaCadastrar("INSERT INTO reserva(usuarioFk,livroFk,dataSolicitacao,dataReserva)VALUES(?,?,?,?)");
            setConsultaEditar("UPDATE reserva SET usuarioFk=?, livroFk=?, dataSolicitacao=?, dataReserva=? WHERE id=?");
            setConsultaExcluir("DELETE FROM reserva WHERE id=?");
            setConsultaBuscar("SELECT id,usuarioFk,livroFk,dataSolicitacao,dataReserva FROM reserva");
            setConsultaFiltrar("SELECT id,usuarioFk,livroFk,dataSolicitacao,dataReserva FROM reserva");
        }


    @Override
    protected Reserva preencherObjeto(ResultSet resultado) {
        try{
            Reserva tmp = new Reserva();
            tmp.setId(resultado.getInt(1));
            tmp.setUsuarioFk(resultado.getInt(2));
            tmp.setLivroFK(resultado.getInt(3));
            tmp.setDataSolicitacao(resultado.getString(4));
            tmp.setDataReserva(resultado.getString(5));
            return tmp;
        } catch (SQLException ex) {
            System.out.println(ex + "ContatosDao preencherObjeto");
        }
        return null;
    }

    @Override
    protected void preencherConsulta(PreparedStatement sql, Reserva obj) {
        try {
            sql.setInt(1, obj.getUsuarioFk());
            sql.setInt(2, obj.getLivroFK());
            sql.setString(3, obj.getDataSolicitacao());
            sql.setString(4, obj.getDataReserva());
            if(obj.getId() > 0) sql.setInt(5, obj.getId());
        } catch (SQLException ex) {
            System.out.println(ex + "ContatosDao preencherConsulta");
        }
    }

    @Override
    protected void preencherFiltros(Reserva filtro) {
        if(filtro.getId() > 0) adicionarFiltro("id", "=");
        if(filtro.getUsuarioFk() > 0) adicionarFiltro("usuarioFk", "=");
        if(filtro.getLivroFK() > 0) adicionarFiltro("livroFk", "=");
    }

    @Override
    protected void preencherParametros(PreparedStatement sql, Reserva filtro) {
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
            
            if(filtro.getLivroFK() > 0){
                sql.setInt(cont, filtro.getLivroFK());
                cont++;
            }
                
        } catch (SQLException ex) {
            System.out.println(ex + "ContatosDao preencherParametros");
        }
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplicacao;

/**
 *
 * @author marcos
 */
public class Reserva implements Entidade {
    
    private int id;
    private int usuarioFk;
    private int livroFK;
    private String dataSolicitacao;
    private String dataReserva;

    public Reserva() {
    }

    public Reserva(int id, int usuarioFk, int livroFK, String dataSolicitacao, String dataReserva) {
        this.id = id;
        this.usuarioFk = usuarioFk;
        this.livroFK = livroFK;
        this.dataSolicitacao = dataSolicitacao;
        this.dataReserva = dataReserva;
    }

    @Override
    public int getId() {
       return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioFk() {
        return usuarioFk;
    }

    public void setUsuarioFk(int usuarioFk) {
        this.usuarioFk = usuarioFk;
    }

    public int getLivroFK() {
        return livroFK;
    }

    public void setLivroFK(int livroFK) {
        this.livroFK = livroFK;
    }

    public String getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(String dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(String dataReserva) {
        this.dataReserva = dataReserva;
    }
    
    
    
}

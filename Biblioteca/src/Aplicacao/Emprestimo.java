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
public class Emprestimo implements Entidade{
    private int id;
    private int usuarioFk;
    private int livroFk;
    private String dataEmprestimo;
    private String dataDevolucao;

    public Emprestimo() {
    }

    public Emprestimo(int id, int usuarioFk, int livroFk, String dataEmprestimo, String dataDevolucao) {
        this.id = id;
        this.usuarioFk = usuarioFk;
        this.livroFk = livroFk;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao =dataDevolucao;
    }

    public int getUsuarioFk() {
        return usuarioFk;
    }

    public void setUsuarioFk(int usuarioFk) {
        this.usuarioFk = usuarioFk;
    }

    public int getLivroFk() {
        return livroFk;
    }

    public void setLivroFk(int livroFk) {
        this.livroFk = livroFk;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolução() {
        return dataDevolucao;
    }

    public void setDataDevolução(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
    
    
}

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
public class Funcionario implements Entidade {
    
    private int id;
    private String nome;
    private String Telefone;
    private String CPF;
    private String CEP;
    private String numeroResidencia;

    public Funcionario() {
        
    }
    
    
    public Funcionario(int id, String nome, String Telefone, String CPF, String CEP, String numeroResidencia) {
        this.id = id;
        this.nome = nome;
        this.Telefone = Telefone;
        this.CPF = CPF;
        this.CEP = CEP;
        this.numeroResidencia = numeroResidencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getNumeroResidencia() {
        return numeroResidencia;
    }

    public void setNumeroResidencia(String numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
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

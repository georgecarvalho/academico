/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifma.formulario.model;

/**
 *
 * @author Carvalho
 */
public abstract class Pessoa {
    
    private String nome;
    private String telefone;
    private String endereco;
    private String rg;
    private String cpf;
    
    public Pessoa() {
    	
    }

    public Pessoa(String nome, String telefone, String endereco, String rg, String cpf) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.rg = rg;
		this.cpf = cpf;
	}

	public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco + ", rg=" + rg + ", cpf="
				+ cpf + "]";
	}

}

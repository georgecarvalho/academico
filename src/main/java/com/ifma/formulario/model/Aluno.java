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
public class Aluno extends Pessoa {
    
	private Integer id;
    private String codigo;
    
    

	public Aluno() {}

	public Aluno(String codigo, String nome, String telefone, String endereco, String rg, String cpf) {
		super(nome, telefone, endereco, rg, cpf);
		this.codigo = codigo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        super.toString();
        return "Aluno{" + "codigo=" + codigo + '}';
    }

}

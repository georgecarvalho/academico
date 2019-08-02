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
public class Professor extends Pessoa {
    
	private Integer id;
	private String codigo;
    
	public Professor() {}
	
    public Professor(String codigo, String nome) {
		super(nome);
		this.codigo = codigo;
	}

	public Professor(String nome) {
        super(nome);
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
        return "Professor{" + "codigo=" + codigo + "nome=" + super.getNome() + '}';
    }
    
}

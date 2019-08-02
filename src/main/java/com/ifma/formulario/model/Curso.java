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
public class Curso {
    
	private Integer id;
    private String codigo;
    private String nome;
    
    public Curso() {}
    
	public Curso(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	@Override
	public String toString() {
		return "Curso [id=" + id + ", codigo=" + codigo + ", nome=" + nome + "]";
	}

}

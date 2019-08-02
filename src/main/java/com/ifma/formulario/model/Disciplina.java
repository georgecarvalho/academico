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
public class Disciplina {
    
	private Integer id;
	private String codigo;
    private String nome;
    private String ementa;
    private int cargaHoraria;
    private Integer professor_id;

    public Disciplina() {}
    
    public Disciplina(String codigo, String nome, String ementa, int cargaHoraria) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.ementa = ementa;
		this.cargaHoraria = cargaHoraria;
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

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public Integer getProfessor_id() {
		return professor_id;
	}

	public void setProfessor_id(Integer professor_id) {
		this.professor_id = professor_id;
	}

	@Override
	public String toString() {
		return "Disciplina [codigo=" + codigo + ", nome=" + nome + ", ementa=" + ementa + ", cargaHoraria="
				+ cargaHoraria + "]";
	}
    
}

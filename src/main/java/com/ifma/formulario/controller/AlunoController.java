package com.ifma.formulario.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JOptionPane;

import com.ifma.formulario.infra.Database;
import com.ifma.formulario.model.Aluno;
import com.ifma.formulario.model.dao.AlunoDAO;
import com.ifma.formulario.view.cadastro.TelaAluno;

public class AlunoController {
	
	private final TelaAluno view;

	public AlunoController(TelaAluno view) {
		this.view = view;
	}
	
	public void cadastrar() throws SQLException {
		String codigo = view.getTxtCodigo().getText();
		String nome = view.getTxtNome().getText();
		String telefone = view.getTxtTelefone().getText();
		String endereco = view.getTxtEndereco().getText();
		String rg = view.getTxtRG().getText();
		String cpf = view.getTxtCPF().getText();
		Aluno aluno = new Aluno(codigo, nome, telefone, endereco, rg, cpf);
		try(Connection connection = Database.getConnection()){
			AlunoDAO alunoDAO = new AlunoDAO(connection);
			alunoDAO.cadastra(aluno);
			JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
			this.limpar();
			//connection.close();
		}catch(SQLIntegrityConstraintViolationException e){
			JOptionPane.showMessageDialog(view, "C�digo j� existente");
		}
	}
	
	public void limpar() {
		view.getTxtCodigo().setText("");
		view.getTxtNome().setText("");
		view.getTxtTelefone().setText("");
		view.getTxtEndereco().setText("");
		view.getTxtRG().setText("");
		view.getTxtCPF().setText("");
	}
	
}

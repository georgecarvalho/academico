package com.ifma.formulario.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;
import com.ifma.formulario.infra.Database;
import com.ifma.formulario.model.Professor;
import com.ifma.formulario.model.dao.ProfessorDAO;
import com.ifma.formulario.view.cadastro.TelaProfessor;

public class ProfessorController {
	
	private final TelaProfessor view;

	public ProfessorController(TelaProfessor view) {
		super();
		this.view = view;
	}
	
	public void cadastrar() throws SQLException {
		String codigo = view.getTxtCodigo().getText();
		String nome = view.getTxtNome().getText();
		Professor professor = new Professor(codigo, nome);
		try(Connection connection = Database.getConnection()){
			ProfessorDAO professorDAO = new ProfessorDAO(connection);
			professorDAO.cadastra(professor);
			JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!");
			this.limpar();
			//connection.close();
		}catch(SQLIntegrityConstraintViolationException e){
			JOptionPane.showMessageDialog(view, "C�digo j� existente");
		}
	}
	
	public void limpar() {
		view.getTxtCodigo().setText("");
		view.getTxtNome().setText("");
	}
	
}

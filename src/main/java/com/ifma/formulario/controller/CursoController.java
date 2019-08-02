package com.ifma.formulario.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;
import com.ifma.formulario.infra.Database;
import com.ifma.formulario.model.Curso;
import com.ifma.formulario.model.dao.CursoDAO;
import com.ifma.formulario.view.cadastro.TelaCurso;

public class CursoController {
	
	private final TelaCurso view;

	public CursoController(TelaCurso view) {
		super();
		this.view = view;
	}
	
	public void cadastrar() throws SQLException {
		String codigo = view.getTxtCodigo().getText();
		String nome = view.getTxtNome().getText();
		Curso professor = new Curso(codigo, nome);
		try(Connection connection = Database.getConnection()){
			CursoDAO professorDAO = new CursoDAO(connection);
			professorDAO.cadastra(professor);
			JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso!");
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

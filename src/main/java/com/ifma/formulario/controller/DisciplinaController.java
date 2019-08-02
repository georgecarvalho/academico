package com.ifma.formulario.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;
import com.ifma.formulario.infra.Database;
import com.ifma.formulario.model.Disciplina;
import com.ifma.formulario.model.dao.DisciplinaDAO;
import com.ifma.formulario.view.cadastro.TelaDisciplina;

public class DisciplinaController {
	
	private final TelaDisciplina view;

	public DisciplinaController(TelaDisciplina view) {
		super();
		this.view = view;
	}
	
	public void cadastrar() throws SQLException {
		String codigo = view.getTxtCodigo().getText();
		String nome = view.getTxtNome().getText();
		String ementa = view.getTxtEmenta().getText();
		int cargaHoraria = Integer.parseInt(view.getTxtCargaHoraria().getText());
		Disciplina disciplina = new Disciplina(codigo, nome, ementa, cargaHoraria);
		try(Connection connection = Database.getConnection()){
			DisciplinaDAO disciplinaDAO = new DisciplinaDAO(connection);
			disciplinaDAO.cadastra(disciplina);
			JOptionPane.showMessageDialog(null, "Disciplina cadastrada com sucesso!");
			this.limpar();
			//connection.close();
		}catch(SQLIntegrityConstraintViolationException e){
			JOptionPane.showMessageDialog(view, "C�digo j� existente");
		}
	}
	
	public void limpar() {
		view.getTxtCodigo().setText("");
		view.getTxtNome().setText("");
		view.getTxtEmenta().setText("");
		view.getTxtCargaHoraria().setText("");
	}
	
}

package com.ifma.formulario.controller;

import java.sql.Connection;
import java.sql.SQLException;
import com.ifma.formulario.infra.Database;
import com.ifma.formulario.model.Disciplina;
import com.ifma.formulario.model.Professor;
import com.ifma.formulario.model.dao.DisciplinaDAO;
import com.ifma.formulario.model.dao.ProfessorDAO;
import com.ifma.formulario.view.spf.TelaProfDisc;

public class ProfDiscController {
	private final TelaProfDisc view;

	public ProfDiscController(TelaProfDisc view) {
		this.view = view;
	}

	public void preencherComboBox() throws SQLException {

		try (Connection connection = Database.getConnection()) {

			ProfessorDAO professorDAO = new ProfessorDAO(connection);
			DisciplinaDAO disciplinaDAO = new DisciplinaDAO(connection);

			for (Professor p : professorDAO.lista()) {
				view.getCbProfessor().addItem(p.getCodigo() + " - " + p.getNome());
			}

			for (Disciplina d : disciplinaDAO.lista()) {
				view.getCbDisciplina().addItem(d.getCodigo() + " - " + d.getNome());
			}
			//connection.close();
		}

	}
}

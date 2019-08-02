package com.ifma.formulario.controller;

import java.sql.Connection;
import java.sql.SQLException;
import com.ifma.formulario.infra.Database;
import com.ifma.formulario.model.Aluno;
import com.ifma.formulario.model.Curso;
import com.ifma.formulario.model.dao.AlunoDAO;
import com.ifma.formulario.model.dao.CursoDAO;
import com.ifma.formulario.view.spf.TelaAlunoCurso;

public class AlunoCursoController {
	private final TelaAlunoCurso view;

	public AlunoCursoController(TelaAlunoCurso view) {
		this.view = view;
	}

	public void preencherComboBox() throws SQLException {

		try (Connection connection = Database.getConnection()) {

			AlunoDAO alunoDAO = new AlunoDAO(connection);
			CursoDAO cursoDAO = new CursoDAO(connection);

			for (Aluno a : alunoDAO.lista()) {
				view.getCbAluno().addItem(a.getCodigo() + " - " + a.getNome());
			}

			for (Curso c : cursoDAO.lista()) {
				view.getCbCurso().addItem(c.getCodigo() + " - " + c.getNome());
			}
			//connection.close();
		}

	}
}

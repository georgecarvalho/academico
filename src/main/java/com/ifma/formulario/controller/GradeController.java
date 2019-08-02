package com.ifma.formulario.controller;

import java.sql.Connection;
import java.sql.SQLException;
import com.ifma.formulario.infra.Database;
import com.ifma.formulario.model.Curso;
import com.ifma.formulario.model.Disciplina;
import com.ifma.formulario.model.dao.CursoDAO;
import com.ifma.formulario.model.dao.DisciplinaDAO;
import com.ifma.formulario.view.spf.TelaGrade;

public class GradeController {
	private final TelaGrade view;

	public GradeController(TelaGrade view) {
		this.view = view;
	}

	public void preencherComboBox() throws SQLException {

		try (Connection connection = Database.getConnection()) {

			DisciplinaDAO disciplinaDAO = new DisciplinaDAO(connection);
			CursoDAO cursoDAO = new CursoDAO(connection);

			for (Disciplina d : disciplinaDAO.lista()) {
				view.getCbDisciplina().addItem(d.getCodigo() + " - " + d.getNome() + " - " + d.getCargaHoraria());
			}

			for (Curso c : cursoDAO.lista()) {
				view.getCbCurso().addItem(c.getCodigo() + " - " + c.getNome());
			}
			//connection.close();
		}

	}
	
	public String[] adicionarNaTabela() throws SQLException {
		
		String[] dados = {" ", " "};
		String disciplina = view.getCbDisciplina().getSelectedItem().toString();
		String aux[] = disciplina.split(" - ");
		dados[0] = aux[1];
		dados[1] = aux[2];
		return dados;
	}
	
}

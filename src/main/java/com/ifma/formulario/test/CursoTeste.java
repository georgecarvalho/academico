package com.ifma.formulario.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.ifma.formulario.infra.Database;
import com.ifma.formulario.model.Curso;
import com.ifma.formulario.model.dao.CursoDAO;

public class CursoTeste {
	public static void main(String[] args) throws SQLException {

		try (Connection connection = Database.getConnection()) {
			
			CursoDAO cursoDAO = new CursoDAO(connection);
			Curso curso = cursoDAO.busca(1);
			System.out.println(curso.toString());

			connection.close();

		}
	}
}

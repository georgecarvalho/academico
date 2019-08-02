/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ifma.formulario.model.dao;

/**
 *
 * @author Carvalho
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ifma.formulario.model.Professor;

import java.sql.Statement;

public class ProfessorDAO {

    private final Connection connection;

	public ProfessorDAO(Connection connection) {
        this.connection = connection;
    }

	public Professor cadastra(Professor professor) throws SQLException {

		String sql = "INSERT INTO professor (codigo, nome) VALUES (?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			statement.setString(1,  professor.getCodigo());
			statement.setString(2, professor.getNome());

			statement.execute();

			try (ResultSet keys = statement.getGeneratedKeys()) {
				keys.next();
				int id = keys.getInt(1);
				professor.setId(id);
			}
			//statement.close();
		}
		return professor;

	}

    public Professor busca(Integer id) {

        try {
            PreparedStatement ps = this.connection
                    .prepareStatement("SELECT codigo, nome FROM professor WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            }
            Professor professor = new Professor();
            professor.setCodigo(rs.getString("codigo"));
            professor.setNome(rs.getString("nome"));
            professor.setId(id);
            //ps.close();
            return professor;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Professor> lista() {

        try {
            PreparedStatement ps = this.connection
                    .prepareStatement("SELECT * FROM professor");
            ResultSet rs = ps.executeQuery();

            List<Professor> lista = new ArrayList<Professor>();

            while (rs.next()) {
            	String codigo = rs.getString("codigo");
            	String nome = rs.getString("nome");
            	int id = rs.getInt("id");
            	Professor professor = new Professor(codigo, nome);
            	professor.setId(id);
                lista.add(professor);
            }

            //ps.close();
            return lista;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Professor montaProfessor (ResultSet rs) throws SQLException {
    	
    	if (!rs.next()) {
            return null;
        }
    	Professor professor = new Professor();
    	professor.setId(rs.getInt("id"));
    	professor.setCodigo((rs.getString("codigo")));
    	professor.setNome(rs.getString("nome"));
        
        return professor;
    }
}

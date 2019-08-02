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

import com.ifma.formulario.model.Curso;

import java.sql.Statement;

public class CursoDAO {

    private final Connection connection;

	public CursoDAO(Connection connection) {
        this.connection = connection;
    }

	public Curso cadastra(Curso curso) throws SQLException {

		String sql = "INSERT INTO curso (codigo, nome) VALUES (?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			statement.setString(1,  curso.getCodigo());
			statement.setString(2, curso.getNome());

			statement.execute();

			try (ResultSet keys = statement.getGeneratedKeys()) {
				keys.next();
				int id = keys.getInt(1);
				curso.setId(id);
			}
			//statement.close();
		}
		return curso;

	}

    public Curso busca(Integer id) {

        try {
            PreparedStatement ps = this.connection
                    .prepareStatement("SELECT codigo, nome FROM curso WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            }
            Curso curso = new Curso();
            curso.setCodigo(rs.getString("codigo"));
            curso.setNome(rs.getString("nome"));
            curso.setId(id);
            //ps.close();
            return curso;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Curso> lista() {

        try {
            PreparedStatement ps = this.connection
                    .prepareStatement("SELECT * FROM curso");
            ResultSet rs = ps.executeQuery();

            List<Curso> lista = new ArrayList<Curso>();

            while (rs.next()) {
            	String codigo = rs.getString("codigo");
            	String nome = rs.getString("nome");
            	int id = rs.getInt("id");
            	Curso curso = new Curso(codigo, nome);
            	curso.setId(id);
            	
                lista.add(curso);
            }

            //ps.close();
            return lista;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Curso montaCurso (ResultSet rs) throws SQLException {
    	
    	if (!rs.next()) {
            return null;
        }
    	Curso curso = new Curso();
    	curso.setId(rs.getInt("id"));
    	curso.setCodigo((rs.getString("codigo")));
    	curso.setNome(rs.getString("nome"));
        
        return curso;
    }
}

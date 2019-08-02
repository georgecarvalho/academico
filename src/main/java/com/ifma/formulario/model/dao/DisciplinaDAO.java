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

import com.ifma.formulario.model.Disciplina;

import java.sql.Statement;

public class DisciplinaDAO {

    private final Connection connection;

	public DisciplinaDAO(Connection connection) {
        this.connection = connection;
    }

	public Disciplina cadastra(Disciplina disciplina) throws SQLException {

		String sql = "INSERT INTO disciplina (codigo, nome, ementa, cargaHoraria) VALUES (?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			statement.setString(1,  disciplina.getCodigo());
			statement.setString(2, disciplina.getNome());
			statement.setString(3, disciplina.getEmenta());
			statement.setInt(4, disciplina.getCargaHoraria());

			statement.execute();

			try (ResultSet keys = statement.getGeneratedKeys()) {
				keys.next();
				int id = keys.getInt(1);
				disciplina.setId(id);
			}
			//statement.close();
		}
		return disciplina;

	}

    public Disciplina busca(Integer id) {

        try {
            PreparedStatement ps = this.connection
                    .prepareStatement("SELECT codigo, nome, ementa, cargaHoraria FROM disciplina WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            }
            Disciplina disciplina = new Disciplina();
            disciplina.setCodigo(rs.getString("codigo"));
            disciplina.setNome(rs.getString("nome"));
            disciplina.setEmenta(rs.getString("ementa"));
            disciplina.setCargaHoraria(rs.getInt("cargaHoraria"));
            disciplina.setId(id);
            //ps.close();
            return disciplina;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Disciplina busca(String codigo) {

        try {
            PreparedStatement ps = this.connection
                    .prepareStatement("SELECT id, nome, ementa, cargaHoraria FROM disciplina WHERE codigo = ?");
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            }
            Disciplina disciplina = new Disciplina();
            disciplina.setCodigo(codigo);
            disciplina.setNome(rs.getString("nome"));
            disciplina.setEmenta(rs.getString("ementa"));
            disciplina.setCargaHoraria(rs.getInt("cargaHoraria"));
            disciplina.setId(rs.getInt("id"));
            //ps.close();
            return disciplina;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Disciplina> lista() {

        try {
            PreparedStatement ps = this.connection
                    .prepareStatement("SELECT * FROM disciplina");
            ResultSet rs = ps.executeQuery();

            List<Disciplina> lista = new ArrayList<Disciplina>();

            while (rs.next()) {
            	String codigo = rs.getString("codigo");
            	String nome = rs.getString("nome");
				String ementa = rs.getString("ementa");
				int cargaHoraria = rs.getInt("cargaHoraria");
				int id = rs.getInt("id");
				Disciplina disciplina = new Disciplina(codigo, nome, ementa, cargaHoraria);
				disciplina.setId(id);
                lista.add(disciplina);
            }

            //ps.close();
            return lista;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Disciplina montaDisciplina (ResultSet rs) throws SQLException {
    	
    	if (!rs.next()) {
            return null;
        }
    	Disciplina disciplina = new Disciplina();
        disciplina.setId(rs.getInt("id"));
        disciplina.setCodigo((rs.getString("codigo")));
        disciplina.setNome(rs.getString("nome"));
        disciplina.setEmenta(rs.getString ("ementa"));
        disciplina.setCargaHoraria(rs.getInt("cargaHoraria"));
        disciplina.setProfessor_id(rs.getInt("professor_id"));
        
        return disciplina;
    }
}

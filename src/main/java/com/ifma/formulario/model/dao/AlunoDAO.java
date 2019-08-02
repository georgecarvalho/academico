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

import com.ifma.formulario.model.Aluno;

import java.sql.Statement;

public class AlunoDAO {

    private final Connection connection;

	public AlunoDAO(Connection connection) {
        this.connection = connection;
    }

	public Aluno cadastra(Aluno aluno) throws SQLException {

		String sql = "INSERT INTO aluno (codigo, nome, telefone, endereco, rg, cpf) VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			
			statement.setString(1,  aluno.getCodigo());
			statement.setString(2, aluno.getNome());
			statement.setString(3, aluno.getTelefone());
			statement.setString(4, aluno.getEndereco());
			statement.setString(5, aluno.getRg());
			statement.setString(6, aluno.getCpf());

			statement.execute();

			try (ResultSet keys = statement.getGeneratedKeys()) {
				keys.next();
				int id = keys.getInt(1);
				aluno.setId(id);
			}
			//statement.close();
		}
		return aluno;

	}

    public Aluno busca(Integer id) {

        try {
            PreparedStatement ps = this.connection
                    .prepareStatement("SELECT codigo, nome, telefone, endereco, rg, cpf FROM aluno WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            }
            Aluno aluno = new Aluno();
            aluno.setCodigo(rs.getString("codigo"));
            aluno.setNome(rs.getString("nome"));
            aluno.setTelefone(rs.getString("telefone"));
            aluno.setEndereco(rs.getString("endereco"));
            aluno.setRg(rs.getString("rg"));
            aluno.setCpf(rs.getString("cpf"));
            aluno.setId(id);
            //ps.close();
            return aluno;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Aluno> lista() {

        try {
            PreparedStatement ps = this.connection
                    .prepareStatement("SELECT * FROM aluno");
            ResultSet rs = ps.executeQuery();

            List<Aluno> lista = new ArrayList<Aluno>();

            while (rs.next()) {
            	String codigo = rs.getString("codigo");
            	String nome = rs.getString("nome");
            	String telefone = rs.getString("telefone");
            	String endereco = rs.getString("endereco");
            	String rg = rs.getString("rg");
            	String cpf = rs.getString("cpf");
            	int id = rs.getInt("id");
            	Aluno aluno = new Aluno(codigo, nome, telefone, endereco, rg, cpf);
            	aluno.setId(id);
            	
                lista.add(aluno);
            }

            //ps.close();
            return lista;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Aluno montaAluno (ResultSet rs) throws SQLException {
    	
    	if (!rs.next()) {
            return null;
        }
        Aluno aluno = new Aluno();
        aluno.setId(rs.getInt("id"));
        aluno.setCodigo((rs.getString("codigo")));
        aluno.setNome(rs.getString("nome"));
        aluno.setEndereco(rs.getString ("endereco"));
        aluno.setTelefone(rs.getString("telefone"));
        aluno.setRg(rs.getString("rg"));
        aluno.setCpf(rs.getString("cpf"));
        
        return aluno;
    }
}

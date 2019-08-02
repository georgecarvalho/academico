package com.ifma.formulario.infra;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {

	private Database() {
	}

	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection == null) {
			try {
				Properties propriedades = loadProperties();
				String url = propriedades.getProperty("dburl");
				connection = DriverManager.getConnection(url, propriedades);
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return connection;
	}

	private static Properties loadProperties() {

		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		}

		catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	/*
	 * public static Connection getConnection() throws SQLException {
	 * 
	 * return DriverManager .getConnection(
	 * "jdbc:mysql://localhost/lojadb?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
	 * "root", "root"); }
	 */

}

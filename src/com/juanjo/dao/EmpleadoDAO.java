package com.juanjo.dao;


import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.juanjo.model.Conexion;
import com.juanjo.model.DatosNoCorrectosException;
import com.juanjo.model.Empleado;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDAO {
	private Conexion con;

	public EmpleadoDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) throws SQLException {
		con = new Conexion(jdbcURL, jdbcUserName, jdbcPassword);
		con.connection();
		System.out.println(con.getJdbcConnection());
	}

	public void mostrarEmpleados() throws SQLException, ClassNotFoundException {
	

		int numEmp = 1;
		con.connection();
		Statement comando;
		comando = con.getJdbcConnection().createStatement();

		try (ResultSet rs = comando.executeQuery("select * from empleados");) {

			while (rs.next()) {
				System.out.println("Empleado " + numEmp + ":");
				System.out.println("Nombre: " + rs.getString(3) + ", dni: " + rs.getString(4) + " ,sexo: "
						+ rs.getString(5) + " ,categoria: " + rs.getInt(1) + " ,antiguedad: " + rs.getInt(2));
				numEmp++;
			}

		} catch (SQLException sqle) {

			System.out.println("Error en la ejecuci�n:" + sqle.getErrorCode() + " " + sqle.getMessage());

		}
		con.disconnect();
	};

	public List<Empleado> mostrar() throws SQLException, DatosNoCorrectosException {

		String sql = null;
		con.connection();
		Statement comando;
		comando = con.getJdbcConnection().createStatement();
		List<Empleado> listaEmpleado = new ArrayList<>();

		try {
			
			ResultSet rs = comando.executeQuery("select * from empleados");
			while (rs.next()) {
				String nombre, dni, sexo;
				int categoria, anyos;
				categoria = rs.getInt(1);
				anyos = rs.getInt(2);
				nombre = rs.getString(3);
				dni = rs.getString(4);
				sexo = rs.getString(5);
				Empleado emp = new Empleado(anyos, categoria, nombre, dni, sexo.charAt(0));
				listaEmpleado.add(emp);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return listaEmpleado;
	};

	public Map mostrarSalario(String dniB) throws SQLException, DatosNoCorrectosException {

		String sql = null;
		con.connection();
		Statement comando;
		comando = con.getJdbcConnection().createStatement();
		Map<String, Integer> listaSalarios = new HashMap<String, Integer>();

		try {
			
			ResultSet rs = comando.executeQuery("select * from nominas WHERE dni= "+dniB);
			while (rs.next()) {
				String dni;
				int sueldo;
				dni = rs.getString(1);
				sueldo = rs.getInt(2);
				listaSalarios.put(dni, sueldo);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return listaSalarios;
	}
}

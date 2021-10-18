package com.juanjo.dao;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.juanjo.model.Conexion;
import com.juanjo.model.DatosNoCorrectosException;
import com.juanjo.model.Empleado;
import com.mysql.jdbc.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDAO {
	private Conexion con;
	private PreparedStatement statement;

	public EmpleadoDAO(String jdbcURL, String jdbcUserName, String jdbcPassword) throws SQLException {
		con = new Conexion(jdbcURL, jdbcUserName, jdbcPassword);
		con.connection();
		System.out.println(con.getJdbcConnection());
	}
	
	public void crear(Empleado emp) throws SQLException {
		
		con.connection();
		
		try {

			statement = con.getJdbcConnection().prepareStatement("INSERT INTO empleados (categoria, anyos, nombre,sexo ,dni) VALUES(?,?,?,?,?)");

			statement.setInt(1, emp.getCategoria());
			statement.setInt(2, emp.getAnyos());
			statement.setString(3, emp.getNombre());
			String sexo = String.valueOf(emp.getSexo());
			statement.setString(4, sexo);
			statement.setString(5, emp.getDni());

			statement.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
		}
		
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
				Empleado emp = new Empleado(categoria, anyos, nombre, dni, sexo.charAt(0));
				listaEmpleado.add(emp);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return listaEmpleado;
	};

	public Map mostrarSalario(String dniB) throws SQLException, DatosNoCorrectosException {

		con.connection();
		Statement comando;
		comando = con.getJdbcConnection().createStatement();
		Map<String, Integer> listaSalarios = new HashMap<String, Integer>();

		try {

			ResultSet rs = comando.executeQuery("select * from nominas WHERE dni= " + dniB);
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

	public List<Empleado> obtenerEmpleadoDni(String dniB) throws DatosNoCorrectosException, SQLException {

		con.connection();
		Statement comando;
		comando = con.getJdbcConnection().createStatement();
		List<Empleado> listaEmpleado = new ArrayList<>();

		try {

			ResultSet rs = comando.executeQuery("select * from empleados WHERE dni='" + dniB + "'");
			while (rs.next()) {
				String nombre, dni, sexo;
				int categoria, anyos;
				categoria = rs.getInt(1);
				anyos = rs.getInt(2);
				nombre = rs.getString(3);
				dni = rs.getString(4);
				sexo = rs.getString(5);
				Empleado emp = new Empleado(categoria, anyos, nombre, dni, sexo.charAt(0));
				emp.imprime();
				listaEmpleado.add(emp);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return listaEmpleado;

	};

	public Empleado obtenerEmpleadoInd(String dniB) throws DatosNoCorrectosException, SQLException {

		con.connection();
		Statement comando;
		comando = con.getJdbcConnection().createStatement();
		Empleado emp = null;

		try {

			ResultSet rs = comando.executeQuery("select * from empleados WHERE dni='" + dniB + "'");
			while (rs.next()) {
				String nombre, dni, sexo;
				int categoria, anyos;
				categoria = rs.getInt(1);
				anyos = rs.getInt(2);
				nombre = rs.getString(3);
				dni = rs.getString(4);
				sexo = rs.getString(5);
				emp = new Empleado(categoria, anyos, nombre, dni, sexo.charAt(0));

			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return emp;

	};

	public List<Empleado> obtenerEmpleadoNombre(String nombreB) throws DatosNoCorrectosException, SQLException {

		con.connection();
		Statement comando;
		comando = con.getJdbcConnection().createStatement();
		List<Empleado> listaEmpleado = new ArrayList<>();

		try {

			ResultSet rs = comando.executeQuery("select * from empleados WHERE nombre='" + nombreB + "'");
			while (rs.next()) {
				String nombre, dni, sexo;
				int categoria, anyos;
				categoria = rs.getInt(1);
				anyos = rs.getInt(2);
				nombre = rs.getString(3);
				dni = rs.getString(4);
				sexo = rs.getString(5);
				Empleado emp = new Empleado(categoria, anyos, nombre, dni, sexo.charAt(0));
				emp.imprime();
				listaEmpleado.add(emp);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return listaEmpleado;

	};

	public List<Empleado> obtenerEmpleadoCategoria(int categoriaB) throws DatosNoCorrectosException, SQLException {

		con.connection();
		Statement comando;
		comando = con.getJdbcConnection().createStatement();
		List<Empleado> listaEmpleado = new ArrayList<>();

		try {

			ResultSet rs = comando.executeQuery("select * from empleados WHERE categoria=" + categoriaB);
			while (rs.next()) {
				String nombre, dni, sexo;
				int categoria, anyos;
				categoria = rs.getInt(1);
				anyos = rs.getInt(2);
				nombre = rs.getString(3);
				dni = rs.getString(4);
				sexo = rs.getString(5);
				Empleado emp = new Empleado(categoria, anyos, nombre, dni, sexo.charAt(0));
				emp.imprime();
				listaEmpleado.add(emp);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return listaEmpleado;

	};

	public List<Empleado> obtenerEmpleadoAntiguedad(int antiguedadB) throws DatosNoCorrectosException, SQLException {

		con.connection();
		Statement comando;
		comando = con.getJdbcConnection().createStatement();
		List<Empleado> listaEmpleado = new ArrayList<>();

		try {

			ResultSet rs = comando.executeQuery("select * from empleados WHERE anyos=" + antiguedadB);
			while (rs.next()) {
				String nombre, dni, sexo;
				int categoria, anyos;
				categoria = rs.getInt(1);
				anyos = rs.getInt(2);
				nombre = rs.getString(3);
				dni = rs.getString(4);
				sexo = rs.getString(5);
				Empleado emp = new Empleado(categoria, anyos, nombre, dni, sexo.charAt(0));
				emp.imprime();
				listaEmpleado.add(emp);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return listaEmpleado;

	};

	public List<Empleado> obtenerEmpleadoSexo(String sexoB) throws DatosNoCorrectosException, SQLException {

		String sql = null;
		con.connection();
		Statement comando;
		comando = con.getJdbcConnection().createStatement();
		List<Empleado> listaEmpleado = new ArrayList<>();

		try {

			ResultSet rs = comando.executeQuery("select * from empleados WHERE sexo= '" + sexoB + "'");
			while (rs.next()) {
				String nombre, dni, sexo;
				int categoria, anyos;
				categoria = rs.getInt(1);
				anyos = rs.getInt(2);
				nombre = rs.getString(3);
				dni = rs.getString(4);
				sexo = rs.getString(5);
				Empleado emp = new Empleado(categoria, anyos, nombre, dni, sexo.charAt(0));
				listaEmpleado.add(emp);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return listaEmpleado;

	};

	public void editar(Empleado emp, String dniB) throws SQLException {

		con.connection();

		try {

			statement = con.getJdbcConnection()
					.prepareStatement("UPDATE empleados SET categoria=?, anyos=?, nombre=?, sexo=? WHERE dni=?");

			statement.setInt(1, emp.getCategoria());
			statement.setInt(2, emp.getAnyos());
			statement.setString(3, emp.getNombre());
			String sexo = String.valueOf(emp.getSexo());
			statement.setString(4, sexo);
			statement.setString(5, emp.getDni());

			statement.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
		}

	};

	public void eliminar(String dniB) throws SQLException {

		con.connection();

		try {

			statement = con.getJdbcConnection().prepareStatement("DELETE FROM empleados WHERE dni=?");

			statement.setString(1, dniB);

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	};

}

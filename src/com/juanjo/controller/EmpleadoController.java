package com.juanjo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.juanjo.dao.EmpleadoDAO;
import com.juanjo.model.DatosNoCorrectosException;
import com.juanjo.model.Empleado;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class EmpleadoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpleadoDAO empDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpleadoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUserName = getServletContext().getInitParameter("jdbcUserName");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		System.out.println(jdbcURL);
		try {
			empDAO = new EmpleadoDAO(jdbcURL, jdbcUserName, jdbcPassword);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opcion = request.getParameter("opcion");

		switch (opcion) {
		case "mostrar":
			try {

				List<Empleado> listaEmpleado = new ArrayList<>();
				listaEmpleado = empDAO.mostrar();

				request.setAttribute("listaEmpleado", listaEmpleado);
				RequestDispatcher requesDispatcher = request.getRequestDispatcher("vista/Mostrar.jsp");
				requesDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatosNoCorrectosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "buscaSalario":
			try {
				RequestDispatcher requesDispatcher = request.getRequestDispatcher("vista/BuscaSalario.jsp");
				requesDispatcher.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "buscaEmpleado":
			try {
				RequestDispatcher requesDispatcher = request.getRequestDispatcher("vista/BuscaModificar.jsp");
				requesDispatcher.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case "creaEmpleado":
			try {
				RequestDispatcher requesDispatcher = request.getRequestDispatcher("vista/crear.jsp");
				requesDispatcher.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "editar":
			try {
				String dni = request.getParameter("dni");
				Empleado emp=empDAO.obtenerEmpleadoInd(dni);
				request.setAttribute("empleado", emp);
				RequestDispatcher requesDispatcher = request.getRequestDispatcher("vista/editar.jsp");
				requesDispatcher.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "eliminar":

			try {
				String dni = request.getParameter("dni");
				empDAO.eliminar(dni);
				System.out.println("Eliminado");
				RequestDispatcher requesDispatcher = request.getRequestDispatcher("index.jsp");
				requesDispatcher.forward(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		default:
			break;
		}

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");

		switch (opcion) {
		case "editar":

			try {
				String dni = request.getParameter("dni");
				String nombre = request.getParameter("nombre");
				int categoria = Integer.parseInt(request.getParameter("categoria"));
				int antiguedad = Integer.parseInt(request.getParameter("antiguedad"));
				String sexo = request.getParameter("sexo");
				Empleado emp = new Empleado(categoria, antiguedad, nombre, dni, sexo.charAt(0));
				empDAO.editar(emp, dni);
				System.out.println("Actualizado");
				RequestDispatcher requesDispatcher = request.getRequestDispatcher("index.jsp");
				requesDispatcher.forward(request, response);
			} catch (DatosNoCorrectosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case "crear":

			try {
				String dni = request.getParameter("dni");
				String nombre = request.getParameter("nombre");
				int categoria = Integer.parseInt(request.getParameter("categoria"));
				int antiguedad = Integer.parseInt(request.getParameter("antiguedad"));
				String sexo = request.getParameter("sexo");
				Empleado emp = new Empleado(categoria, antiguedad, nombre, dni, sexo.charAt(0));
				empDAO.crear(emp);
				System.out.println("Creado nuevo empleado");
				RequestDispatcher requesDispatcher = request.getRequestDispatcher("index.jsp");
				requesDispatcher.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "busquedaDni":
			try {
				String dniB = request.getParameter("dniB");
				System.out.println(dniB);
				List<Empleado> listaEmpleado = new ArrayList<>();
				listaEmpleado = empDAO.obtenerEmpleadoDni(dniB);
				System.out.println(listaEmpleado.size());
				request.setAttribute("listaEmpleado", listaEmpleado);
				RequestDispatcher requesDispatcher = request.getRequestDispatcher("vista/Mostrar.jsp");
				requesDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatosNoCorrectosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "busquedaNombre":

			try {
				String nombreB = request.getParameter("nombreB");
				System.out.println(nombreB);
				List<Empleado> listaEmpleado = new ArrayList<>();
				listaEmpleado = empDAO.obtenerEmpleadoNombre(nombreB);
				System.out.println(listaEmpleado.size());
				request.setAttribute("listaEmpleado", listaEmpleado);
				RequestDispatcher requesDispatcher = request.getRequestDispatcher("vista/Mostrar.jsp");
				requesDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatosNoCorrectosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "busquedaCategoria":

			try {
				String categoriaB = request.getParameter("categoriaB");
				int categoria = Integer.parseInt(categoriaB);
				System.out.println(categoria);
				List<Empleado> listaEmpleado = new ArrayList<>();
				listaEmpleado = empDAO.obtenerEmpleadoCategoria(categoria);
				System.out.println(listaEmpleado.size());
				request.setAttribute("listaEmpleado", listaEmpleado);
				RequestDispatcher requesDispatcher = request.getRequestDispatcher("vista/Mostrar.jsp");
				requesDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatosNoCorrectosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "busquedaAntiguedad":

			try {
				String antiguedadB = request.getParameter("antiguedadB");
				int antiguedad = Integer.parseInt(antiguedadB);
				System.out.println(antiguedad);
				List<Empleado> listaEmpleado = new ArrayList<>();
				listaEmpleado = empDAO.obtenerEmpleadoAntiguedad(antiguedad);
				System.out.println(listaEmpleado.size());
				request.setAttribute("listaEmpleado", listaEmpleado);
				RequestDispatcher requesDispatcher = request.getRequestDispatcher("vista/Mostrar.jsp");
				requesDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatosNoCorrectosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "busquedaSexo":

			try {
				String sexoB = request.getParameter("sexoB");
				List<Empleado> listaEmpleado = new ArrayList<>();
				listaEmpleado = empDAO.obtenerEmpleadoSexo(sexoB);
				System.out.println(listaEmpleado.size());
				request.setAttribute("listaEmpleado", listaEmpleado);
				RequestDispatcher requesDispatcher = request.getRequestDispatcher("vista/Mostrar.jsp");
				requesDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatosNoCorrectosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "salario":
			try {
				String dniB = request.getParameter("dniB");
				Map<String, Integer> salario = new HashMap<String, Integer>();
				salario = empDAO.mostrarSalario(dniB);

				if (salario.isEmpty()) {
					RequestDispatcher requesDispatcher = request.getRequestDispatcher("vista/BuscaSalario.jsp");
					requesDispatcher.forward(request, response);
				} else {
					request.setAttribute("salario", salario);
					RequestDispatcher requesDispatcher = request.getRequestDispatcher("vista/BuscaSalario.jsp");
					requesDispatcher.forward(request, response);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DatosNoCorrectosException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
	}

}

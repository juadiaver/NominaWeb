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

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

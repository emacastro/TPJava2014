package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entidades.Electrodomestico;
import Entidades.Lavarropas;
import Entidades.Television;
import Negocio.NegElectrodomestico;

/**
 * Servlet implementation class ElectrodomesticosServlet
 */
@WebServlet("/ElectrodomesticosServlet")
public class ElectrodomesticosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElectrodomesticosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Tipo: " + request.getParameter("tipoElectrodomestico"));
		System.out.println("Precio: " + request.getParameter("precio"));
		System.out.println("Consumo: " + request.getParameter("consumo"));
		System.out.println("Peso: " + request.getParameter("peso"));
		System.out.println("Carga: " + request.getParameter("carga"));
		System.out.println("Resolucion: " + request.getParameter("resolucion"));
		System.out.println("Sintonizador: " + request.getParameter("sintonizador"));
		System.out.println("Color: " + request.getParameter("color"));
		NegElectrodomestico ne = new NegElectrodomestico();
		int id = ne.ultimoID();
		double precio = Double.parseDouble(request.getParameter("precio"));
		char consumo = request.getParameter("consumo").charAt(0);
		double peso = Double.parseDouble(request.getParameter("peso"));
		double carga;
		if (request.getParameter("carga").equals("")){
			carga = 5;
		}
		else {
			carga = Double.parseDouble(request.getParameter("carga"));
		}
		int resol;
		if(request.getParameter("resolucion").equals("")){
			resol = 20;
		}
		else {
			resol  = Integer.parseInt(request.getParameter("resolucion"));
		}
		boolean sint = false;
		if(request.getParameter("sintonizador").equals("1")){
			sint = true;
		}
		String color = request.getParameter("color");
		String tipo = request.getParameter("tipoElectrodomestico");
		Electrodomestico e = null;
		if (tipo.equals("Lavarropas")) {
			Lavarropas l = new Lavarropas(id,precio,consumo,color, peso, carga);
			e = l;
			}
		else if(tipo.equals("Televisor")) {
			Television t = new Television(id,precio,consumo,color, peso, resol, sint);
			e = t;
		}
			ne.nuevoElectrodomestico(e);
			response.sendRedirect("index.jsp");
			System.out.println("Se logro la carga del electrodomestico");
	}

}

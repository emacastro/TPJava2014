<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Negocio.*" %>
<%@ page import="Entidades.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
	<meta charset="UTF-8">
	<title>TPJava</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link href="css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    	
<div class="container">
  <div class="row clearfix">
    <div class="col-md-12 column">

      <!-- Nav inicial -->
    	 <nav class="navbar navbar-default">
    			<div id="navbar" class="navbar-collapse collapse">
    				<p><h1 align="center">Trabajo Práctico de JAVA 2014</h1></p>
    			</div>
    	 </nav>

    <!-- Tabla -->
    
      <div class="table-responsive"> 
          <table class="table table-bordered">
              <thead>
                  <tr>
                      <th>ID</th>
                      <th>Tipo</th>
                      <th>Color</th>
                      <th>Consumo</th>
                      <th>Peso</th>
                      <th>Carga</th>
                      <th>Resolución</th>
                      <th>TDT</th>
                      <th>Precio</th>
                  </tr>
              </thead>
              <tbody>
              	<%! ArrayList<Electrodomestico> elecs = (new NegElectrodomestico()).listarElectrodomesticos(); %>
                  <%
                  for(Electrodomestico el: elecs) {
                  %>
                  <tr>
                  <td> <%= el.getId() %>
                  </td>
                  <td> <%= el.getClass().getSimpleName() %>
                  </td>
                  <td> <%= el.getColor().getColor() %>
                  </td>
                  <td> <%= el.getConsumo().getConsumo() %>
                  </td>
                  <td> <%= el.getPeso() %>
                  </td>
                  <td> Carga
                  </td>
                  <td> Resolucion
                  </td>
                  <td> Sintonizador
                  </td>
                  <td> <%= el.getPrecioBase() %>
                  </td>
                  </tr>
                  <%
                  }
                  %>
              </tbody>
          </table>
      </div>

      <div class="row clearfix">
        <div class="col-md-4 column">
        </div>
        <div class="col-md-4 column">
          <div class="btn-group btn-group-md">
            <button type="button" onclick=" location.href='nuevoElectrodomestico.html'" class="btn btn-default">Agregar</button>
            <button type="button" class="btn btn-default">Modificar</button>
            <button type="button" class="btn btn-default">Eliminar</button>
            <button type="button" class="btn btn-default">Búsqueda</button>
          </div>
        </div>
        <div class="col-md-4 column">
        </div>
      </div>

      
    </div>
  </div>
</div>

	<script src="js/bootstrap.min.js"></script>
</body>
</html>
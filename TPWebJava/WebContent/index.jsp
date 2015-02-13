<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"
    import="Entidades.*"
 	import="Negocio.*" %>

<% ArrayList<Electrodomestico> elecs = new ArrayList<Electrodomestico>(); %>
<% elecs = (ArrayList<Electrodomestico>)(new NegElectrodomestico()).listarElectrodomesticos(); %>

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
              	
                  <%
                  for(int i=0;i<elecs.size();i++) {
                  %>
                  <tr>
                  <td> <%= elecs.get(i).getId() %>
                  </td>
                  <td> <%= elecs.get(i).getClass().getSimpleName() %>
                  </td>
                  <td> <%= elecs.get(i).getColor().getColor() %>
                  </td>
                  <td> <%= elecs.get(i).getConsumo().getConsumo() %>
                  </td>
                  <td> <%= elecs.get(i).getPeso() %>
                  </td>
                  <td> <% if (elecs.get(i) instanceof Lavarropas){%>
                	  <%= ((Lavarropas)elecs.get(i)).getCarga() %>
                  <%}%>
                  </td>
                  <td> <% if (elecs.get(i) instanceof Television){%>
                	  <%= ((Television)elecs.get(i)).getResolucion() %>
                  <%}%>
                  </td>
                  <td> <% if (elecs.get(i) instanceof Television){
                	  		boolean sint = ((Television)elecs.get(i)).isSintonizador();
                	  		if(sint){%>
                		  		<span class="glyphicon glyphicon-ok"></span> 
                	  <%}%>
                  <%}%>
                  </td>
                  <td> <%= elecs.get(i).getPrecioBase() %>
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
        <div class="col-md-6 column">
          <div class="btn-group btn-group-md">
            <button type="button" onclick=" location.href='nuevoElectrodomestico.jsp'" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span> Agregar</button>
            <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-refresh"></span> Modificar</button>
            <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-trash"></span> Eliminar</button>
            <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-search"></span> Búsqueda</button>
          </div>
        </div>
        <div class="col-md-2 column">
        </div>
      </div>

      
    </div>
  </div>
</div>

	<script src="js/bootstrap.min.js"></script>
</body>
</html>
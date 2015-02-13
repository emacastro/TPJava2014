<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<title>Nuevo Electrodomestico</title>
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/personalizado.css" rel="stylesheet">
  <script src="js/jquery-2.1.3.js" type="text/javascript"></script>
  <script>
  $(document).ready(function () {
	  $('#tipoElectrodomestico').change(function(){
		  var elegido = $('#tipoElectrodomestico option:selected').text();
		  if(elegido=="Lavarropas"){
			  $('div').removeClass('vacio');
			  $('div').removeClass('vacioLav');
		  }
		  else if(elegido=="Televisor"){
			  $('div').removeClass('vacio');
			  $('div').removeClass('vacioTel');
		  }
		  else{ //Si se selecciona la opcion en blanco se aplica a todos los div, osea queda todo blanco
			  $('div').addClass('vacio');
			  $('div').addClass('vacioLav');
			  $('div').addClass('vacioTel');
		  };
	  });
  });
  
  function predeterminados() {
	  var precio = document.getElementById("precio").valueOf();
	  if(precio==null){
		  precio = 100;
	  }
	  var peso = document.getElementById("peso").valueOf();
	  if(peso == null){
		  peso = 5;
	  }
	  var color= document.getElementById("color").selectIndex();
	  if(color== null || color== 0){
		  color.value = blanco; 
	  };
	  var consumo = document.getElementById("consumo").selectIndex();
	  if(consumo == null || consumo== 0){
		  consumo.value = F; 
	  }
	  var carga = document.getElementById("carga").valueOf();
	  if(carga==null){
		  carga = 5;
	  }
	  var resolucion= document.getElementById("resolucion").valueOf();
	  if(resolucion==null){
		  resolucion = 20;
	  }
	  var sintonizador = document.getElementsByName("sintonizador").valueOf();
	  if (sintonizador == null || sintonizador == 0){
		  sintonizador = 2;
	  }
  }
  </script>
</head>
<body>
	<div class="container">
		<form action="ElectrodomesticosServlet" method="post" class="form-horizontal" onsubmit="return predeterminados()">
		<fieldset>
		
		<!-- Form Name -->
		<legend>Electrodomestico</legend>
		
		<!-- Select Basic -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="tipoElectrodomestico">Tipo de Electrodomestico</label>
		  <div class="col-md-4">
		    <select id="tipoElectrodomestico" name="tipoElectrodomestico" class="form-control">
		      <option value="Vacio"></option>
		      <option value="Lavarropas">Lavarropas</option>
		      <option value="Televisor">Televisor</option>
		    </select>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group vacio">
		  <label class="col-md-4 control-label" for="precio">Precio</label>  
		  <div class="col-md-2">
		  <input id="precio" name="precio" type="text" placeholder="100" class="form-control input-md">
		  <span class="help-block">Precio del Electrodomestico</span>  
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group vacio">
		  <label class="col-md-4 control-label" for="peso">Peso</label>  
		  <div class="col-md-2">
		  <input id="peso" name="peso" type="text" placeholder="5.0" class="form-control input-md">
		  <span class="help-block">Peso del Eletrodomestico</span>  
		  </div>
		</div>
		
		<!-- Select Basic -->
		<div class="form-group vacio">
		  <label class="col-md-4 control-label" for="color">Color</label>
		  <div class="col-md-4">
		    <select id="color" name="color" class="form-control">
		      <option value="blanco" selected>blanco</option>
		      <option value="negro">negro</option>
		      <option value="rojo">rojo</option>
		      <option value="azul">azul</option>
		      <option value="gris">gris</option>
		    </select>
		  </div>
		</div>
		
		<!-- Select Basic -->
		<div class="form-group vacio">
		  <label class="col-md-4 control-label" for="consumo">Consumo Energetico</label>
		  <div class="col-md-2">
		    <select id="consumo" name="consumo" class="form-control">
		      <option value="A">A</option>
		      <option value="B">B</option>
		      <option value="C">C</option>
		      <option value="D">D</option>
		      <option value="E">E</option>
		      <option value="F" selected>F</option>
		    </select>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group vacioLav">
		  <label class="col-md-4 control-label" for="carga">Carga</label>  
		  <div class="col-md-2">
		  <input id="carga" name="carga" type="text" placeholder="5" class="form-control input-md">
		  <span class="help-block">Carga del Lavarropas</span>  
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group vacioTel">
		  <label class="col-md-4 control-label" for="resolucion">Resolucion</label>  
		  <div class="col-md-2">
		  <input id="resolucion" name="resolucion" type="text" placeholder="20" class="form-control input-md">
		  <span class="help-block">Resolucion del Televisor</span>  
		  </div>
		</div>
		
		<!-- Multiple Radios (inline) -->
		<div class="form-group vacioTel">
		  <label class="col-md-4 control-label" for="sintonizador">Sintonizador</label>
		  <div class="col-md-4"> 
		    <label class="radio-inline" for="sintonizador-0">
		      <input type="radio" name="sintonizador" id="sintonizador-0" value="1">
		      Si
		    </label> 
		    <label class="radio-inline" for="sintonizador-1">
		      <input type="radio" name="sintonizador" id="sintonizador-1" checked value="2">
		      No
		    </label>
		  </div>
		</div>
		
		<!-- Button (Double) -->
		<div class="form-group vacio">
		  <label class="col-md-4 control-label" for="aceptar">Guardar Datos</label>
		  <div class="col-md-8">
		    <button type="submit" id="aceptar" name="aceptar" class="btn btn-success">Aceptar</button>
		    <button id="cancelar" name="cancelar" class="btn btn-danger">Cancelar</button>
		  </div>
		</div>
		
		</fieldset>
	</form>

	</div>

  <script src="js/bootstrap.min.js"></script>
</body>
</html>
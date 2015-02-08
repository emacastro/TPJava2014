<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="UTF-8">
<title>Nuevo Electrodomestico</title>
  <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<form action="" class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Electrodomestico</legend>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="tipoElectrodomestico">Tipo de Electrodomestico</label>
  <div class="col-md-4">
    <select id="tipoElectrodomestico" name="tipoElectrodomestico" class="form-control">
      <option value="1">Lavarropas</option>
      <option value="2">Televisor</option>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="precio">Precio</label>  
  <div class="col-md-2">
  <input id="precio" name="precio" type="text" placeholder="100.0" class="form-control input-md">
  <span class="help-block">Precio del Electrodomestico</span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="peso">Peso</label>  
  <div class="col-md-2">
  <input id="peso" name="peso" type="text" placeholder="5.0" class="form-control input-md">
  <span class="help-block">Peso del Eletrodomestico</span>  
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="color">Color</label>
  <div class="col-md-4">
    <select id="color" name="color" class="form-control">
      <option value="1">blanco</option>
      <option value="2">negro</option>
      <option value="3">rojo</option>
      <option value="4">azul</option>
      <option value="5">gris</option>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="consumo">Consumo Energetico</label>
  <div class="col-md-2">
    <select id="consumo" name="consumo" class="form-control">
      <option value="1">A</option>
      <option value="2">B</option>
      <option value="3">C</option>
      <option value="4">D</option>
      <option value="5">E</option>
      <option value="6">F</option>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="carga">Carga</label>  
  <div class="col-md-2">
  <input id="carga" name="carga" type="text" placeholder="5" class="form-control input-md">
  <span class="help-block">Carga del Lavarropas</span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="resolucion">Resolucion</label>  
  <div class="col-md-2">
  <input id="resolucion" name="resolucion" type="text" placeholder="20" class="form-control input-md">
  <span class="help-block">Resolucion del Televisor</span>  
  </div>
</div>

<!-- Multiple Radios (inline) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="sintonizador">Sintonizador</label>
  <div class="col-md-4"> 
    <label class="radio-inline" for="sintonizador-0">
      <input type="radio" name="sintonizador" id="sintonizador-0" value="1" checked="checked">
      Si
    </label> 
    <label class="radio-inline" for="sintonizador-1">
      <input type="radio" name="sintonizador" id="sintonizador-1" value="2">
      No
    </label>
  </div>
</div>

<!-- Button (Double) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="aceptar">Guardar Datos</label>
  <div class="col-md-8">
    <button id="aceptar" name="aceptar" class="btn btn-success">Aceptar</button>
    <button id="cancelar" name="cancelar" class="btn btn-danger">Cancelar</button>
  </div>
</div>

</fieldset>
</form>

	</div>

  <script src="js/bootstrap.min.js"></script>
</body>
</html>
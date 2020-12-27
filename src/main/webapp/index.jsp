<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Proyecto ASR new...</title>
</head>
<body>
<h1>ASR PRACTICA FINAL</h1>
<hr />
<form action="listar" method="post">
Contenido de la Base de Datos
<input type="submit" value="Mostrar"></input>
</form>
<form action="insertar" method="post">
Traducir e Insertar Palabra:
<input type="text" name="palabra"></input>
<input type="submit" value="Insertar"></input>
</form>
<form action="hablar" method="post">
Texto a Convertir
<input type="text" name="texto"></input>
<input type="submit" value="Convertir"></input>
</form>
</body>
</html>
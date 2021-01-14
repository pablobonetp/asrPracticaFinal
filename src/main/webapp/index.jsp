<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="Style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ASR PRACTICA FINAL</title>
</head>
<body>
<div class="page">
<div class="cabecera">
<h1>ASR PRACTICA FINAL</h1>
<h3>Pablo Bonet y Delia Clar</h3>
</div>
<hr />
<form action="listar" method="post">
<input type="submit" value="Mostrar Contenido de la Base de Datos"></input>
</form>
<form action="insertar" method="post">
Traducir e Insertar Palabra:
<input type="text" name="palabra"></input>
<input type="submit" value="Insertar"></input>
</form>
<form action="text2speech" method="post">
Texto a Convertir
<input type="text" name="texto"></input>
Archivo
<input type="text" name="archivo"></input>
<input type="submit" value="Convertir"></input>
</form>
<form action="speech2text" method="post">
Leer Archivo
<input type="text" name="archivobuscar"></input>
<input type="submit" value="Convertir a Texto"></input>
</form>
</div>
<hr />
</body>
</html>
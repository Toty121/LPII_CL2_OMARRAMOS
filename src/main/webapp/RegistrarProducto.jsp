<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Producto</title>
</head>
<body bgcolor="#c5dec9">
<h1 align="center">
Registrar Producto
</h1>
<form action="ControladorProducto" method="post">
<table align="center">
<tr>
<td>NOMBRE PRODUCTO</td>
<td><input type="text" name="nombre"></td>
</tr>
<tr>
<td>PRECIO VENTA PRODUCTO</td>
<td><input type="text" name="precioventa"></td>
</tr>
<tr>
<td>PRECIO COMPRA PRODUCTO</td>
<td><input type="text" name="preciocompra"></td>
</tr>
<tr>
<td>ESTADO DEL PRODUCTO</td>
<td><input type="text" name="estado"></td>
</tr>
<tr>
<td>DESCRIPCION DEL PRODUCTO</td>
<td><input type="text" name="descripcion"></td>
</tr>
<tr>
<td colspan="2" style="text-align:center">
<input type="submit" value="Registrar">
</td>
</tr>
</table>
</form>
<!-- Botón para regresar al índice -->
<div style="text-align: center; margin-top: 20px;">
    <a href="index.jsp" style="text-decoration: none; padding: 10px 20px; background-color: #4CAF50; color: white; border-radius: 5px;">Regresar al Índice</a>
</div>
</body>
</html>

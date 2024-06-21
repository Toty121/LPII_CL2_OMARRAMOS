<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Listado de Productos</title>
      <style>
   body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            margin: 20px;
        }
        h1 {
            text-align: center;
            color: #333;
            margin-top: 0;
            padding-top: 20px;
            border-top: 2px solid #333;
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
            background-color: #fff;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #ddd;
        }
        .no-data {
            text-align: center;
            padding: 20px;
            color: #999;
        }
    </style>
</head>
<body>
    <h1>Listado de Productos</h1>
    <%@ page import="java.util.List" %>
    <%@ page import="model.TblProductocl2" %>
    <% List<TblProductocl2> listadoproducto = (List<TblProductocl2>) request.getAttribute("listadoproducto"); %>
    <% if (listadoproducto != null && !listadoproducto.isEmpty()) { %>
        <table border="1">
            <!-- Encabezados de la tabla -->
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NOMBRE </th>
                    <th>PRECIO VENTA </th>
                    <th>PRECIO COMPRA</th>
                    <th>ESTADO </th>
                    <th>DESCRIPCION</th>
                </tr>
            </thead>
            <!-- Datos de los productos -->
            <tbody>
                <% for (TblProductocl2 producto : listadoproducto) { %>
                    <tr>
                        <td><%= producto.getIdproductocl2() %></td>
                        <td><%= producto.getNombrecl2() %></td>
                        <td><%= producto.getPrecioventacl2() %></td>
                        <td><%= producto.getPreciocompcl2() %></td>
                        <td><%= producto.getEstadocl2() %></td>
                        <td><%= producto.getDescripcl2() %></td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        <!-- Botón para volver al formulario de registro -->
      <div style="text-align: center; margin-top: 20px;">
    <a href="RegistrarProducto.jsp" style="text-decoration: none; padding: 10px 20px; background-color: #4CAF50; color: white; border-radius: 5px;">Volver a Registrar Producto</a>
</div>

    <% } else { %>
        <div class="no-data">
            <p>NO HAY PRODUCTOS REGISTRADOS.</p>
        </div>
    <% } %>
</body>
</html>


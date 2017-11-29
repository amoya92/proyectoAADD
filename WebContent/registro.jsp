<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro usuario</title>
</head>
<body>
<div style="border:solid; border-color:blue; width:25%; padding-left:2%; padding-bottom:2%">
	<h3>Registrate en nuestra aplicación</h3>
		<form name="registro" action="ServletRegistro" method="post">
			<table>
				<tr>
					<td><label>Usuario:</label></td>
					<td><input type="text" name="usuario" /></td>
				</tr>
				<tr>
					<td><label>Telefono:</label></td>
					<td><input type="text" name="telefono" /></td>
				</tr>
				<tr>
					<td><label>Email:</label></td>
					<td><input type="email" name="email"/></td>
				</tr>
				<tr>
					<td><label>Contraseña:</label></td>
					<td><input type="password" name="clave" /></td>
				</tr>
				<tr>
					<td><label>Repite contraseña:</label></td>
					<td><input type="password" name="clave2" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Registrar" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
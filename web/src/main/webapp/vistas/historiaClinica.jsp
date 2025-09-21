<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="uy.edu.fing.tse.entidades.HistoriaClinica" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Historias Clínicas</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 2rem;
            background-color: #f9f9f9;
        }
        h2 {
            color: #333;
        }
        ul {
            padding: 0;
            list-style-type: none;
        }
        li {
            background: #fff;
            margin: 0.5rem 0;
            padding: 0.8rem;
            border-radius: 6px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        form {
            margin-top: 2rem;
            background: #fff;
            padding: 1rem;
            border-radius: 6px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        input, textarea {
            width: 100%;
            margin: 0.5rem 0;
            padding: 0.6rem;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        input[type=submit] {
            background-color: #007BFF;
            color: white;
            font-weight: bold;
            cursor: pointer;
        }
        input[type=submit]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
    <body>
        <h2>Historias Clínicas</h2>

        <h3>Crear nueva Historia Clínica</h3>
        <form method="post" action="historiaClinica">
            <label>Paciente ID:</label>
            <input type="text" name="pacienteId" required>

            <label>Prestador:</label>
            <input type="text" name="prestador" required>

            <label>Especialidad:</label>
            <input type="text" name="especialidad" required>

            <label>Motivo de Consulta:</label>
            <textarea name="motivoConsulta" required></textarea>

            <input type="submit" value="Crear">
        </form>

        <h3>Historias</h3>
        <c:choose>
            <c:when test="${not empty historias}">
                <ul>
                    <c:forEach var="hc" items="${historias}">
                        <li>
                            <strong>ID:</strong> ${hc.id} <br>
                            <strong>Paciente:</strong> ${hc.idUsuarioSalud} <br>
                            <strong>Prestador:</strong> ${hc.prestador} <br>
                            <strong>Especialidad:</strong> ${hc.especialidad} <br>
                            <strong>Motivo:</strong> ${hc.motivoConsulta} <br>
                            <strong>Fecha:</strong> ${hc.fechaCreacion}
                        </li>
                    </c:forEach>
                </ul>
            </c:when>
            <c:otherwise>
                <p>No hay historias clínicas registradas.</p>
            </c:otherwise>
        </c:choose>

    </body>
</html>
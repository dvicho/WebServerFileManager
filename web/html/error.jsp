<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: vicho
  Date: 17/10/16
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Consulta de archivos</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/estilos.css"/>
</head>
<body>
<div id="header">
    <h1>Administrador de archivos</h1>
</div>
<div id="menu">
    <s:a action="index">Consultar archivos</s:a>
    <s:a action="subirArchivoForm">Subir archivos</s:a>
    <a href="">Otra operación</a>
</div>
<div id="content-wrapper">
    <div id="content">
        <h2>Error</h2>
        <p>
            Ocurrió un error. <span class="mensaje-error"><s:property value="mensajeError"/></span></p>
        </p>
        <p>
            <s:a href="index.action">Regresar</s:a>
        </p>
    </div>
</div>
<div id="footer">
    <span id="copyrigth">© 2016</span> <span id="app-version">Versión 1.1</span>
</div>
</body>
</html>

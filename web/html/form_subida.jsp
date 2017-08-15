<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="dev" uri="/devicho-tags"%>
<%--
  Created by IntelliJ IDEA.
  User: vicho
  Date: 20/10/16
  Time: 19:27
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
            <h2>Subida de archivos</h2>
            <s:form action="subirArchivo" method="post" enctype="multipart/form-data">
                <s:file label="Archivo" name="archivo" size="100"/>
                <s:textfield label="Guardar como" name="nombreArchivoGuardarComo"/>
                <s:radio label="Carpeta destino" name="destino" list="#{'1': 'config', '2': 'log'}" value="1"/>
                <s:submit value="Subir archivo" />
            </s:form>
        </div>
    </div>
    <div id="footer">
        <span id="copyrigth">© 2016</span> <span id="app-version">Versión 1.1</span>
    </div>
</body>
</html>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="dev" uri="/devicho-tags"%>
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
        <h2>Consulta</h2>
        <s:form action="buscar" method="POST">
            <s:radio label="Carpeta" name="tipo" list="#{'1': 'config', '2': 'log'}" />
            <s:checkbox label="Incluir subdirectorios" name="verEnSubdirectorios"/>
            <s:submit value="Buscar" />
        </s:form>
        <s:if test="%{getListaArchivos() == null || getListaArchivos().isEmpty()}">
            <p>No se encontraron archivos para mostrar.</p>
        </s:if>
        <s:else>
            <s:form action="borrar" method="POST">
                <s:submit value="Borrar Archivo"/>
            <table class="tabla-archivos">
                <tr>
                    <th>&nbsp;</th>
                    <th>Nombre del archivo</th>
                </tr>
            <s:iterator value="listaArchivos" status="row" var="archivo">
                <s:url var="mostrarArchivo" action="mostrarArchivo">
                    <s:param name="nombreArchivo"><s:property/></s:param>
                </s:url>
                <s:if test="#row.odd">
                <tr class="fila-impar">
                </s:if>
                <s:else>
                <tr class="fila-par">
                </s:else>
                    <td><input type="checkbox" name="listaArchivos" value="${archivo}"/></td>
                    <td><s:a href="%{mostrarArchivo}"><dev:value value="${archivo}"
                                                                cssClassDiretorio="directorio"
                                                                cssClassSeparador="file-separator"/></s:a></td>
                </tr>
            </s:iterator>
            </table>
                <s:submit value="Borrar Archivo"/>
            </s:form>
        </s:else>
    </div>
</div>
<div id="footer">
    <span id="copyrigth">© 2018</span> <span id="app-version">Versión 1.2</span>
</div>
</body>
</html>

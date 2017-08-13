<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="dev" uri="/devicho-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: vicho
  Date: 18/10/16
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Descarga archivo</title>
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
        <h2>Mostrando archivo</h2>
        <h3></h3>
        <table class="tabla-archivos">
            <tr>
                <th>&nbsp;</th>
                <th><s:property value="nombreArchivo"/> (<s:property value="lineasTotales"/> líneas)</th>
            </tr>
            <s:iterator value="lineas" status="row" var="linea">
                <s:if test="#row.odd">
                    <tr class="fila-impar">
                </s:if>
                <s:else>
                    <tr class="fila-par">
                </s:else>
                <td class="numero-linea"><s:property value="#row.count"/>:</td>
                <s:if test="%{getTipoArchivo() == 1}">
                    <td><dev:properties value="${linea}"
                                        classComment="comentario-properties"
                                        classKey="key-properties"
                                        classValue="value-properties"
                                        classEqual="equal-properties"/></td>
                </s:if>
                <s:elseif test="%{getTipoArchivo() == 2}">
                    <td><dev:log value="${linea}"/></td>
                </s:elseif>
                <s:else>
                    <td><s:property/></td>
                </s:else>
                </tr>
            </s:iterator>
        </table>
    </div>
</div>
<div id="footer">
    <span id="copyrigth">© 2016</span> <span id="app-version">Versión 1.1</span>
</div>
</body>
</html>

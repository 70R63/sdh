<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Error en el servidor</title>
    </head>
    <body>
        <p>Ocurri� un error, se redirige a la p�gina inicial</p>
        <c:redirect url="/"/>
    </body>
</html>

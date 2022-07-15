<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!doctype html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plantilla de Boca Juniors</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" >
        <script src="https://kit.fontawesome.com/cc04444cc5.js" crossorigin="anonymous"></script>
        
    <body style=" background-image: linear-gradient(60deg, #64b3f4 0%, #c2e59c 100%);">
        <!-- Incluyo la cabecera -->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <!-- Incluyo la pagina de navegacion -->
        <jsp:include page="/WEB-INF/paginas/comunes/navegacion.jsp"/> 
        <!--incluyo la pagina de listarJugadores-->
        <jsp:include page="/WEB-INF/paginas/operaciones/listarJugadores.jsp"/>
        
        
        
        <!-- Incluyo la pagina pieDePagina -->
        <jsp:include page="WEB-INF/paginas/comunes/pieDePagina.jsp"/>
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    </body>
</html>

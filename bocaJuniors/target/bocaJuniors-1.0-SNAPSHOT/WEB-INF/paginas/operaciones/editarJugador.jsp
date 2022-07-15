<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libreria</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/382381b436.js" crossorigin="anonymous"></script>
    </head>
    
    <body style=" background-image: linear-gradient(60deg, #64b3f4 0%, #c2e59c 100%);">
        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>
        <form action="${pageContext.request.contextPath}/servletControlador?accion=modificar&idjugadores=${jugador.idjugadores}"
              method="POST" class="was-validated" >
            <jsp:include page="/WEB-INF/paginas/comunes/editarNav.jsp"/>
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div clas="card">
                                <div class="card-header" style="background-color:#041874;color:#E9F616 ">
                                    <h4>Editar Jugador</h4>
                                </div>
                                <div class="card-body" style="background-color: #C8ECF4">
                                    <div class="form-group">
                                        <label for="nombre">Jugador</label>
                                        <input type="text" class="form-control" name="nombre" required="" value="${jugador.nombre}">
                                    </div>
                                    <div class="form-group">
                                        <label for="autor">Puesto</label>
                                        <input type="text" class="form-control" name="puesto" value="${jugador.puesto}">
                                    </div>
                                    <div class="form-group">
                                        <label for="edad">Edad</label>
                                        <input type="number" class="form-control" name="edad" required="" value="${jugador.edad}">
                                    </div>
                                    <div class="form-group">
                                        <label for="pais">País</label>
                                        <input type="text" class="form-control" name="pais" required="" value="${jugador.pais}">
                                    </div>
                                    <div class="form-group">
                                        <label for="cotizacion">Cotización</label>
                                        <input type="currency" class="form-control" name="cotizacion" required="" value="${jugador.cotizacion}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            
        </form>
        <jsp:include page="/WEB-INF/paginas/comunes/pieDePagina.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>

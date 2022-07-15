<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="es_US" />



<section id="jugadores">
    <div class="container fluid">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4> Listado de Jugadores</h4>
                    </div>
                    <table class="table table-primary table-striped">
                        
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Puesto</th>
                                <th>Edad</th>
                                <th>País</th>
                                <th>Cotización</th>
                                
                                <th>Acción</th>
                            </tr>
                            
                        </thead>
                        
                        <tbody>
                            <c:forEach var="jugador" items="${VistaDeJugadores}" varStatus="status">
                                <tr>
                                    <!-- agrego status para que me muestre nro en orden , no el id-->
                                    <td> ${status.count}</td>
                                    <td> ${jugador.nombre}</td>
                                    <td> ${jugador.puesto}</td>
                                    <td> ${jugador.edad}</td>
                                    <td>${jugador.pais}</td>
                                    <td> <fmt:formatNumber value="${jugador.cotizacion}" type="currency"></fmt:formatNumber></td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servletControlador?accion=editar&idjugadores=${jugador.idjugadores}" 
                                         class="btn btn-secondary"></a>
                                        <i class="fa-solid fa-pen"></i>
                                        Editar
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                        
                    </table>
                </div>
            </div>
            <div class="col-md-3">
                    <div class="card text-center bg-warning text-white mb-3"> 
                        <div class="card-body">
                            <h3> Promedio de edad</h3>
                            <h4 class="display-8">
                                <i class="fa-solid fa-person-running"></i>
                                ${promedioEdad}
                            </h4>
                        </div>
                    </div>
                    <div class="card text-center bg-primary text-white mb-3">
                        <div class="card-body">
                            <h3> Cotización total</h3>
                            <h4 class="display-8">
                                <i class="fa-solid fa-dollar-sign"></i>
                                ${cotizacionTotal}
                            </h4>
                        </div>
                    </div>
                            
            </div>                    
        </div>
    </div>
</section>
<!-- Agrego a listar jugadores la pagina agregarJugadores -->

<jsp:include page="/WEB-INF/paginas/operaciones/agregarJugadores.jsp"/>


<div class="modal fade" id="agregarJugadorModal" tabindex="-1"  style="background-color:#041874; ">
    <!-- el id es el mismo del target de la clase navegacion.jsp -->
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header " style="background-color:#067CBB;  " >
                <h5 class="modal-title" > Alta de Jugador</h5>
            </div>
            <form action="${pageContext.request.contextPath}/servletControlador?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group" >
                        <label for="nombre">Jugador </label>
                        <input class="form-control" type="text" name="nombre" required=""> 
                    </div>
                    
                    <div class="form-group">
                        <label for="puesto">Posición </label>
                        <input class="form-control" type="text" name="puesto" required=""> 
                    </div>
                    
                    <div class="form-group">
                        <label for="edad">Edad</label>
                        <input class="form-control" type="number" name="edad" required="">
                    </div>
                    
                    <div class="form-group">
                        <label for="pais">Pais origen</label>
                        <input class="form-control" type="text" name="pais" required=""> 
                    </div>
                    
                    <div class="form-group">
                        <label for="cotizacion">Valor en mercado</label>
                        <input class="form-control" type="currency" name="cotizacion" required=""> 
                    </div>
                    
                </div>
                <div class="modal-footer">
                        <button class="btn " style="background-color:#067CBB; color:#EEF309 " type="submit">
                            Guardar
                        </button>
                        <button type="button" class="btn btn-warning" data-bs-dismiss="modal">
                            Cerrar
                        </button>
                </div>   
            </form>
        </div>
    </div>
</div>
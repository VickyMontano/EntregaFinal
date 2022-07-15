<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <a href="index.jsp" class="btn btn-warning btn-block  ">
                    <i class="fa-solid fa-circle-arrow-left"></i>
                    Volver al Inicio
                </a>
            </div>
            <div class="col-md-4">
                <button type="submit" class="btn btn-success btn-block">
                    <i class="fa-solid fa-circle-check"></i>
                    Guardar Modificación
                </button>
            </div>
            <div class="col-md-4">
                <a href="${pageContext.request.contextPath}/servletControlador?accion=eliminar&idjugadores=${jugador.idjugadores}" class="btn btn-danger btn-block">
                    <i class="fa-solid fa-trash-can"></i>
                    Eliminar Jugador
                </a>
            </div>

        </div>
    </div>
</section>
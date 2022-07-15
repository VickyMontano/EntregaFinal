/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import data.EquipoDAO;
import entity.*;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpSession;



/**
 *
 * @author vicky
 */
@WebServlet("/servletControlador")
public class ServletControlador extends HttpServlet{
    @Override 
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
       /* List <Jugadores> jugadores= new EquipoDAO().findAll();// llamamos al constructor 
        // de libreriaDao
        // muestro por pantalla
        jugadores.forEach(System.out::println);
        // hago referencia a la redireccion
        req.setAttribute("VistaDeJugadores",jugadores);
        // agrego nuevos atributos por las card agregado en listarjugadpres para sacar
        //promedio de edad y el cotizacion total
        req.setAttribute("promedioEdad",calcularProm(jugadores));
        req.setAttribute("cotizacionTotal", calcularCotizacion(jugadores));
        
        req.getRequestDispatcher("jugadores.jsp").forward(req, res);
        modifico el metodo para que funcione con cualquiera que use get
        el Get va hacer las acciones de EDITAR-ELIMINAR y accionDefault*/
       String accion=req.getParameter("accion");
       if(accion!=null){
           switch(accion){
               case "editar":
                   //llamo al metodo para editar
                   editarJugador(req,res);
                   break;
               case "eliminar":
                   eliminarJugador(req,res);
                   break;
               default:
                   accionDefault(req,res);
           }
       }else{
           //si es accion es null
           accionDefault(req,res);
       }
        
    }
    //==========================================================================
    //metodo doPost trato de capturar el parametro de url "accion" que está
    // en listarJugador.jsp en el thead
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        String accion = req.getParameter("accion");
        if(accion!=null){// hago un if para analizar la "accion"
            switch(accion){
                case "insertar":
                    guardarJugador(req,res);
                    break;
                case "modificar":
                    modificarJugador(req,res);// aqui hago el UPDATE de cotizacion
                    break;
                default:
                    accionDefault(req,res);
                    break;
                
            }
        }
    }
    
    //==========================================================================
     private void accionDefault(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
    // hace exactamenete lo de metodo doGet para poder mostrar la pantalla ppal
        List <Jugadores> jugadores= new EquipoDAO().findAll();// llamamos al constructor 
        // de libreriaDao
        
       // hago referencia a la redireccion
       // req.setAttribute("VistaDeJugadores",jugadores);
        // agrego nuevos atributos por las card agregado en listarjugadpres para sacar
        //promedio de edad y el cotizacion total
       // req.setAttribute("promedioEdad",calcularProm(jugadores));
       // req.setAttribute("cotizacionTotal", calcularCotizacion(jugadores));
        // redireccion
       // req.getRequestDispatcher("jugadores.jsp").forward(req, res);
       //=====// creo un objeto llamado sesion para que abra y cierra la misma
        HttpSession sesion=req.getSession();
        sesion.setAttribute("VistaDeJugadores",jugadores);
        sesion.setAttribute("promedioEdad",calcularProm(jugadores));
        sesion.setAttribute("cotizacionTotal", calcularCotizacion(jugadores));
        // hago una sesion mediante una respuesta
        res.sendRedirect("jugadores.jsp");
    
    }
    //==========================================================================
    private void guardarJugador(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        // obtengo todos los paramentros del form
        // vienen de tipo Strin por tanto tengo que "parsear"
        String nombre = req.getParameter("nombre");
        String puesto = req.getParameter("puesto");
        int edad = Integer.parseInt(req.getParameter("edad"));
        String pais=req.getParameter("pais");
        double cotizacion = Double.parseDouble(req.getParameter("cotizacion"));
        
        // creo un objeto jugador de la clase Jugadores
        Jugadores jugador = new Jugadores(nombre,puesto,edad,pais,cotizacion);
        // necesito una variable para almacenar la cantidad de registros insertados cuando se ejecute el metodo create
        int regMod = new EquipoDAO().create(jugador);
        System.out.println("Insertados: " + regMod);
        // termino llamando al metodo accioDefault para ir a pantalla ppal
        accionDefault(req,res);
    }
    
    // metodo para editar datos del jugador
    private void editarJugador(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        // debo recuperar el id de jugador que se envia a traves de una request por medio de una url
        int idjugadores=Integer.parseInt(req.getParameter("idjugadores"));
        Jugadores jug= new EquipoDAO().findPlayerById(idjugadores);
        // lo envio a otra vista
        req.setAttribute("jugador", jug);
        req.getRequestDispatcher("/WEB-INF/paginas/operaciones/editarJugador.jsp").forward(req, res);
        
    }
    //==========================================================================
    // metodo para modificar dtos del jugador
    private void modificarJugador(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String nombre = req.getParameter("nombre");
        String puesto = req.getParameter("puesto");
        int edad = Integer.parseInt(req.getParameter("edad"));
        String pais=req.getParameter("pais");
        double cotizacion = Double.parseDouble(req.getParameter("cotizacion"));
        // mas el Id de jugadores
        int idjugadores=Integer.parseInt(req.getParameter("idjugadores"));
        // creo un objeto jugador de la clase Jugadores
        Jugadores jug = new Jugadores(idjugadores,nombre,puesto,edad,pais,cotizacion);
        int regMod=new EquipoDAO().update(jug);
        System.out.println("Registros modificados: "+regMod);
        // llamo al accionDefault para ir a inicio
        accionDefault(req,res);
    }
    
    // ========================================================================
    // metodo para eliminar
    private void eliminarJugador(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        int idjugadores=Integer.parseInt(req.getParameter("idjugadores"));
        int regDel=new EquipoDAO().delete(idjugadores);
        System.out.println("Registros eliminados: "+regDel);
        // llamo al metodo accioDefault para ir a pantalla ppal
        accionDefault(req,res);
    }
    //=========================================================================
    // metodo privado para sacar el promedio de edad de la plantilla
    private double calcularProm( List<Jugadores> lista){
        // declaro una variable para guardar la cantidad
       double edadTotal=0;
        
        for(int i=0;i<lista.size();i++){
            edadTotal+=lista.get(i).getEdad();
        }
       double promedioEdad=0;
       
        promedioEdad= edadTotal/lista.size();
         
        
        return  Math.round(promedioEdad*100.0)/100.0;
    }
    
    // metdodo para sacar la cotizacion total del plantel
    private String calcularCotizacion(List<Jugadores> lista){
        // declaro una variable para guardar el precio
       double cotizacionTotal=0;
        for(int i=0;i<lista.size();i++){
            cotizacionTotal+=(lista.get(i).getCotizacion());
        }
        return String.format("%.2f",cotizacionTotal);
    }
    
}


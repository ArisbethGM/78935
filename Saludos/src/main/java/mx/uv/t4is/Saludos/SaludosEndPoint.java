package mx.uv.t4is.Saludos;

import java.util.ArrayList;
//import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.BorrarSaludosRequest;
import https.t4is_uv_mx.saludos.BorrarSaludosResponse;
import https.t4is_uv_mx.saludos.BuscarSaludosResponse;
import https.t4is_uv_mx.saludos.ModificarSaludosRequest;
import https.t4is_uv_mx.saludos.ModificarSaludosResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;
import https.t4is_uv_mx.saludos.SaludarResponse;
import https.t4is_uv_mx.saludos.BuscarSaludosResponse.Saludos;

@Endpoint
public class SaludosEndPoint {

    int cont = 1;
    //List<Saludos> lista = new ArrayList<>();        //La clase Saludos es la que creamos con los set y get
    ArrayList<Saludos> lista1 = new ArrayList<>();
    private int i=0;


    @PayloadRoot(localPart = "SaludarRequest", namespace = "https://t4is.uv.mx/saludos" )
    @ResponsePayload 
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion) {

        SaludarResponse respuesta = new SaludarResponse();
        respuesta.setRespuesta("Hola "+ peticion.getNombre());


        //Para el metodo BuscarSaludosResponse
       /* Saludos saludo = new Saludos();
        saludo.setNombre(peticion.getNombre());
        saludo.setId(cont);
        lista.add(saludo);
        cont++;*/


        Saludos e = new Saludos();
        e.setNombre(peticion.getNombre());
        e.setId(i++);
        lista1.add(e);

        return respuesta; 
    } 

    @PayloadRoot(localPart = "BuscarSaludosRequest", namespace = "https://t4is.uv.mx/saludos" )
    @ResponsePayload                 //este objeto "respuesta" lo trasforma a algo entendible 
    public BuscarSaludosResponse buscarSaludos(){

        BuscarSaludosResponse respuesta = new BuscarSaludosResponse();

       /* for(Saludos saludo : lista){
            BuscarSaludosResponse.Saludos buscarSaludos = new BuscarSaludosResponse.Saludos();
            buscarSaludos.setId(saludo.getId());
            buscarSaludos.setNombre(saludo.getNombre());
            repuesta2.getSaludos().add(buscarSaludos);
        }*/


        //recorrer la lista 
        for(Saludos o : lista1){
            //System.out.println(o);
            //Saludos e = new Saludos();
           // e.setNombre(o.getNombre());
           // e.setId(i.getId());
            respuesta.getSaludos().add(o);
        }

       
        return respuesta;
    }
   
    @PayloadRoot(localPart = "ModificarSaludosRequest", namespace = "https://t4is.uv.mx/saludos" )
    @ResponsePayload   
    public ModificarSaludosResponse modificarSaludo(@RequestPayload ModificarSaludosRequest peticion){
        ModificarSaludosResponse respuesta = new ModificarSaludosResponse();
        Saludos e = new Saludos();
        e.setId(peticion.getId());
        e.setNombre(peticion.getNombre());
        lista1.set(peticion.getId()-1, e);
        respuesta.setRespuesta(true);
        return respuesta;
    }


    @PayloadRoot(localPart = "BorrarSaludosRequest", namespace = "https://t4is.uv.mx/saludos" )
    @ResponsePayload  
    public BorrarSaludosResponse borrarSaludo(@RequestPayload BorrarSaludosRequest peticion){
        BorrarSaludosResponse respuesta = new BorrarSaludosResponse();
         //lista1.remove(peticion.getId()-1);

        for( Saludos o  : lista1){
            if(o.getId() == peticion.getId()){
                lista1.remove(o);
                break;
            }
        }
        /*
        Saludos o = new Saludos(); 
        o.setId(peticion.getId());
        o.setNombre(lista1.get(peticion.getId()).getNombre());
        lista1.remove(lista1.indexOf(o));*/
        respuesta.setRespuesta(true);
        return respuesta;
    }
    
}

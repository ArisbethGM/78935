package mx.uv.t4is.SaludosBd;

import org.springframework.beans.factory.annotation.Autowired;
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
//import https.t4is_uv_mx.saludos.BuscarSaludosResponse.Saludos;

@Endpoint
public class SaludosEndPoint {

    @Autowired
    Isaludadores isaludadores;

    @PayloadRoot(localPart = "SaludarRequest", namespace = "https://t4is.uv.mx/saludos" )
    @ResponsePayload 
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion) {

        SaludarResponse respuesta = new SaludarResponse();
        respuesta.setRespuesta("Hola "+ peticion.getNombre());

        Saludadores e = new Saludadores();
        e.setNombre(peticion.getNombre());
        //e.setId(i++);
        //lista1.add(e);
        isaludadores.save(e);
        return respuesta; 
    } 

    @PayloadRoot(localPart = "BuscarSaludosRequest", namespace = "https://t4is.uv.mx/saludos" )
    @ResponsePayload                 //este objeto "respuesta" lo trasforma a algo entendible 
    public BuscarSaludosResponse buscarSaludos(){

        BuscarSaludosResponse respuesta = new BuscarSaludosResponse();

        //recorrer la lista 
        /*for(Saludos o : lista1){
            //System.out.println(o);
            //Saludos e = new Saludos();
           // e.setNombre(o.getNombre());
           // e.setId(i.getId());
            respuesta.getSaludos().add(o);
        }*/
       Iterable<Saludadores> lista =  isaludadores.findAll();
       for(Saludadores o : lista){
            BuscarSaludosResponse.Saludos e = new BuscarSaludosResponse.Saludos();
            e.setNombre(o.getNombre());
            e.setId(o.getId());
            respuesta.getSaludos().add(e);
        } 
        return respuesta;
    }
   
    @PayloadRoot(localPart = "ModificarSaludosRequest", namespace = "https://t4is.uv.mx/saludos" )
    @ResponsePayload   
    public ModificarSaludosResponse modificarSaludo(@RequestPayload ModificarSaludosRequest peticion){
        ModificarSaludosResponse respuesta = new ModificarSaludosResponse();
        Saludadores e = new Saludadores();  
        e.setId(peticion.getId());
        e.setNombre(peticion.getNombre());
        isaludadores.save(e); 
        respuesta.setRespuesta(true);
        return respuesta;
    }


    @PayloadRoot(localPart = "BorrarSaludosRequest", namespace = "https://t4is.uv.mx/saludos" )
    @ResponsePayload  
    public BorrarSaludosResponse borrarSaludo(@RequestPayload BorrarSaludosRequest peticion){
        BorrarSaludosResponse respuesta = new BorrarSaludosResponse();
         //lista1.remove(peticion.getId()-1);

        /*for( Saludos o  : lista1){
            if(o.getId() == peticion.getId()){
                lista1.remove(o);
                break;
            }
        }*/
        isaludadores.deleteById(peticion.getId());
        respuesta.setRespuesta(true);
        return respuesta;
    }
    
}

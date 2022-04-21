package mx.uv.actss.EjercicioSS;


import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import https.actss_uv_mx.lista.MostrarListaResponse.Lista;
import https.actss_uv_mx.lista.ListaRequest;
import https.actss_uv_mx.lista.ListaResponse;
import https.actss_uv_mx.lista.MostrarListaResponse;

@Endpoint
public class ListaEndPoint {

    ArrayList<Lista> lista1 = new ArrayList<>();
    private int i=0;

    @PayloadRoot(localPart = "ListaRequest", namespace = "https://actss.uv.mx/lista" )
    @ResponsePayload 
    public ListaResponse Lista(@RequestPayload ListaRequest peticion) {

        ListaResponse respuesta = new ListaResponse();
        respuesta.setRespuesta("Agregaste a la lista: "+ peticion.getNombre());

        Lista e = new Lista();
        e.setNombre(peticion.getNombre());
        e.setId(i++);
        lista1.add(e);

        return respuesta; 
    }
    
    
    @PayloadRoot(localPart = "MostrarListaRequest", namespace = "https://actss.uv.mx/lista" )
    @ResponsePayload              
    public MostrarListaResponse mostrarLista(){

        MostrarListaResponse respuesta = new MostrarListaResponse();

        for(Lista o : lista1){
            respuesta.getLista().add(o);
        } 
        return respuesta;
    }
    
}

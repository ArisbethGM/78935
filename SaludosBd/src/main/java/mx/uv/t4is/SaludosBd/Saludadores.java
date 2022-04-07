package mx.uv.t4is.SaludosBd;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//DTO
@Entity
public class Saludadores {

    @Id                                        //decimos que esta entidad es la llave primaria 
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nombre;

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }
 
}
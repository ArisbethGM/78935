package mx.uv.t4is.Saludos;

public class Saludos {

    int id;
    String nombre;

    /*public Saludos( int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }*/
    public Saludos(){
       
    }

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

package sv.edu.udb.desafio2;


class Detalle {
    private String nombre;
    private String fecha;
    private String hora;
    private String precio;
    String key;

    public Detalle() {
    }

    public Detalle(String nombre, String fecha, String hora, String precio){
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.precio = precio;
    }

    public String getNombre(){
        return  nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    //
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    //
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    //
    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }

}
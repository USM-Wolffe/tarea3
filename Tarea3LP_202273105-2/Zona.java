public abstract class Zona {
    protected boolean completada;
    /*
    -Nombre: interactuar
    -entrada : Cyan cyan, Magenta magenta, Amarillo amarillo.
    *****
    -Metodo abstracto que define la interaccion entre la zona y los Pikinim (Cyan, Magenta, Amarillo). La implementacion especifica se proporcionara en las subclases de Zona.
    */
    public abstract void interactuar(Cyan cyan, Magenta magenta, Amarillo amarillo);
    /*
    -Nombre: isCompletada
    -salida: boolean.
    *****
    -Devuelve el valor del atributo completada, que indica si la zona ha sido completada o no.
    */
    public boolean isCompletada() {
        return completada;
    }
    /*
    -Nombre: setCompletada
    -entrada : boolean completada.
    *****
    -Establece el valor del atributo completada con el valor proporcionado como parametro.
    */
    public void setCompletada(boolean completada) {
        this.completada = completada;
    }
}
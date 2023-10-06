
public abstract class Pikinim {
    protected int ataque;
    protected int capacidad;
    protected int cantidad;

    public Pikinim() {
    }
    /*
    -Nombre: disminuir
    -entrada : int cantidad.
    *****
    -Disminuye la cantidad actual del Pikinim por el valor entregado como parámetro.
    */
    public void disminuir(int cantidad){
        this.cantidad-= cantidad;
    }
    /*
    -Nombre: multiplicar
    -entrada : int cantidad.
    *****
    -Metodo abstracto para multiplicar la cantidad de Pikinim.
    Las subclases cyan.java, magenta.java, amarillo.java implementan este metodo.
    */
    public abstract void multiplicar(int cantidad);

}

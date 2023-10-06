public class Magenta extends Pikinim {
    //CONSTRUCTOR
    public Magenta(int cantidad) {
        this.ataque = 2;
        this.capacidad = 1;
        this.cantidad = cantidad;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /*
    -Nombre: multiplicar
    -entrada : int cantidad.
    *****
    -Multiplica la cantidad proporcionada por el valor del atributo ataque y suma el resultado al valor actual de cantidad del Pikinim Magenta.
    */
    @Override
    public void multiplicar(int cantidad) {


        this.cantidad += cantidad * ataque;
    }
}

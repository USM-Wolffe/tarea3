public class Amarillo extends Pikinim {
    //CONSTRUCTOR
    public Amarillo(int cantidad) {
        this.ataque = 1;
        this.capacidad = 3;
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
    -Multiplica la cantidad actual del Pikinim Amarillo por 1.5 y suma el resultado al valor actual de cantidad.
    */
    @Override
    public void multiplicar(int cantidad) {
        this.cantidad += Math.ceil(cantidad*1.5);
    }
}

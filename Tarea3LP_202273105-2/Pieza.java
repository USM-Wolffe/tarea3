public class Pieza extends Zona {
    private int peso;
    //CONSTRUCTOR
    public Pieza(int peso) {
        this.peso = peso;
        this.completada = false;
    }
    /*
    -Nombre: interactuar
    -entrada : Cyan cyan, Magenta magenta, Amarillo amarillo.
    *****
    -Calcula la capacidad total de los Pikinim (Cyan, Magenta, Amarillo) y verifica si pueden levantar la pieza basado en su peso. Si la capacidad total es mayor o igual al peso de la pieza, la pieza se marca como completada. De lo contrario, se muestra un mensaje indicando que no tienen la capacidad suficiente.
    */
    @Override
    public void interactuar(Cyan cyan, Magenta magenta, Amarillo amarillo) {
        int capacidadTotal = (cyan.getCantidad() * cyan.getCapacidad()) +
                (magenta.getCantidad() * magenta.getCapacidad()) +
                (amarillo.getCantidad() * amarillo.getCapacidad());

        if (capacidadTotal >= peso) {
            System.out.println("¡Los Pikinim han levantado la pieza con éxito!");
            this.completada = true;
        } else {
            System.out.println("Los Pikinim no tienen la capacidad suficiente para levantar esta pieza. Necesitas más Pikinim o Pikinim más fuertes.");
        }
    }


    // Getters y setters
    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}


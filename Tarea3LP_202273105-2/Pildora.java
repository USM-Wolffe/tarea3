import java.util.Scanner;

public class Pildora extends Zona {
    private int cantidad;
    //CONSTRUCTOR
    public Pildora(int cantidad) {
        this.cantidad = cantidad;
        this.completada = false;
    }
    /*
    -Nombre: interactuar
    -entrada : Cyan cyan, Magenta magenta, Amarillo amarillo
    *****
    -Metodo que define la interaccion en la zona de Pildora. El jugador puede elegir un color de Pikinim para multiplicar su cantidad. Al hacerlo, la zona se marca como completada.
    */
    @Override
    public void interactuar(Cyan cyan, Magenta magenta, Amarillo amarillo) {
        if (!this.completada) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Lomiar llegó a un lugar lleno de unas figuras con forma de píldoras, los Pikinim se llevan las píldoras.");
            System.out.println("¿Qué color de pikinim desea que se multiplique?");
            System.out.println("1. Cyan");
            System.out.println("2. Magenta");
            System.out.println("3. Amarillo");
            int eleccion = scanner.nextInt();

            switch (eleccion) {
                case 1:
                    cyan.multiplicar(cantidad);
                    System.out.println("Los Pikinim cyan han aumentado su cantidad.");
                    break;
                case 2:
                    magenta.multiplicar(cantidad);
                    System.out.println("Los Pikinim magenta han aumentado su cantidad.");
                    break;
                case 3:
                    amarillo.multiplicar(cantidad);
                    System.out.println("Los Pikinim amarillos han aumentado su cantidad.");
                    break;
            }

            this.completada = true;
        } else {
            System.out.println("No queda nada que hacer aquí.");
        }
    }

    // Getters y setters
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}


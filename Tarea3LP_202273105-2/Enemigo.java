import java.util.Random;
import java.util.Scanner;

public class Enemigo extends Zona implements ILevantable {

    private int vida;
    private int ataque;
    private int peso;
//CONSTRUCTOR
    public Enemigo(int vida, int peso, int ataque) {
        this.vida = vida;
        this.ataque = ataque;
        this.peso = peso;
        this.completada = false;
    }
    /*
    -Nombre: interactuar
    -entrada : Cyan cyan, Magenta magenta, Amarillo amarillo.
    *****
    -Si la zona no ha sido completada, presenta al jugador la opción de pelear o huir del enemigo. Si el jugador decide pelear, se llama al metodo pelear. Si el enemigo es derrotado, se llama al metodo levantar. Si el jugador decide huir, simplemente muestra un mensaje.
    */
    @Override
    public void interactuar(Cyan cyan, Magenta magenta, Amarillo amarillo) {
        if (!this.completada) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Lomiar llegó a un lugar donde parece haber un enemigo");
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Pelear");
            System.out.println("2. Huir");
            int eleccion = scanner.nextInt();

            switch (eleccion) {
                case 1:
                    pelear(cyan, magenta, amarillo);
                    if (vida <= 0) {
                        System.out.println("¡Has Vencido al Enemigo!");
                        levantar(cyan, magenta, amarillo);
                        this.completada = true;
                    }else{
                        System.out.println("El Enemigo aún tiene " + vida + " puntos de vida.");
                    }
                    break;
                case 2:
                    System.out.println("Decidiste no pelear.");
                    break;

            }
        }else{
            System.out.println("La zona ya ha sido completada.");
        }
    }

    /*
    -Nombre: pelear
    -entrada : Cyan cyan, Magenta magenta, Amarillo amarillo.
    *****
    -Calcula el daño total que los Pikinim pueden hacer al enemigo y reduce la vida del enemigo. Despues el enemigo ataca a uno de los Pikinim al azar.
    */
    public void pelear(Cyan cyan, Magenta magenta, Amarillo amarillo) {
        int danioTotal = (cyan.getCantidad() * cyan.getAtaque()) +
                (magenta.getCantidad() * magenta.getAtaque()) +
                (amarillo.getCantidad() * amarillo.getAtaque());
        vida -= danioTotal;

        // El enemigo ataca a los Pikinim
        Random rand = new Random();
        int colorAzar = rand.nextInt(3);
        switch (colorAzar) {
            case 0:
                cyan.disminuir(ataque);
                break;
            case 1:
                magenta.disminuir(ataque);
                break;
            case 2:
                amarillo.disminuir(ataque);
                break;
        }
    }
    /*
    -Nombre: levantar
    -entrada : Cyan cyan, Magenta magenta, Amarillo amarillo
    *****
    -Evalua si la capacidad total de los Pikinim (Cyan, Magenta y Amarillo) es suficiente para levantar al enemigo segun su peso. Si es asi, permite al jugador elegir un color de Pikinim para multiplicar con el peso del enemigo.
    */
    public void levantar(Cyan cyan, Magenta magenta, Amarillo amarillo) {
        int capacidadTotal = (cyan.getCantidad() * cyan.getCapacidad()) +
                (magenta.getCantidad() * magenta.getCapacidad()) +
                (amarillo.getCantidad() * amarillo.getCapacidad());

        if (capacidadTotal >= peso) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Has derrotado al enemigo y tienes la capacidad para levantarlo.");
            System.out.println("¿Qué color de Pikinim deseas multiplicar con el peso del enemigo?");
            System.out.println("1. Cyan");
            System.out.println("2. Magenta");
            System.out.println("3. Amarillo");
            int eleccion = scanner.nextInt();

            switch (eleccion) {
                case 1:
                    cyan.multiplicar(peso);
                    System.out.println("Has multiplicado a los Pikinim Cyan con el peso del enemigo.");
                    break;
                case 2:
                    magenta.multiplicar(peso);
                    System.out.println("Has multiplicado a los Pikinim Magenta con el peso del enemigo.");
                    break;
                case 3:
                    amarillo.multiplicar(peso);
                    System.out.println("Has multiplicado a los Pikinim Amarillo con el peso del enemigo.");
                    break;
                default:
                    System.out.println("Elección no válida.");
                    break;
            }
        }
    }


    // Getters y setters
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}

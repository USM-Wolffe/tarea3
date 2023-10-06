import java.util.Scanner;
public class Muralla extends Zona {

    private int vida;
    //CONSTRUCTOR
    public Muralla(int vida) {
        this.vida = vida;
        this.completada = false;
    }
    /*
    -Nombre: interactuar
    -entrada : Cyan cyan, Magenta magenta, Amarillo amarillo.
    *****
    -Si la muralla no ha sido destruida, presenta al jugador la opción de intentar romperla o retroceder. Si escoge intentar romperla, se llama al metodo tryRomper. Si la muralla es destruida, se marca la zona como completada.
    */
    @Override
    public void interactuar(Cyan cyan, Magenta magenta, Amarillo amarillo) {
        if (!this.completada) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Lomiar llegó a una muralla que bloquea el camino.");
            System.out.println("¿Qué deseas hacer?");
            System.out.println("1. Intentar romper la muralla");
            System.out.println("2. Retroceder");
            int eleccion = scanner.nextInt();

            switch (eleccion) {
                case 1:
                    tryRomper(cyan, magenta, amarillo);
                    if (vida <= 0) {
                        System.out.println("¡Has roto la muralla!");
                        this.completada = true;
                    } else {
                        System.out.println("La muralla aún tiene " + vida + " puntos de vida.");
                    }
                    break;
                case 2:
                    System.out.println("Decidiste no intentar romper la muralla.");
                    break;

            }
        } else {
            System.out.println("La muralla ya ha sido destruida.");
        }
    }
    /*
    -Nombre: tryRomper
    -entrada : Cyan cyan, Magenta magenta, Amarillo amarillo.
    *****
    -Calcula el daño total que los Pikinim pueden hacer a la muralla y reduce la vida de la muralla segun ese daño.
    */
    public void tryRomper(Cyan cyan, Magenta magenta, Amarillo amarillo) {
        int danioTotal = (cyan.getCantidad() * cyan.getAtaque()) +
                (magenta.getCantidad() * magenta.getAtaque()) +
                (amarillo.getCantidad() * amarillo.getAtaque());
        vida -= danioTotal;
    }

    // Getters y setters
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}

import java.util.Scanner;

public class Juego {
    private Zona[] mapa;
    private int posicionJugador;
    private Cyan pCyan;
    private Magenta pMagenta;
    private Amarillo pAmarillo;
    private  int n_piezas;
    private int turnosRestantes = 30;


    /*
    -Nombre: Juego
    -entrada : Ninguna.
    *****
    -Constructor de la clase Juego. Inicializa los Pikinim, el mapa, las piezas y la posición del jugador.
    */
    public Juego() {

        pCyan = new Cyan(10);
        pMagenta = new Magenta(10);
        pAmarillo = new Amarillo(10);

        mapa = new Zona[11];
        mapa[0] = new Pieza(50);
        mapa[1] = new Enemigo(130, 20, 25);
        mapa[2] = new Enemigo(50, 10, 15);
        mapa[3] = new Pildora(25);
        mapa[4] = new Muralla(50);
        mapa[5] = new Pieza(100);
        mapa[6] = new Enemigo(45, 8, 10);
        mapa[7] = new Pieza(35);
        mapa[8] = new Pildora(15);
        mapa[9] = new Enemigo(75, 15, 20);
        mapa[10] = new Muralla(150);
        n_piezas = 0;
        posicionJugador = 5;
    }

    /*
    -Nombre: jugar
    -entrada : Ninguna.
    *****
    -Comienza el juego. Muestra la interfaz y permite al jugador tomar decisiones hasta que se agoten los turnos o se recojan todas las piezas.
    */
    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        while (turnosRestantes > 0) {
            mostrarInterfaz();
            int eleccion = scanner.nextInt();
            switch (eleccion) {
                case 1:
                    mover(1);
                    break;
                case 2:
                    mover(-1);
                    break;
                case 3:
                    interactuarConZona();
                    if(mapa[posicionJugador] instanceof Pieza && ((Pieza)mapa[posicionJugador]).isCompletada()){
                        n_piezas+=1;
                    }
                    break;
                default:
                    System.out.println("Elección no válida.");
                    continue;
            }

            turnosRestantes--;

            if(n_piezas==3){
                System.out.println("¡Felicidades! has recolectado todas las piezas. ¡Ganaste!");
                return; // Termina el juego
            }
        }

        if (turnosRestantes==0) {
            System.out.println("Se ha agotado el oxigeno. Moriste :(.");
        }
    }

    /*
    -Nombre: mostrarInterfaz
    -entrada : Ninguna.
    *****
    -Muestra la interfaz del juego, incluyendo el estado actual, las opciones disponibles y los detalles de la zona.
    */
    private void mostrarInterfaz() {

        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("Turno " + (30 - turnosRestantes) + " (Cyan – " + pCyan.getCantidad() + ", Amarillo – " + pAmarillo.getCantidad() + ", Magenta – " + pMagenta.getCantidad() + ")");
        System.out.print("Zona Actual: " + mapa[posicionJugador].getClass().getSimpleName());

        // Mostrar detalles de la zona
        if (mapa[posicionJugador] instanceof Pieza) {
            System.out.print(" (peso - " + ((Pieza) mapa[posicionJugador]).getPeso() + ")");
        } else if (mapa[posicionJugador] instanceof Muralla) {
            if(((Muralla) mapa[posicionJugador]).getVida()<0){
                System.out.print("  *Destruida*");
            }else{
                System.out.print(" (vida - " + ((Muralla) mapa[posicionJugador]).getVida() + ")");
            }

        } else if (mapa[posicionJugador] instanceof Enemigo) {
            Enemigo enemigo = (Enemigo) mapa[posicionJugador];
            if(enemigo.getVida()<0){
                System.out.print("  *Muerto*");
            }else{
                System.out.print(" (vida - " + enemigo.getVida() + ", ataque - " + enemigo.getAtaque() + ", peso - " + enemigo.getPeso() + ")");
            }

        }
        System.out.println();

        System.out.print("Opciones:\n");
        System.out.print("1. Ir a la derecha (" + (posicionJugador < 10 ? mapa[posicionJugador + 1].getClass().getSimpleName() : "Límite del mapa") + ") ");
        System.out.print("2. Ir a la izquierda (" + (posicionJugador > 0 ? mapa[posicionJugador - 1].getClass().getSimpleName() : "Límite del mapa") + ") ");
        System.out.println("3. Quedarse aquí");
        System.out.println("-----------------------------------------------------------------------------");
    }

    /*
    -Nombre: mover
    -entrada : int direccion.
    *****
    -Mueve al jugador en la dirección especificada, a menos que haya una muralla bloqueando el camino.
    */
    private void mover(int direccion) {
        // Si el jugador intenta moverse a la derecha y hay una muralla con vida > 0, bloquea el movimiento
        if (direccion == 1 && posicionJugador < 10 && mapa[posicionJugador] instanceof Muralla && ((Muralla) mapa[posicionJugador]).getVida() > 0) {
            System.out.println("Hay una muralla bloqueando el camino. No puedes avanzar.");
            return; // No actualizamos la posición del jugador
        }

        // Si el jugador intenta moverse a la izquierda y hay una muralla con vida > 0, bloquea el movimiento
        if (direccion == -1 && posicionJugador > 0 && mapa[posicionJugador] instanceof Muralla && ((Muralla) mapa[posicionJugador]).getVida() > 0) {
            System.out.println("Hay una muralla bloqueando el camino. No puedes avanzar.");
            return; // No actualizamos la posición del jugador
        }

        posicionJugador += direccion;
        if (posicionJugador < 0) {
            posicionJugador = 0;
        } else if (posicionJugador > 10) {
            posicionJugador = 10;
        }
    }


    /*
    -Nombre: interactuarConZona
    -entrada : Ninguna.
    *****
    -Permite al jugador interactuar con la zona actual, ya sea recolectando piezas, enfrentando enemigos o interactuando con otros objetos.
    */

    private void interactuarConZona() {
        mapa[posicionJugador].interactuar(pCyan, pMagenta, pAmarillo);
    }
    /*
    -Nombre: main
    -entrada : String[] args.
    *****
    -Punto de entrada del programa. Crea una instancia del juego y comienza a jugar.
    */
    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.jugar();
    }
}




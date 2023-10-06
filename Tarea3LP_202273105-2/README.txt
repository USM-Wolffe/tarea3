Nombre: [Sebastian Ignacio Reyes Alarcon]

Rol: 202273105-2

Tarea 3 - Lenguajes de Programación

Instrucciones de compilación y utilización:

1.Tener instalado Java JDK 11 en su sistema.
2.Navegue hasta el directorio donde se encuentran los archivos .java y el makefile.
3.Abra una terminal en este directorio.
4.Ejecute el comando make para compilar todos los archivos .java.
5.Una vez compilados, puede ejecutar el programa principal con el comando java Juego.
6.Para limpiar los archivos compilados, usar el comando make clean.

 Archivos:

Pikinim.java: Clase que representa a los Pikinim.
Cyan.java: Clase que representa al Pikinim de color Cyan.
Magenta.java: Clase que representa al Pikinim de color Magenta.
Amarillo.java: Clase que representa al Pikinim de color Amarillo.
Zona.java: Clase abstracta que representa las zonas del juego.
Pieza.java: Clase que representa las piezas de la nave.
Enemigo.java: Clase que representa a los enemigos en el juego.
Pildora.java: Clase que representa las píldoras que multiplican a los Pikinim.
Muralla.java: Clase que representa las murallas en el juego.
Juego.java: Clase principal del juego.
ILevantable.java: Interfaz que define el comportamiento levantable.

Notas adicionales:

El programa funciona perfectamente. Crea el mapa y lo recorre con la siguiente dinamica: llega a una zona y le muestra las caracteristicas de esta, usted decide si interactuar o moverse a la siguiente zona (a menos que estemos parados en una muralla, en ese caso no se puede avanzar). Al interactuar con la respectiva zona se muestra en pantalla la interfaz individual de cada una (Si estamos en una muralla, la interfaz para romperla. Si estamos en un enemigo, la interfaz para pelear con el, etc..). El programa ACTUALIZA en tiempo real que ocurre en el juego, tanto para mostrar las caracteristicas en pantalla (o un mensaje que indique el estado de la zona), si una zona esta completada o simplemente las piezas recolectadas.
Si el programa detecta que se han recogido todas las piezas se termina mostrando un mensaje de exito. Si se han superado los 30 turnos, termina con un mensaje de derrota.
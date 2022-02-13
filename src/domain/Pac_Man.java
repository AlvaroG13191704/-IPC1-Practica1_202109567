package domain;

import java.util.Random;
import java.util.Scanner;

public class Pac_Man {

    public static void main(String[] args) {
        //Imports/ variables globales
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] listaJugador = new String[20];
        int[] listaPuntos = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        int opcion = 0;
        String nombre = "";
        int puntos = 0;
        int contadorLista = 0;

        //Creacion del menu
        while (opcion != 3) {
            System.out.println("PAC-MAN    IPC 1   2022");
            System.out.println("========================");
            System.out.println("1. INICIAR JUEGO");
            System.out.println("2. TABLA DE POSICIONES");
            System.out.println("3. SALIR");
            System.out.println("========================");
            System.out.print("Escoga una opción:  ");
            opcion = scanner.nextInt();

            switch (opcion) {
                //INICIO CASE 1
                case 1 -> {
                    nombre = "";
                    puntos = 0;
                    int filas, cols;
                    int comida, pared, trampa;
                    int opcionIcono;
                    String icono = "";
                    int contadorComida1 = 0;
                    int contadorComida2 = 0;
                    int contadorPared = 0;
                    int contadorTrampa = 0;
                    int x;
                    int y;
                    String movimiento = "";
                    int vidas = 3;
                    int opcionPausa;
                    contadorLista++;

                    System.out.println("=======================================");
                    System.out.println("Bienvenido..............");
                    System.out.print("Ingrese su nombre: ");
                    scanner.nextLine();
                    nombre = scanner.nextLine();

                    //Iconoos
                    System.out.println(" A " + " B " + " C " + " D " + " E " + " F " + " G " + " H " + " I " + " M ");
                    System.out.print("Ingrese el numero del icono que desea usar (1-10):");
                    opcionIcono = Integer.parseInt(scanner.next());
                    //Validacion de icono
                    while (opcionIcono < 1 || opcionIcono > 10) {
                        System.out.print("Ingrese de nuevo el valor de su icono:");
                        opcionIcono = Integer.parseInt(scanner.next());
                    }
                    //Seleccion y asignación de icono.
                    switch (opcionIcono) {
                        case 1:
                            icono = "A";
                            System.out.println("El icono seleccionado es: " + icono);
                            break;
                        case 2:
                            icono = "B";
                            System.out.println("El icono seleccionado es: " + icono);
                            break;
                        case 3:
                            icono = "C";
                            System.out.println("El icono seleccionado es: " + icono);
                            break;
                        case 4:
                            icono = "D";
                            System.out.println("El icono seleccionado es: " + icono);
                            break;
                        case 5:
                            icono = "E";
                            System.out.println("El icono seleccionado es: " + icono);
                            break;
                        case 6:
                            icono = "F";
                            System.out.println("El icono seleccionado es: " + icono);
                            break;
                        case 7:
                            icono = "G";
                            System.out.println("El icono seleccionado es: " + icono);
                            break;
                        case 8:
                            icono = "H";
                            System.out.println("El icono seleccionado es: " + icono);
                            break;
                        case 9:
                            icono = "I";
                            System.out.println("El icono seleccionado es: " + icono);
                            break;
                        case 10:
                            icono = "M";
                            System.out.println("El icono seleccionado es: " + icono);
                            break;
                    }
                    //Asignacion de dimensiones del tablero
                    System.out.println("========================================");
                    System.out.print("Ingrese las dimensiones de su tablero (x,y): ");
                    String dimensionesIngresadas = scanner.next();
                    String[] datos = dimensionesIngresadas.split(",");
                    //Validar tablero
                    filas = Integer.parseInt(datos[0]);
                    while (filas < 0) {
                        System.out.println("Valor incorrecto");
                        System.out.print("Ingrese el valor de filas nuevamente:");
                        filas = Integer.parseInt(scanner.next());
                    }
                    cols = Integer.parseInt(datos[1]);
                    while (cols < 0) {
                        System.out.println("Valor incorrecto");
                        System.out.print("Ingrese el valor de columnas nuevamente:");
                        cols = Integer.parseInt(scanner.next());
                    }

                    //Validar cantidad de comida
                    System.out.print("Ingrese la cantidad de comida [1-" + cantidadComida(filas, cols) + "]: ");
                    comida = Integer.parseInt(scanner.next());
                    while (comida < 1 || comida > cantidadComida(filas, cols)) {
                        System.out.println("Valor incorrecto");
                        System.out.print("Ingrese la cantidad de comida nuevamente: ");
                        comida = Integer.parseInt(scanner.next());
                    }

                    //Validar cantidad de paredes
                    System.out.print("Ingrese la cantidad de paredes [1-" + cantidadParedes(filas, cols) + "]: ");
                    pared = Integer.parseInt(scanner.next());
                    while (pared < 1 || pared > cantidadParedes(filas, cols)) {
                        System.out.println("Valor incorrecto");
                        System.out.print("Ingrese la cantidad de paredes nuevamente: ");
                        pared = Integer.parseInt(scanner.next());
                    }

                    //Validad cantidad de trampas
                    System.out.print("Ingrese la cantidad de trampas [1-" + cantidadTrampas(filas, cols) + "]: ");
                    trampa = Integer.parseInt(scanner.next());
                    while (trampa < 1 || trampa > cantidadTrampas(filas, cols)) {
                        System.out.println("Valor incorrecto");
                        System.out.print("Ingrese la cantidad de trampas nuevamente: ");
                        trampa = Integer.parseInt(scanner.next());
                    }
                    System.out.println("========================================");
                    System.out.println("========================================");
                    System.out.println("JUGADOR: " + nombre);
                    System.out.println("========================================");

                    //Creación del tablero
                    int bordeFilas = filas + 2;
                    int bordeCols = cols + 2;
                    String[][] tablero = new String[bordeFilas][bordeCols];
                    for (int i = 0; i < bordeFilas; i++) { //Crea dos filas al inicio y final para generar los bordes
                        for (int j = 0; j < bordeCols; j++) { //Crea dos columnas del inicio y final para generar los bordes
                            if (i == 0 || i == filas + 1) {
                                tablero[i][j] = "=";
                            } else if (j == 0 || j == cols + 1) {
                                tablero[i][j] = "|";
                            } else {
                                tablero[i][j] = " ";
                            }
                        }
                    }

                    int comida1 = random.nextInt(comida) + 1;
                    int comida2 = comida - comida1;

                    //Ingresar random
                    for (int i = 0; i < filas; i++) {
                        for (int j = 0; j < cols; j++) {

                            //Agregando las dos comidas aleatorias    
                            //Comida 1
                            while (contadorComida1 < comida1) {
                                int xRandomC1 = random.nextInt(filas);
                                int yRandomC1 = random.nextInt(cols);
                                if (tablero[xRandomC1][yRandomC1] != " ") {
                                    //Validación de que no se ocupen espacios
                                    //Retorna un verdadero y si no aumenta el contador de comidas
                                } else {
                                    tablero[xRandomC1][yRandomC1] = "@";
                                    contadorComida1++;
                                }
                            }
                            //Comida 2
                            while (contadorComida2 < comida2) {
                                int xRandomC2 = random.nextInt(filas);
                                int yRandomC2 = random.nextInt(cols);
                                if (tablero[xRandomC2][yRandomC2] != " ") {
                                    //Validación de que no se ocupen espacios
                                    //Retorna un verdadero y no aumenta el contador de comida
                                } else {
                                    tablero[xRandomC2][yRandomC2] = "?";
                                    contadorComida2++;
                                }
                            }
                            //Agregando las paredes aleatoriamente
                            while (contadorPared < pared) {
                                int xRandom2 = random.nextInt(filas);
                                int yRandom2 = random.nextInt(cols);
                                if (tablero[xRandom2][yRandom2] != " ") {
                                    //Validación de que no se ocupen espacios
                                    //Retorna un verdadero y no aumenta el contador de paredes
                                } else {
                                    tablero[xRandom2][yRandom2] = "#";
                                    contadorPared++;
                                }
                            }
                            //Agregando las trampas aleatoriamente
                            while (contadorTrampa < trampa) {
                                int xRandom3 = random.nextInt(filas);
                                int yRandom3 = random.nextInt(cols);
                                if (tablero[xRandom3][yRandom3] != " ") {
                                    //Validación de que no se ocupen espacios
                                    //Retorna un verdadero y no aumenta el contador de trampas
                                } else {
                                    tablero[xRandom3][yRandom3] = "X";
                                    contadorTrampa++;
                                }
                            }

                        }
                    }
                    //Imprimir tablero
                    imprimirTablero(tablero, bordeFilas, bordeCols);
                    System.out.println("========================================");

                    do {
                        //Pedir lugares para aparecer
                        System.out.print("Ingrese la posición donde quiere iniciar  (x,y): ");
                        String posicionIngresada = scanner.next();
                        String[] datosPosicion = posicionIngresada.split(",");
                        x = Integer.parseInt(datosPosicion[0]);
                        y = Integer.parseInt(datosPosicion[1]);

                        while (x < 0 || x > filas) {
                            System.out.println("Valor incorrecto");
                            System.out.print("Ingrese la posición de fila nuevamente: ");
                            x = Integer.parseInt(scanner.next());
                        }
                        while (y < 0 || y > cols) {
                            System.out.println("Valor incorrecto o casilla ocupada");
                            System.out.print("Ingrese la cantidad de columnas nuevamente: ");
                            y = Integer.parseInt(scanner.next());
                        }

                        //Insertar icono
                        if (tablero[x][y] != " ") {
                            System.out.println("CASILLA OCUPADA");
                            imprimirTablero(tablero, bordeFilas, bordeCols);
                            System.out.println("========================================");
                        } else {
                            for (int i = 0; i < filas; i++) {
                                for (int j = 0; j < cols; j++) {
                                    tablero[x][y] = icono;
                                }
                            }
                            imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                        }
                    } while (tablero[x][y] != icono);
                    System.out.println("""
                                       INICIO DEL JUEGO
                                       CARACTERISTICAS
                                       ...........................
                                       Comida 1: @ 5 pts
                                       Comida 2: ? 10 pts
                                       Paredes: #
                                       Trampas restan una vida: X
                                       ...........................
                                       INSTRUCCIONES DE MOVIMIENTO
                                       Movimiento a la izquierda (a)
                                       Movimiento a la derecha (d)
                                       Movimiento hacia arriba (w)
                                       Movimiento hacia abajo (s)
                                       Finalizar juego (e)
                                       Pausar juego (m)
                                       ...........................
                                       """);
                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);

                    //INICIAR MOVIMIENTO
                    int puntosTotales = (comida1 * 5) + (comida2 * 10);
                    boolean trampaExis = false;

                    do {
                        System.out.print("Ingrese la tecla para elegir una opción o moverse: ");
                        movimiento = scanner.next();

                        switch (movimiento) {
                            case "D":
                            case "d":
                                //Moverse a la derecha
                                if (tablero[x][y + 1] == " ") {

                                    tablero[x][y + 1] = icono;

                                    verificarTrampa(trampaExis, tablero, x, y);

                                    trampaExis = false;
                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    y += 1;
                                } //Evaluar casilla de pared
                                else if (tablero[x][y + 1] == "#") {

                                    tablero[x][y + 1] = "#";

                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    System.out.println("Casilla ocupada, hay una pared");
                                    y = y;

                                } //Evaluar casilla de comida 1
                                else if (tablero[x][y + 1] == "@") {

                                    tablero[x][y + 1] = icono;

                                    verificarTrampa(trampaExis, tablero, x, y);

                                    trampaExis = false;
                                    puntos += 5;
                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    y += 1;
                                } //Evaluar casilla de comida 2
                                else if (tablero[x][y + 1] == "?") {

                                    tablero[x][y + 1] = icono;
                                    tablero[x][y] = " ";
                                    verificarTrampa(trampaExis, tablero, x, y);

                                    trampaExis = false;
                                    puntos += 10;
                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    y += 1;

                                } //Evaluar trampas 
                                else if (tablero[x][y + 1] == "X") {

                                    //Esto evalua que si despues de la trampa hay cosas
                                    tablero[x][y + 1] = icono;

                                    verificarTrampa(trampaExis, tablero, x, y);

                                    trampaExis = true;

                                    vidas = vidas - 1;
                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    y += 1;

                                } //Moverse entre bordes
                                else if (tablero[x][y + 1] == "|") {

                                    //Esto evalua que si despues de atravesar un borde hay cosas
                                    if (tablero[x][y - (y - 1)] == " ") {
                                        tablero[x][y - (y - 1)] = icono;
                                        verificarTrampa(trampaExis, tablero, x, y);
                                        trampaExis = false;
                                    } else if (tablero[x][y - (y - 1)] == "@") {
                                        tablero[x][y - (y - 1)] = icono;

                                        verificarTrampa(trampaExis, tablero, x, y);
                                        trampaExis = false;
                                        puntos += 5;
                                    } else if (tablero[x][y - (y - 1)] == "?") {
                                        tablero[x][y - (y - 1)] = icono;

                                        verificarTrampa(trampaExis, tablero, x, y);
                                        trampaExis = false;
                                        puntos += 10;
                                    } else if (tablero[x][y - (y - 1)] == "X") {
                                        tablero[x][y - (y - 1)] = icono;

                                        verificarTrampa(trampaExis, tablero, x, y);
                                        trampaExis = true;
                                        vidas -= 1;
                                    } else if (tablero[x][y - (y - 1)] == "#") {
                                        tablero[x][y] = icono;
                                    }

                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);

                                    if (tablero[x][y - (y - 1)] == "#") {
                                        y = y;
                                    } else {
                                        y -= (y - 1);
                                    }
                                }

                                //FIN DE MOVIMIENTO A LA DERECHA
                                break;
                            case "A":
                            case "a":
                                //INICIO DE MOVIMIENTO A LA IZQUIERDA
                                //Moverse a la izquierda
                                if (tablero[x][y - 1] == " ") {

                                    tablero[x][y - 1] = icono;

                                    verificarTrampa(trampaExis, tablero, x, y);

                                    trampaExis = false;
                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    y -= 1;
                                } //Evaluar casilla de pared
                                else if (tablero[x][y - 1] == "#") {

                                    tablero[x][y - 1] = "#";

                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    System.out.println("Casilla ocupada, hay una pared");
                                    y = y;

                                } //Evaluar casilla de comida 1
                                else if (tablero[x][y - 1] == "@") {

                                    tablero[x][y - 1] = icono;

                                    verificarTrampa(trampaExis, tablero, x, y);

                                    trampaExis = false;
                                    puntos += 5;
                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    y -= 1;
                                } //Evaluar casilla de comida 2
                                else if (tablero[x][y - 1] == "?") {

                                    tablero[x][y - 1] = icono;

                                    verificarTrampa(trampaExis, tablero, x, y);

                                    trampaExis = false;
                                    puntos += 10;
                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    y -= 1;

                                } //Evaluar trampas 
                                else if (tablero[x][y - 1] == "X") {

                                    //Esto evalua que si despues de la trampa hay cosas
                                    tablero[x][y - 1] = icono;
                                    verificarTrampa(trampaExis, tablero, x, y);

                                    trampaExis = true;
                                    vidas = vidas - 1;
                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    y -= 1;

                                } //Moverse entre bordes
                                else if (tablero[x][y - 1] == "|") {

                                    //Esto evalua que si despues de atravesar un borde hay cosas
                                    if (tablero[x][cols] == " ") {
                                        tablero[x][cols] = icono;

                                        verificarTrampa(trampaExis, tablero, x, y);
                                        trampaExis = false;
                                    } else if (tablero[x][cols] == "@") {
                                        tablero[x][cols] = icono;

                                        verificarTrampa(trampaExis, tablero, x, y);
                                        trampaExis = false;
                                        puntos += 5;
                                    } else if (tablero[x][cols] == "?") {
                                        tablero[x][cols] = icono;

                                        verificarTrampa(trampaExis, tablero, x, y);
                                        trampaExis = false;
                                        puntos += 10;
                                    } else if (tablero[x][cols] == "X") {
                                        tablero[x][cols] = icono;

                                        vidas -= 1;
                                        verificarTrampa(trampaExis, tablero, x, y);
                                        trampaExis = true;
                                    } else if (tablero[x][cols] == "#") {
                                        tablero[x][y] = icono;

                                    }
                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    if (tablero[x][y] == "#") {
                                        y = y;
                                    } else {
                                        y = cols;
                                    }
                                }

                                //MOVIMIENTO A IZQUIERDA
                                break;
                            case "S":
                            case "s":
                                //INICIO DEL MOVIMIENTO HACIA ABAJO
                                //Moverse hacia abajo
                                if (tablero[x + 1][y] == " ") {

                                    tablero[x + 1][y] = icono;

                                    verificarTrampa(trampaExis, tablero, x, y);

                                    trampaExis = false;
                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    x += 1;
                                } //Evaluar casilla de pared
                                else if (tablero[x + 1][y] == "#") {

                                    tablero[x + 1][y] = "#";

                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    System.out.println("Casilla ocupada, hay una pared");
                                    x = x;
                                } //Evaluar casilla de comida 1
                                else if (tablero[x + 1][y] == "@") {

                                    tablero[x + 1][y] = icono;

                                    verificarTrampa(trampaExis, tablero, x, y);

                                    trampaExis = false;
                                    puntos += 5;
                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    x += 1;

                                } //Evaluar casilla de comida 2
                                else if (tablero[x + 1][y] == "?") {

                                    tablero[x + 1][y] = icono;

                                    verificarTrampa(trampaExis, tablero, x, y);

                                    trampaExis = false;
                                    puntos += 10;
                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    x += 1;

                                } //Evaluar trampas 
                                else if (tablero[x + 1][y] == "X") {

                                    //Esto evalua que si despues de la trampa hay cosas
                                    tablero[x + 1][y] = icono;
                                    verificarTrampa(trampaExis, tablero, x, y);

                                    trampaExis = true;
                                    vidas = vidas - 1;
                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    x += 1;

                                } //Moverse entre bordes
                                else if (tablero[x + 1][y] == "=") {

                                    //Esto evalua que si despues de atravesar un borde hay cosas
                                    if (tablero[x - (x - 1)][y] == " ") {
                                        tablero[x - (x - 1)][y] = icono;

                                        verificarTrampa(trampaExis, tablero, x, y);
                                        trampaExis = false;
                                    } else if (tablero[x - (x - 1)][y] == "@") {
                                        tablero[x - (x - 1)][y] = icono;

                                        verificarTrampa(trampaExis, tablero, x, y);
                                        trampaExis = false;
                                        puntos += 5;
                                    } else if (tablero[x - (x - 1)][y] == "?") {
                                        tablero[x - (x - 1)][y] = icono;

                                        verificarTrampa(trampaExis, tablero, x, y);
                                        trampaExis = false;
                                        puntos += 10;
                                    } else if (tablero[x - (x - 1)][y] == "X") {
                                        tablero[x - (x - 1)][y] = icono;

                                        verificarTrampa(trampaExis, tablero, x, y);
                                        trampaExis = true;
                                        vidas = vidas - 1;
                                    } else if (tablero[x - (x - 1)][y] == "#") {
                                        tablero[x][y] = icono;

                                    }
                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    if (tablero[x - (filas - 1)][y] == "#") {
                                        x = x;
                                    } else {
                                        x = x - (filas - 1);
                                    }
                                }

                                //FIN DEL MOVIMIENTO HACIA ABAJO
                                break;
                            case "W":
                            case "w":
                                //INICIO MOVIMIENTO HACIA ARRIBA
                                //Moverse hacia arriba
                                if (tablero[x - 1][y] == " ") {

                                    tablero[x - 1][y] = icono;

                                    verificarTrampa(trampaExis, tablero, x, y);

                                    trampaExis = false;
                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    x -= 1;
                                } //Evaluar casilla de pared
                                else if (tablero[x - 1][y] == "#") {

                                    tablero[x - 1][y] = "#";

                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    System.out.println("Casilla ocupada, hay una pared");
                                    x = x;
                                } //Evaluar casilla de comida 1
                                else if (tablero[x - 1][y] == "@") {

                                    tablero[x - 1][y] = icono;

                                    verificarTrampa(trampaExis, tablero, x, y);

                                    trampaExis = false;
                                    puntos += 5;
                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    x -= 1;
                                } //Evaluar casilla de comida 2
                                else if (tablero[x - 1][y] == "?") {

                                    tablero[x - 1][y] = icono;

                                    verificarTrampa(trampaExis, tablero, x, y);

                                    trampaExis = false;
                                    puntos += 10;
                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    x -= 1;
                                } //Evaluar trampas 
                                else if (tablero[x - 1][y] == "X") {

                                    //Esto evalua que si despues de la trampa hay cosas
                                    tablero[x - 1][y] = icono;
                                    verificarTrampa(trampaExis, tablero, x, y);

                                    trampaExis = true;
                                    vidas = vidas - 1;
                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    x -= 1;
                                } //Moverse entre bordes
                                else if (tablero[x - 1][y] == "=") {

                                    //Esto evalua que si despues de atravesar un borde hay cosas
                                    if (tablero[filas][y] == " ") {
                                        tablero[filas][y] = icono;

                                        verificarTrampa(trampaExis, tablero, x, y);
                                        trampaExis = false;
                                    } else if (tablero[filas][y] == "@") {
                                        tablero[filas][y] = icono;

                                        verificarTrampa(trampaExis, tablero, x, y);
                                        trampaExis = false;
                                        puntos += 5;
                                    } else if (tablero[filas][y] == "?") {
                                        tablero[filas][y] = icono;

                                        verificarTrampa(trampaExis, tablero, x, y);
                                        trampaExis = false;
                                        puntos += 10;
                                    } else if (tablero[filas][y] == "X") {
                                        tablero[filas][y] = icono;

                                        verificarTrampa(trampaExis, tablero, x, y);
                                        trampaExis = true;
                                        vidas = vidas - 1;
                                    } else if (tablero[cols - 1][y] == "#") {
                                        tablero[x + 1][y] = "#";

                                    }
                                    imprimirJuego(tablero, nombre, puntos, vidas, bordeFilas, bordeCols);
                                    if (tablero[filas][y] == "#") {
                                        x = x;
                                    } else {
                                        x = filas;
                                    }
                                }

                                //FIN DEL MOVIMIENTO HACIA ARRIBA
                                break;
                            case "M":
                            case "m":
                                //Menu de pausa 
                                do {
                                    System.out.println("=====================");
                                    System.out.println("PARTIDA EN PAUSA");
                                    System.out.println("=====================");
                                    System.out.println("""
                                                       1. CONTINUAR PARTIDA
                                                       2. TABLA DE POSICIONES
                                                       3. SALIR DE LA PARTIDA
                                                       """);
                                    System.out.println("=====================");
                                    System.out.print("Escoga una opción: ");
                                    opcionPausa = Integer.parseInt(scanner.next());

                                    switch (opcionPausa) {
                                        case 1:
                                            opcionPausa = 4;
                                            break;
                                        case 2:
                                            imprimirDatos(listaJugador, listaPuntos);
                                            break;
                                        case 3:
                                            vidas = 0;
                                            break;
                                        default:
                                            System.out.println("Valor desconocido");
                                    }

                                } while (opcionPausa != 4 && vidas != 0);
                                break;
                            case "e":
                            case "E":
                                //Finalizar juego
                                System.out.println("HAZ FINALIZADO EL JUEGO");
                                vidas = 0;
                                break;
                            default:
                                System.out.println("Valor desconocido");
                        }

                    } while (vidas != 0 && puntosTotales != puntos);

                    //Guardar datos
                    guardarDatos(nombre, puntos, contadorLista, listaJugador, listaPuntos);//Funcionamiento

                    System.out.println("=====================");
                    System.out.println("PARTIDA FINALIZADA");
                    System.out.println("=====================");
                    //FIN DEL CASE 1    

                }

                case 2 -> {
                    System.out.println("TABLA DE POSICIONES");
                    System.out.println("=====================");

                    imprimirDatos(listaJugador, listaPuntos);//Impresión 

                    System.out.println("=====================");
                }
                case 3 ->
                    System.out.println("""
                                             GRACIAS POR JUGAR PAC-MAN 
                                             Practica de Alvaro García
                                             Carnet: 202109567
                                             Lab de IPC 1
                                       """);
                default ->
                    System.out.println("Valor desconocido");
            }
        }
    }

    //Calculo para saber la cantidad de comida, paredes y trampas hay que poner
    public static int cantidadComida(int filas, int cols) {
        int calculo = (filas * cols) * 40 / 100;
        return calculo;
    }

    public static int cantidadParedes(int filas, int cols) {
        int calculo = (filas * cols) * 20 / 100;
        return calculo;
    }

    public static int cantidadTrampas(int filas, int cols) {
        int calculo = (filas * cols) * 20 / 100;
        return calculo;
    }

    //Imprimir tablero
    public static void imprimirTablero(String[][] tablero, int bordeFilas, int bordeCols) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + "   ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    //Imprimir juego
    public static void imprimirJuego(String[][] tablero, String nombre, int puntos, int vidas, int bordeFilas, int bordeCols) {
        System.out.println("========================================");
        System.out.println("|Jugador: " + nombre + "| Puntos: " + puntos + "| Vidas Restantes: " + vidas + "|");
        System.out.println("========================================");
        imprimirTablero(tablero, bordeFilas, bordeCols);
        System.out.println("========================================");
    }

    //Evaluar trampa 
    public static void verificarTrampa(boolean trampaExis, String[][] tablero, int x, int y) {
        if (trampaExis) {
            tablero[x][y] = "X";

        } else {
            tablero[x][y] = " ";
        }
    }

    //pasar los datos a un metodo 
    //Imprimir
    public static void guardarDatos(String nombre, int puntos, int contadorLista, String[] listaJugador, int[] listaPuntos) {

        String nuevoNombre = nombre;
        int nuevoPuntos = puntos;
        int contador = contadorLista;
        int pos;
        int aux;
        String aux2;

        //contadorLista
        if (listaJugador.length > contador && listaPuntos.length > contador) {
            listaJugador[contador] = nuevoNombre;
            listaPuntos[contador] = nuevoPuntos;
        }

        //Ordenar puntos y nombre, método de insercción 
        System.out.println(contadorLista);
        for (int i = 0; i < listaPuntos.length; i++) {
            pos = i;
            aux = listaPuntos[i];
            aux2 = listaJugador[i];
            while (pos > 1 && listaPuntos[pos - 1] > aux) {
                listaPuntos[pos] = listaPuntos[pos - 1]; //Aqui el movimiento
                listaJugador[pos] = listaJugador[pos - 1];
                pos--;
            }
            listaPuntos[pos] = aux;
            listaJugador[pos] = aux2;
        }

    }

    public static void imprimirDatos(String[] listaJugador, int[] listaPuntos) {
        //Imprimir    
        for (int i = (listaJugador.length - 1); i >= 0; i--) {
            if (listaJugador[i] != null) {
                int posact = listaPuntos.length - i;
                System.out.println(posact + "." + listaJugador[i] + " - " + listaPuntos[i]);
            }
        }

    }

}

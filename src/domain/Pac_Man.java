package domain;

import java.util.Random;
import java.util.Scanner;

public class Pac_Man {

    public static void main(String[] args) {
        //Imports/ variables globales
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int opcion = 0;

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
                    String nombre = "";
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
                    int puntos = 0;
                    int vidas = 3;
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
                            //if ((i == filas - 2) && (j == cols - 2)) {
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
                            //}
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
                            imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);
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
                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);

                    //INICIAR MOVIMIENTO
                    int puntosTotales = (comida1 * 5) + (comida2 * 10);
                    //boolean condicion = vidas != 0 && puntosTotales != puntos;
                    do {
                        System.out.print("Ingrese la tecla para elegir una opción o moverse: ");
                        movimiento = scanner.next();

                        switch (movimiento) {
                            case "D":
                            case "d":
                                //Moverse a la derecha
                                if (tablero[x][y + 1] == " ") {

                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {
                                            tablero[x][y + 1] = icono;
                                            tablero[x][y] = " ";

                                        }
                                    }
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);
                                } //Evaluar casilla de pared
                                else if (tablero[x][y + 1] == "#") {

                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {
                                            tablero[x][y + 1] = "#";
                                            //tablero[x][y] = icono;
                                        }
                                    }
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);
                                    System.out.println("Casilla ocupada, hay una pared");

                                } //Evaluar casilla de comida 1
                                else if (tablero[x][y + 1] == "@") {
                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {
                                            tablero[x][y + 1] = icono;
                                            tablero[x][y] = " ";

                                        }
                                    }
                                    puntos += 5;
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);
                                } //Evaluar casilla de comida 2
                                else if (tablero[x][y + 1] == "?") {
                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {
                                            tablero[x][y + 1] = icono;
                                            tablero[x][y] = " ";

                                        }
                                    }
                                    puntos += 10;
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);

                                } //Evaluar trampas 
                                else if (tablero[x][y + 1] == "X") {
                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {

                                            //Esto evalua que si despues de la trampa hay cosas
                                            if (tablero[x][y + 2] == " ") {
                                                tablero[x][y + 2] = icono;
                                                tablero[x][y] = " ";
                                            } else if (tablero[x][y + 2] == "@") {
                                                tablero[x][y + 2] = icono;
                                                tablero[x][y] = " ";
                                                puntos += 5;
                                            } else if (tablero[x][y + 2] == "?") {
                                                tablero[x][y + 2] = icono;
                                                tablero[x][y] = " ";
                                                puntos += 10;
                                            } else if (tablero[x][y + 2] == "X") {
                                                tablero[x][y + 3] = icono;
                                                tablero[x][y] = " ";

                                            } else if (tablero[x][y + 2] == "#") {
                                                tablero[x][y] = " ";
                                            }

                                        }
                                    }
                                    vidas = vidas - 1;
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);

                                } //Moverse entre bordes
                                else if (tablero[x][y + 1] == "|") {
                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {
                                            //Esto evalua que si despues de atravesar un borde hay cosas
                                            if (tablero[x][y - (y - 1)] == " ") {
                                                tablero[x][y - (y - 1)] = icono;
                                                tablero[x][y] = " ";
                                            } else if (tablero[x][y - (y - 1)] == "@") {
                                                tablero[x][y - (y - 1)] = icono;
                                                tablero[x][y] = " ";
                                                puntos += 5;
                                            } else if (tablero[x][y - (y - 1)] == "?") {
                                                tablero[x][y - (y - 1)] = icono;
                                                tablero[x][y] = " ";
                                                puntos += 10;
                                            } else if (tablero[x][y - (y - 1)] == "X") {
                                                tablero[x][y - (y - 2)] = icono;
                                                tablero[x][y] = " ";
                                                vidas -= 1;
                                            } else if (tablero[x][y - (y - 1)] == "#") {
                                                tablero[x][y] = " ";
                                            }
                                        }
                                    }
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);
                                }

                                //Actualizacion de y 
                                if (tablero[x][y + 1] == "|") {
                                    if (tablero[x][y - (y - 1)] == "X") {
                                        y = y - (y - 2);
                                    } else if (tablero[x][y - (y - 1)] == "#") {
                                        y = y;
                                    } else {
                                        y = y - (y - 1);
                                    }
                                } else if (tablero[x][y + 1] == "#") {
                                    y = y;
                                } else if (tablero[x][y + 1] == "X") {
                                    y = y + 2;
                                } else {
                                    y = y + 1;
                                }

                                //FIN DE MOVIMIENTO A LA DERECHA
                                break;
                            case "A":
                            case "a":
                                //INICIO DE MOVIMIENTO A LA IZQUIERDA
                                //Moverse a la izquierda
                                if (tablero[x][y - 1] == " ") {

                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {
                                            tablero[x][y - 1] = icono;
                                            tablero[x][y] = " ";

                                        }
                                    }
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);
                                } //Evaluar casilla de pared
                                else if (tablero[x][y - 1] == "#") {

                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {
                                            tablero[x][y - 1] = "#";
                                            //tablero[x][y] = icono;
                                        }
                                    }
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);
                                    System.out.println("Casilla ocupada, hay una pared");

                                } //Evaluar casilla de comida 1
                                else if (tablero[x][y - 1] == "@") {
                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {
                                            tablero[x][y - 1] = icono;
                                            tablero[x][y] = " ";

                                        }
                                    }
                                    puntos += 5;
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);
                                } //Evaluar casilla de comida 2
                                else if (tablero[x][y - 1] == "?") {
                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {
                                            tablero[x][y - 1] = icono;
                                            tablero[x][y] = " ";

                                        }
                                    }
                                    puntos += 10;
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);

                                } //Evaluar trampas 
                                else if (tablero[x][y - 1] == "X") {
                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {

                                            //Esto evalua que si despues de la trampa hay cosas
                                            if (tablero[x][y - 2] == " ") {
                                                tablero[x][y - 2] = icono;
                                                tablero[x][y] = " ";
                                            } else if (tablero[x][y - 2] == "@") {
                                                tablero[x][y - 2] = icono;
                                                tablero[x][y] = " ";
                                                puntos += 5;
                                            } else if (tablero[x][y - 2] == "?") {
                                                tablero[x][y - 2] = icono;
                                                tablero[x][y] = " ";
                                                puntos += 10;
                                            } else if (tablero[x][y + 2] == "X") {
                                                tablero[x][y + 4] = icono;
                                                tablero[x][y] = " ";

                                            } else if (tablero[x][y + 2] == "#") {
                                                tablero[x][y] = " ";
                                            }

                                        }
                                    }
                                    vidas = vidas - 1;
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);

                                } //Moverse entre bordes
                                else if (tablero[x][y - 1] == "|") {
                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {
                                            //Esto evalua que si despues de atravesar un borde hay cosas
                                            if (tablero[x][y - 1] == " ") {
                                                tablero[x][y - 2] = icono;
                                                tablero[x][y] = " ";
                                            } else if (tablero[x][y - 1] == "@") {
                                                tablero[x][y - 1] = icono;
                                                tablero[x][y] = " ";
                                                puntos += 5;
                                            } else if (tablero[x][y - 1] == "?") {
                                                tablero[x][y - 1] = icono;
                                                tablero[x][y] = " ";
                                                puntos += 10;
                                            } else if (tablero[x][y - 1] == "X") {
                                                tablero[x][y - 2] = icono;
                                                tablero[x][y] = " ";
                                                //vidas -= 1;
                                            } else if (tablero[x][y - 1] == "#") {
                                                tablero[x][y] = " ";
                                            }
                                        }
                                    }
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);
                                }
                                //Actualizando y
                                if (tablero[x][y - 1] == "|") {
                                    if (tablero[x][y - 1] == "X") {
                                        y = y - 2;
                                    } else if (tablero[x][y - 1] == "#") {
                                        y = y;
                                    } else {
                                        y = y - 1;
                                    }
                                } else if (tablero[x][y - 1] == "#") {
                                    y = y;
                                } else if (tablero[x][y - 1] == "X") {
                                    y = y - 2;
                                } else {
                                    y = y - 1;
                                }
                                //MOVIMIENTO A IZQUIERDA
                                break;
                            case "S":
                            case "s":
                                //INICIO DEL MOVIMIENTO HACIA ABAJO
                                //Moverse hacia abajo
                                if (tablero[x + 1][y] == " ") {

                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {
                                            tablero[x + 1][y] = icono;
                                            tablero[x][y] = " ";

                                        }
                                    }
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);
                                } //Evaluar casilla de pared
                                else if (tablero[x + 1][y] == "#") {

                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {
                                            tablero[x + 1][y] = "#";
                                            //tablero[x][y] = icono;
                                        }
                                    }
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);
                                    System.out.println("Casilla ocupada, hay una pared");

                                } //Evaluar casilla de comida 1
                                else if (tablero[x + 1][y] == "@") {
                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {
                                            tablero[x + 1][y] = icono;
                                            tablero[x][y] = " ";

                                        }
                                    }
                                    puntos += 5;
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);
                                } //Evaluar casilla de comida 2
                                else if (tablero[x + 1][y] == "?") {
                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {
                                            tablero[x + 1][y] = icono;
                                            tablero[x][y] = " ";

                                        }
                                    }
                                    puntos += 10;
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);

                                } //Evaluar trampas 
                                else if (tablero[x + 1][y] == "X") {
                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {

                                            //Esto evalua que si despues de la trampa hay cosas
                                            if (tablero[x + 2][y] == " ") {
                                                tablero[x + 2][y] = icono;
                                                tablero[x][y] = " ";
                                            } else if (tablero[x + 2][y] == "@") {
                                                tablero[x + 2][y] = icono;
                                                tablero[x][y] = " ";
                                                puntos += 5;
                                            } else if (tablero[x + 2][y] == "?") {
                                                tablero[x + 2][y] = icono;
                                                tablero[x][y] = " ";
                                                puntos += 10;
                                            } else if (tablero[x + 2][y] == "X") {
                                                tablero[x + 2][y] = icono;
                                                tablero[x][y] = " ";

                                            } else if (tablero[x + 2][y] == "#") {
                                                tablero[x][y] = " ";
                                            }

                                        }
                                    }
                                    vidas = vidas - 1;
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);

                                } //Moverse entre bordes
                                else if (tablero[x + 1][y] == "=") {
                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {
                                            //Esto evalua que si despues de atravesar un borde hay cosas
                                            if (tablero[x - (x - 1)][y] == " ") {
                                                tablero[x - (x - 1)][y] = icono;
                                                tablero[x][y] = " ";
                                            } else if (tablero[x - (x - 1)][y] == "@") {
                                                tablero[x - (x - 1)][y] = icono;
                                                tablero[x][y] = " ";
                                                puntos += 5;
                                            } else if (tablero[x - (x - 1)][y] == "?") {
                                                tablero[x - (x - 1)][y] = icono;
                                                tablero[x][y] = " ";
                                                puntos += 10;
                                            } else if (tablero[x - (x - 1)][y] == "X") {
                                                tablero[x - (x - 2)][y] = icono;
                                                tablero[x][y] = " ";
                                                vidas = vidas - 1;
                                            } else if (tablero[x - (x - 1)][y] == "#") {
                                                tablero[x][y] = " ";
                                            }
                                        }
                                    }
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);
                                }

                                //Actualizacion de x 
                                if (tablero[x + 1][y] == "=") {
                                    if (tablero[x - (x - 1)][y] == "X") {
                                        x = x - (x - 2);
                                    } else if (tablero[x - (x - 1)][y] == "#") {
                                        x = x;
                                    } else {
                                        x = x - (x - 1);
                                    }
                                } else if (tablero[x - 1][y] == "#") {
                                    x = x;
                                } else if (tablero[x - 1][y] == "X") {
                                    x = x + 2;
                                } else {
                                    x = x + 1;
                                }
                                //FIN DEL MOVIMIENTO HACIA ABAJO
                                break;
                            case "W":
                            case "w":
                                //INICIO MOVIMIENTO HACIA ARRIBA
                                //Moverse hacia abajo
                                if (tablero[x - 1][y] == " ") {

                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {
                                            tablero[x - 1][y] = icono;
                                            tablero[x][y] = " ";

                                        }
                                    }
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);
                                } //Evaluar casilla de pared
                                else if (tablero[x - 1][y] == "#") {

                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {
                                            tablero[x - 1][y] = "#";
                                            //tablero[x][y] = icono;
                                        }
                                    }
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);
                                    System.out.println("Casilla ocupada, hay una pared");

                                } //Evaluar casilla de comida 1
                                else if (tablero[x - 1][y] == "@") {
                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {
                                            tablero[x - 1][y] = icono;
                                            tablero[x][y] = " ";

                                        }
                                    }
                                    puntos += 5;
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);
                                } //Evaluar casilla de comida 2
                                else if (tablero[x - 1][y] == "?") {
                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {
                                            tablero[x - 1][y] = icono;
                                            tablero[x][y] = " ";

                                        }
                                    }
                                    puntos += 10;
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);

                                } //Evaluar trampas 
                                else if (tablero[x - 1][y] == "X") {
                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {

                                            //Esto evalua que si despues de la trampa hay cosas
                                            if (tablero[x - 1][y] == " ") {
                                                tablero[x - 2][y] = icono;
                                                tablero[x][y] = " ";
                                            } else if (tablero[x - 2][y] == "@") {
                                                tablero[x - 2][y] = icono;
                                                tablero[x][y] = " ";
                                                puntos += 5;
                                            } else if (tablero[x - 2][y] == "?") {
                                                tablero[x - 2][y] = icono;
                                                tablero[x][y] = " ";
                                                puntos += 10;
                                            } else if (tablero[x - 2][y] == "X") {
                                                tablero[x - 2][y] = icono;
                                                tablero[x][y] = " ";

                                            } else if (tablero[x - 2][y] == "#") {
                                                tablero[x][y] = " ";
                                            }

                                        }
                                    }
                                    vidas = vidas - 1;
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);

                                } //Moverse entre bordes
                                else if (tablero[x - 1][y] == "=") {
                                    for (int i = 0; i < filas; i++) {
                                        for (int j = 0; j < cols; j++) {
                                            //Esto evalua que si despues de atravesar un borde hay cosas
                                            if (tablero[cols - 1][y] == " ") {
                                                tablero[cols - 1][y] = icono;
                                                tablero[x][y] = " ";
                                            } else if (tablero[cols - 1][y] == "@") {
                                                tablero[cols - 1][y] = icono;
                                                tablero[x][y] = " ";
                                                puntos += 5;
                                            } else if (tablero[cols - 1][y] == "?") {
                                                tablero[cols - 1][y] = icono;
                                                tablero[x][y] = " ";
                                                puntos += 10;
                                            } else if (tablero[cols - 1][y] == "X") {
                                                tablero[cols - 1][y] = icono;
                                                tablero[x][y] = " ";
                                                vidas = vidas - 1;
                                            } else if (tablero[cols - 1][y] == "#") {
                                                tablero[x][y] = " ";
                                            }
                                        }
                                    }
                                    imprimirJuego(tablero, comida, puntos, vidas, bordeFilas, bordeCols);
                                }

                                //Actualizacion de y 
                                if (tablero[x + 1][y] == "=") {
                                    if (tablero[cols - 1][y] == "X") {
                                        x = cols - 1;
                                    } else if (tablero[cols - 1][y] == "#") {
                                        x = x;
                                    } else {
                                        x = cols - 1;
                                    }
                                } else if (tablero[x - 1][y] == "#") {
                                    x = x;
                                } else if (tablero[x - 1][y] == "X") {
                                    x = x - 2;
                                } else {
                                    x = x - 1;
                                }
                                //FIN DEL MOVIMIENTO HACIA ARRIBA
                                break;
                            case "e":
                            case "E":
                                //Finalizar juego
                                System.out.println("SE HA FINALIZADO EL JUEGO");
                                vidas = 0;
                                break;
                            case "M":
                            case "m":
                                break;
                            default:
                                System.out.println("Valor desconocido");
                        }
                    } while (vidas != 0 && puntosTotales != puntos);

                    //llamar metodo para guardar datos 
                    guardarDatos(nombre, puntos);
                   

                    System.out.println("=====================");
                    System.out.println("PARTIDA FINALIZADA");
                    System.out.println("=====================");
                    //FIN DEL CASE 1    
                }
                case 2 -> {
                }
                case 3 ->
                    System.out.println(""" 
                                             GRACIAS POR JUGAR PAC-MAN 
                                             Practica de Alvaro García""");
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
        for (int i = 0; i < bordeFilas; i++) {
            for (int j = 0; j < bordeCols; j++) {
                System.out.print(tablero[i][j] + "   ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    //Imprimir juego
    public static void imprimirJuego(String[][] tablero, int nombre, int puntos, int vidas, int bordeFilas, int bordeCols) {
        System.out.println("========================================");
        System.out.println("|Jugador: " + nombre + "| Puntos: " + puntos + "| Vidas Restantes: " + vidas + "|");
        System.out.println("========================================");
        imprimirTablero(tablero, bordeFilas, bordeCols);
        System.out.println("========================================");
    }

    //Reinicar todo los datos
    public static void guardarDatos(String nombre, int puntos) {
        //Pasarlas a una matriz 
        String nuevoNombre = nombre;
        int nuevoPuntos = puntos;
        System.out.println("Jugador: " + nuevoNombre + " puntos obtenidos: " + nuevoPuntos);
        //Reinicar todo los valores
       
    }
}

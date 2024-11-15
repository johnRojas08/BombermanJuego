import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int filas = 0;
        int columnas = 0;

        //Pidiendo al usuario un número de filas entero
        do {
            System.out.println("Introduce un valor entero positivo para las filas:");
            while (!input.hasNextInt()) { //Verificación de números enteros
                System.out.println("Error: debes ingresar un número entero positivo.");
                input.next(); //Limpia el Buffer
            }
            filas = input.nextInt();
            if (filas <= 0) {
                System.out.println("Error: debes ingresar un número entero positivo.");
            }
        } while (filas <= 0);

        System.out.println("Correcto has introducido" + filas + "filas.");

        // Pidiendo al usuario un número de columnas entero
        do {
            System.out.println("Introduce un valor entero positivo para las columnas:");
            while (!input.hasNextInt()) { //Verificación de números enteros
                System.out.println("Error: debes ingresar un número entero positivo.");
                input.next(); //Limpia el Buffer
            }
            columnas = input.nextInt();

            if (columnas <= 0) {
                System.out.println("Error: debes ingresar un número entero positivo.");
            }
        } while (columnas <= 0);

        System.out.println("Correcto has introducido" + columnas + "columnas.");

        //Generando la matriz con valores aleatorios

        int[][] matriz = new int[filas][columnas];
        for (int i= 0; i< matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(9) + 1;
            }
        }
            System.out.println("Matriz generada:");
            mostrarMatriz(matriz);

        // Iniciando el Menú principal
            mostrarMenu(input, matriz);
            input.close();
        }

        //Ménu opciones
        private static void mostrarMenu(Scanner scanner, int[][] matriz){
            while(true){
                System.out.println("\nMenú de opciones:");
                System.out.println("[2] Poner bomba");
                System.out.println("[1] Mostrar matriz");
                System.out.println("[0] Salir");

                String opcion = scanner.nextLine();
                switch (opcion){
                    case "2":
                        ponerBomba(scanner, matriz);
                        break;
                    case "1":
                        mostrarMatriz(matriz);
                        break;
                    case "0":
                        System.out.println("Saliendo del programa");
                    return;
                    default:System.out.println("Opción invalida. Por favor, elija nuevamente.");
                    break;
                }
            }
        }
        // Creando poner Bomba
        private static void ponerBomba(Scanner scanner, int[][] matriz){
            System.out.println("Introudce las coodernadas de la Bomba (x,y):");
            int x = -1;
            int y = -1;

        // Coordenas válidas
        while(true){
            System.out.println("x:");
            x = scanner.nextInt();
            System.out.println("y:");
            y = scanner.nextInt();
            scanner.nextLine(); //limpia el buffer

            if (x >= 0 && x< matriz.length && y >= 0 && y< matriz[0].length){
                matriz[x][y] = 0;
                System.out.println("Bomba colocada en(" + x + "," + y + ")");
                break;

            }else{
                System.out.println("Coordenas inválidas, intentelo otra vez.");
            }

        }

     // Calculo del valor de explosión
    int valorExplosion = calcularValorExplosion(matriz,x,y);
    System.out.println("Valor explosión: " + valorExplosion);

    //Actualización de la matriz a 0 la fina x y la columna y
    actualizarMatriz(matriz, x, y);

    //Mostra la matriz actualizada
    mostrarMatriz(matriz);

    // Comprobación, si el juego ha terminado
    if (juegoTerminado(matriz)) {
        System.out.println("¡Fin del juego Todos los valores son 0.");
        System.exit(0);
       }

    }

    private static int calcularValorExplosion(int[][] matriz, int x, int y) {
        int suma = 0;

        // Sumar la fila x
        for (int j = 0; j < matriz[x].length; j++) {
            suma += matriz[x][y];
        }
        // Suma la columna y
        for (int i = 0; i < matriz.length; i++) {
            if (i != x) {
                suma += matriz[i][y];
            }
        }

        return suma;
    }

    private static void actualizarMatriz(int[][] matriz, int x, int y) {
        // Poner a 0 la fila x
        for (int j = 0; j < matriz[x].length; j++) {
            matriz[x][y] = 0;
        }

        // Poner a 0 la columna y
        for (int i = 0; i < matriz.length; i++) {
            matriz[i][y] = 0;
        }
    }

    private static boolean juegoTerminado(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // Creando mostrar Matriz
        private static void mostrarMatriz(int[][] matriz) {
        for( int i = 0 ; i < matriz.length; i++) {
            for( int j = 0; j < matriz[i].length; j++) {
                System.out.println(matriz[i][j] + " ");
            }
        System.out.println();
        }

    }
}


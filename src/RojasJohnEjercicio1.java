import java.util.Random;
import java.util.Scanner;

public class RojasJohnEjercicio1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int filas = obtenerDimension(input, "filas");
        int columnas = obtenerDimension(input, "columnas");

        //Generando la matriz con valores aleatorios

        int[][] matriz = new int[filas][columnas];
        for (int i= 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = random.nextInt(9) + 1;
            }
        }
            System.out.println("Matriz generada:");
            mostrarMatriz(matriz);

        // Iniciando el Menú principal
            mostrarMenu(input, matriz);
            input.close();
        }

        private static int obtenerDimension(Scanner input, String tipo) {
        int valor;
        do {
            System.out.println("Introduce un valor entero positivo para las " + tipo + ":");
            while (!input.hasNextInt()) {
                System.out.println("Error: debes ingresar un número entero positivo.");
                input.next();

            }
            valor = input.nextInt();
            input.nextLine(); // limpia el buffer
        } while (valor <= 0);
        return valor;
        }
        //Ménu opciones
        private static void mostrarMenu(Scanner scanner, int[][] matriz) {
            while(true){
                System.out.println("\nMenú de opciones:");
                System.out.println("[2] Poner bomba");
                System.out.println("[1] Mostrar matriz");
                System.out.println("[0] Salir");

                String opcion = scanner.nextLine().trim();
                switch (opcion) {
                    case "2":
                        ponerBomba(scanner, matriz);
                        break;
                    case "1":
                        mostrarMatriz(matriz);
                        break;
                    case "0":
                        System.out.println("Saliendo del programa");
                    return;
                    default:
                        System.out.println("Opción invalida. Por favor, elija nuevamente.");
                    break;
                }
            }
        }
        // Creando poner Bomba
        private static void ponerBomba(Scanner scanner, int[][] matriz) {
           int x, y;

        // Coordenas válidas
        while(true){
            System.out.println(" Introduce las coordenadas de la bomba (x,y):");
            System.out.print("x: ");
            x = scanner.nextInt();
            System.out.print("y:");
            y = scanner.nextInt();
            scanner.nextLine(); //limpia el buffer

            if (x >= 0 && x < matriz.length && y >= 0 && y < matriz[0].length){
                break;
            }else{
                System.out.println("Coordenas inválidas, intentelo otra vez.");
            }
        }

     matriz[x][y] = 0;
        System.out.println("Bomba colocada en (" + x + "," + y + ")");

     // Calculo del valor de explosión
    int valorExplosion = calcularValorExplosion(matriz, x, y);
    System.out.println("Valor explosión: " + valorExplosion);

    actualizarMatriz(matriz, x, y);   //Actualización de la matriz a 0 la fina x y la columna y

    mostrarMatriz(matriz);  //Mostra la matriz actualizada

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
            suma += matriz[x][j];
        }
        // Suma la columna y
        for (int i = 0; i < matriz.length; i++) {
                suma += matriz[i][y];
        }
        suma -= matriz[x][y]; //evitar doble suma
        return suma;
    }

    private static void actualizarMatriz(int[][] matriz, int x, int y) {
        for (int j = 0; j < matriz[x].length; j++) {
            matriz[x][j] = 0;
        }
        for (int i = 0; i < matriz.length; i++) {
            matriz[i][y] = 0;
        }
    }

    private static boolean juegoTerminado(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor != 0) {
                    return false; // valores distinto de 0 el juego continuará
                }
            }
        }
        return true;
    }

    // Creando mostrar Matriz
        private static void mostrarMatriz(int[][] matriz) {
        for(int[] fila : matriz) {
            for( int valor : fila) {
                System.out.print(valor + " ");
            }
        System.out.println();
        }
    }
}


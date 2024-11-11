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

        //Generando la matriz

        int[][] matriz = new int[filas][columnas];
        //matriz con valores aleatorios

        for (int i= 0; i< matriz.length; i++) {
            for (int j = 0; j <matriz[i].length; j++) {
                matriz[i][j] = random.nextInt(9) + 1;
            }
        }
        System.out.println("Matriz generada:");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        input.close();
    }
}


package Utils;

/**
 *
 * @author Norwin
 */
import java.util.Scanner;
import java.util.InputMismatchException;

public class Validaciones {

    public static Scanner scan = new Scanner(System.in);

    public static int leerEnteroSeguro(String mensaje) {
        int valor;

        while (true) {
            try {
                System.out.println(mensaje);
                valor = scan.nextInt();
                break;

            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Error formato incorrecto");
            }
        }
        return valor;
    }
}

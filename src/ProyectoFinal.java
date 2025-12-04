
/**
 *
 * @author Norwin
 */
import proyectofinal.*;
import java.util.Scanner;

public class ProyectoFinal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Tablero tablero = new Tablero(5);
        Caballo caballo = new Caballo(tablero, 0, 0);

        System.out.println("Juego del Caballo");

        boolean jugando = true;
        while (jugando) {
            tablero.mostrar();
            caballo.mostrarPosicionActual();
            caballo.mostrarMovimientosPosibles();

            boolean movimientoExitoso = caballo.realizarMovimiento();

            if (!movimientoExitoso) {
                System.out.print("Seguir intentando? (s/n): ");
                String respuesta = scanner.next();
                if (respuesta.equals("n")) {
                    jugando = false;
                }
            }

            if (tablero.getMovimientoActual() > tablero.getTamanio() * tablero.getTamanio()) {
                System.out.println("Tablero completo");
                jugando = false;
            }
        }

    }

}

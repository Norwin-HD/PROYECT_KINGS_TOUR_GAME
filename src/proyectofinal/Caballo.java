package proyectofinal;

/**
 *
 * @author Norwin
 */

import Utils.Validaciones;

public class Caballo {

    private final int[] movX = {2, 1, -1, -2, -2, -1, 1, 2};
    private final int[] movY = {1, 2, 2, 1, -1, -2, -2, -1};

    private Tablero tablero;
    private int posX;
    private int posY;

    public Caballo(Tablero tablero, int x, int y) {
        this.tablero = tablero;
        this.posX = x;
        this.posY = y;
        tablero.marcarCasilla(x, y, -1);
    }

    public void mostrarMovimientosPosibles() {
        System.out.println("Movimientos posibles desde (" + posX + ", " + posY + "):");
        int contador = 1;

        for (int i = 0; i < 8; i++) {
            int nuevaX = posX + movX[i];
            int nuevaY = posY + movY[i];

            if (tablero.esMovimientoValido(nuevaX, nuevaY)) {
                System.out.println(contador + ". (" + nuevaX + ", " + nuevaY + ")");
                contador++;
            }
        }

        if (contador == 1) {
            System.out.println("No hay movimientos posibles");
        }
    }

    public boolean realizarMovimiento() {
        int destinoX = Validaciones.leerEnteroSeguro("Ingrese X destino: ");
        int destinoY = Validaciones.leerEnteroSeguro("Ingrese Y destino: ");

        if (tablero.esMovimientoValido(destinoX, destinoY) && esMovimientoCaballo(destinoX, destinoY)) {
            tablero.marcarCasilla(posX, posY, tablero.getMovimientoActual());

            posX = destinoX;
            posY = destinoY;
            tablero.marcarCasilla(posX, posY, -1);
            tablero.incrementarMovimiento();

            System.out.println("Movimiento exitoso");
            return true;
        } else {
            System.out.println("Movimiento invalido");
            return false;
        }
    }

    private boolean esMovimientoCaballo(int destinoX, int destinoY) {
        for (int i = 0; i < 8; i++) {
            if ((posX + movX[i] == destinoX) && (posY + movY[i] == destinoY)) {
                return true;
            }
        }
        return false;
    }

    public void mostrarPosicionActual() {
        System.out.println("Posicion actual: (" + posX + ", " + posY + ")");
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}

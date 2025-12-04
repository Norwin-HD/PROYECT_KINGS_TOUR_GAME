package proyectofinal;

/**
 *
 * @author Norwin
 */

public class Tablero {

    private int[][] celdas;
    private int tamaño;
    private int movimientoActual;

    public Tablero(int tamaño) {
        this.tamaño = tamaño;
        this.celdas = new int[tamaño][tamaño];
        this.movimientoActual = 1;
        inicializarTablero();
    }

    private void inicializarTablero() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                celdas[i][j] = 0;
            }
        }
    }

    public boolean esMovimientoValido(int x, int y) {
        if (x < 0 || x >= tamaño || y < 0 || y >= tamaño) {
            return false;
        }
        return celdas[x][y] == 0;
    }

    public void marcarCasilla(int x, int y, int valor) {
        celdas[x][y] = valor;
    }

    public void mostrar() {
        System.out.println("Tablero - Movimiento: " + movimientoActual);

        System.out.print("  ");
        for (int j = 0; j < tamaño; j++) {
            System.out.print(j + " ");
        }
        System.out.println();

        for (int i = 0; i < tamaño; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < tamaño; j++) {
                if (celdas[i][j] == -1) {
                    System.out.print("C ");
                } else if (celdas[i][j] == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(celdas[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void incrementarMovimiento() {
        movimientoActual++;
    }

    public int getMovimientoActual() {
        return movimientoActual;
    }

    public int getTamanio() {
        return tamaño;
    }
}

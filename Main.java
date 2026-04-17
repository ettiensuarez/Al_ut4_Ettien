/**
 * * @author Ettien Suárez Ramírez
 */
public class Main {

    /**
     * Metodo principal (entry point) de la aplicacion.
     * * @param args argumentos de linea de comandos (no se usan en este caso)
     */
    public static void main(final String[] args) {

        // Renombramos las variables para que tengan sentido logico
        int limite = 0;
        int sumandoBase = 15;
        int incrementoExtra = 20;
        int contador = 0;

        do {
            incrementoExtra = 10 + sumandoBase;
            contador = contador + incrementoExtra;
            contador++;

            if (contador < 10) {
                limite = 15;
                contador = contador - 1;
            } else {
                limite = 10;
                contador = contador - 1;
            }

            int auxiliar;
            auxiliar = contador;
            limite = auxiliar;

        } while (contador < 100);
    }
}
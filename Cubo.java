import javax.swing.JOptionPane;

/**
 * Clase que representa la figura geometrica de un Cubo.
 * Permite calcular su area y volumen, ademas de interactuar con el usuario.
 * @author Ettien Suárez Ramírez.
 */
public class Cubo {

    /** Atributo que define el tamaño de la arista del cubo */
    private float lado;

    /**
     * Constructor que inicializa el cubo con un lado especifico.
     * @param lado Tamaño del lado del cubo.
     */
    public Cubo(float lado) {
        // Control de errores basico en el constructor
        if (lado >= 0) {
            this.lado = lado;
        } else {
            this.lado = 0;
        }
    }

    /**
     * Obtiene el valor del lado.
     * @return El valor actual del lado.
     */
    public float getLado() {
        return lado;
    }

    /**
     * Modifica el valor del lado.
     * @param lado Nuevo valor para el lado.
     */
    public void setLado(float lado) {
        if (lado >= 0) {
            this.lado = lado;
        }
    }

    /**
     * Calcula el area de la base del cubo (lado por lado).
     * @return Area calculada.
     */
    public float calcularAreaBase() {
        return lado * lado;
    }

    /**
     * Calcula el volumen total del cubo (lado al cubo).
     * @return Volumen calculado.
     */
    public float calcularVolumen() {
        return lado * lado * lado;
    }

    /**
     * Solicita al usuario que introduzca el lado usando una ventana de dialogo.
     * Incluye control de errores para evitar cuelgues si se introducen letras.
     */
    public void pedirLadoUsuario() {
        boolean ladoValido = false;

        // Bucle que se repite hasta que el usuario meta un numero correcto
        while (!ladoValido) {
            String texto = JOptionPane.showInputDialog(null, "Introduce el tamaño del lado del cubo:");

            // Control por si el usuario le da a la X o al boton de Cancelar
            if (texto == null) {
                JOptionPane.showMessageDialog(null, "Operacion cancelada. Se pondra el lado a 1 por defecto.");
                this.lado = 1.0f;
                ladoValido = true;
            } else {
                try {
                    // Intentamos convertir el texto a float
                    float valorIntroducido = Float.parseFloat(texto);

                    // Controlamos que no nos metan lados negativos
                    if (valorIntroducido > 0) {
                        this.lado = valorIntroducido;
                        ladoValido = true; // Salimos del bucle
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: El lado tiene que ser mayor que cero.");
                    }

                } catch (NumberFormatException e) {
                    // Si salta esta excepcion, es que han metido letras o simbolos raros
                    JOptionPane.showMessageDialog(null, "Error crítico evitado: Por favor, introduce solo numeros (ejemplo: 5.5).");
                }
            }
        }
    }

    /**
     * Muestra el area de la base del cubo en una ventana de dialogo.
     */
    public void imprimirArea() {
        JOptionPane.showMessageDialog(null, "El area de la base es: " + calcularAreaBase());
    }

    /**
     * Muestra el volumen del cubo en una ventana de dialogo.
     */
    public void imprimirVolumen() {
        JOptionPane.showMessageDialog(null, "El volumen del cubo es: " + calcularVolumen());
    }

    /**
     * Metodo main para probar los requisitos 8 y 9.
     * @param args Argumentos (no usados).
     */
    public static void main(String[] args) {
        // Creamos tres cubos
        Cubo cubo1 = new Cubo(0);
        cubo1.pedirLadoUsuario(); // Probamos nuestro nuevo control de errores

        Cubo cubo2 = new Cubo(5.5f);
        Cubo cubo3 = new Cubo(12.0f);

        // Probamos a imprimir area y volumen del primero
        cubo1.imprimirArea();
        cubo1.imprimirVolumen();

        // Comprobamos cual es el mayor
        Cubo mayor = cubo1;
        if (cubo2.calcularVolumen() > mayor.calcularVolumen()) {
            mayor = cubo2;
        }
        if (cubo3.calcularVolumen() > mayor.calcularVolumen()) {
            mayor = cubo3;
        }

        JOptionPane.showMessageDialog(null, "El cubo con mayor volumen tiene un lado de: " + mayor.getLado());
    }
}
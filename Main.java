/**
 * Clase main final.
 * Solo se encarga de instanciar GestorCubos y probar metodos.
 * @author Ettien Suárez Ramírez
 * @version 2.0
 */
public class Main {
    public static void main(String[] args) {

        GestorCubos gestor = new GestorCubos();
        gestor.inicializarLista();

        System.out.println("Lista antes de ordenar:");
        for(Cubo c : gestor.getLista()) {
            System.out.println("- Cubo de lado: " + c.getLado());
        }

        gestor.ordenarPorTamano();

        System.out.println("\nLista despues de ordenar:");
        for(Cubo c : gestor.getLista()) {
            System.out.println("- Cubo de lado: " + c.getLado());
        }

        // Comprobacion de encaje
        Cubo c1 = new Cubo(5f);
        Cubo c2 = new Cubo(10f);
        System.out.println("\n¿El cubo de lado 5 cabe en el de 10? " + gestor.cabeDentro(c1, c2));
    }
}
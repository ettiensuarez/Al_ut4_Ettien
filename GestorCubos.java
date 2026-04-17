import java.util.ArrayList;

/**
 * Gestor responsable de manejar las operaciones de multiples Cubos.
 * @author Ettien Suárez Ramírez
 */
public class GestorCubos {

    private ArrayList<Cubo> lista;

    public GestorCubos() {
        this.lista = new ArrayList<>();
    }

    /**
     * Inicializa la lista con un par de cubos de prueba.
     */
    public void inicializarLista() {
        lista.add(new Cubo(15f));
        lista.add(new Cubo(4.5f));
        lista.add(new Cubo(8f));
    }

    /**
     * Ordena la lista de menor a mayor tamaño usando el metodo burbuja.
     */
    public void ordenarPorTamano() {
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - i - 1; j++) {
                if (lista.get(j).getLado() > lista.get(j + 1).getLado()) {
                    Cubo temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * Determina si el primer cubo cabe dentro del segundo.
     * @param c1 Cubo a introducir.
     * @param c2 Cubo contenedor.
     * @return true si cabe, false si no.
     */
    public boolean cabeDentro(Cubo c1, Cubo c2) {
        return c1.getLado() < c2.getLado();
    }

    public ArrayList<Cubo> getLista() {
        return lista;
    }
}
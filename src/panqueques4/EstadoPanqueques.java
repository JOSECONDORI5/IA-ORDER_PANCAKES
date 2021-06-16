package panqueques4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Jose Condori
 * @version 16 jun. 2021 9:50:20
 */
public class EstadoPanqueques implements Estado {

    private final int[] META = {1, 2, 3, 4};
    private int[] panquequeActual;

    public EstadoPanqueques(int[] panquequeActual) {
        this.panquequeActual = panquequeActual;
    }

    private int[] getPanquequeActual() {
        return panquequeActual;
    }

    @Override
    public boolean esMeta() {
        return Arrays.equals(panquequeActual, META);
    }

    @Override
    public ArrayList<Estado> generarSucesores() {
        ArrayList<Estado> sucesores = new ArrayList<>();
        int[] panquequeCopia = Arrays.copyOf(panquequeActual, panquequeActual.length);
        int aux = 0;

        // Voltear 2
        aux = panquequeCopia[0];
        panquequeCopia[0] = panquequeCopia[1];
        panquequeCopia[1] = aux;

        sucesores.add(new EstadoPanqueques(panquequeCopia));

        // Voltear 3
        panquequeCopia = Arrays.copyOf(panquequeActual, panquequeActual.length);
        aux = panquequeCopia[0];
        panquequeCopia[0] = panquequeCopia[2];
        panquequeCopia[2] = aux;

        sucesores.add(new EstadoPanqueques(panquequeCopia));

        // Voltear 4
        panquequeCopia = Arrays.copyOf(panquequeActual, panquequeActual.length);
        aux = panquequeCopia[0];
        panquequeCopia[0] = panquequeCopia[3];
        panquequeCopia[3] = aux;
        aux = panquequeCopia[1];
        panquequeCopia[1] = panquequeCopia[2];
        panquequeCopia[2] = aux;

        sucesores.add(new EstadoPanqueques(panquequeCopia));

        return sucesores;
    }

    @Override
    public void mostrarEstado() {
        System.out.println("[" + panquequeActual[0] + "," + panquequeActual[1] + "," + panquequeActual[2] + "," + panquequeActual[3] + "]");
    }

    @Override
    public boolean igual(Estado e) {
        return Arrays.equals(panquequeActual, ((EstadoPanqueques) e).getPanquequeActual());
    }

}

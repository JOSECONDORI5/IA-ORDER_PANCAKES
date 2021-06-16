package busqueda;

import java.util.ArrayList;
import java.util.Stack;
import panqueques4.Estado;

/**
 *
 * @author Jose Condori
 * @version 14 jun. 2021 09:01:02
 */
public class BusquedaDFS {

    public static void buscar(NodoDeBusqueda raiz) {
        Stack<NodoDeBusqueda> cola = new Stack<>();
        cola.push(raiz);
        realizarBusqueda(cola);
    }

    public static void realizarBusqueda(Stack<NodoDeBusqueda> cola) {
        int contadorBusqueda = 1;

        System.out.println("SALE DE COLA: ");
        
        while (!cola.isEmpty()) {
            NodoDeBusqueda nodoTemp = cola.pop();
            nodoTemp.getEstadoActual().mostrarEstado();
            
            if (nodoTemp.getEstadoActual().esMeta()) {
                Stack<NodoDeBusqueda> caminoSolucion = new Stack<>();
                caminoSolucion.push(nodoTemp);
                nodoTemp = nodoTemp.getPadre();

                while (nodoTemp != null && nodoTemp.getPadre() != null) {
                    caminoSolucion.push(nodoTemp);
                    nodoTemp = nodoTemp.getPadre();
                }

                if (nodoTemp != null && nodoTemp.getPadre() == null) {
                    caminoSolucion.push(nodoTemp);
                }

                System.out.println("\nSOLUCION:");

                while (!caminoSolucion.isEmpty()) {
                    nodoTemp = caminoSolucion.pop();
                    nodoTemp.getEstadoActual().mostrarEstado();
                }
                System.out.println("\nNúmero de nodos examinados: " + contadorBusqueda);
                System.exit(0);
            } else {
                ArrayList<Estado> sucesoresTemp = nodoTemp.getEstadoActual().generarSucesores();

                for (int i = sucesoresTemp.size() - 1; i >= 0; i--) {
                    NodoDeBusqueda nuevoNodo = new NodoDeBusqueda(nodoTemp, sucesoresTemp.get(i));
                    if (!revisarRepetidos(nuevoNodo)) {
                        cola.push(nuevoNodo);
                    }
                }
            }
            contadorBusqueda++;
        }
    }

    public static boolean revisarRepetidos(NodoDeBusqueda n) {
        NodoDeBusqueda nodoRevisado = n;

        while (n.getPadre() != null) {
            if (n.getPadre().getEstadoActual().igual(nodoRevisado.getEstadoActual())) {
                return true;
            }
            n = n.getPadre();
        }
        return false;
    }
}

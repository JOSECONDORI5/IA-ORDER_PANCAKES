package busqueda;

import panqueques4.Estado;


/**
 *
 * @author Jose Condori
 * @version 14 jun. 2021 09:00:30
 */
public class NodoDeBusqueda {
    private Estado estadoActual;
    private NodoDeBusqueda padre;
    
    // Constructor para la raiz
    public NodoDeBusqueda(Estado e){
        estadoActual = e;
        padre = null;
    }
    
    // Constructor para los otros nodos de busqueda
    public NodoDeBusqueda(NodoDeBusqueda padre, Estado e){
        this.estadoActual = e;
        this.padre = padre;
    }

    public Estado getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(Estado estadoActual) {
        this.estadoActual = estadoActual;
    }

    public NodoDeBusqueda getPadre() {
        return padre;
    }

    public void setPadre(NodoDeBusqueda padre) {
        this.padre = padre;
    }
}

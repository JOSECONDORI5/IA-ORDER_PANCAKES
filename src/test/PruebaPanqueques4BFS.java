/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import busqueda.BusquedaBFS;
import busqueda.NodoDeBusqueda;
import panqueques4.EstadoPanqueques;

/**
 *
 * @author Jose Condori
 */
public class PruebaPanqueques4BFS {

    public static void main(String[] args) {
        int[] p01 = {3, 4, 2, 1}; // El orden de los números indican el tamaño de los panqueques
        
        EstadoPanqueques e01 = new EstadoPanqueques(p01);
        NodoDeBusqueda raiz = new NodoDeBusqueda(e01);
        
        BusquedaBFS.buscar(raiz);
    }
    
}

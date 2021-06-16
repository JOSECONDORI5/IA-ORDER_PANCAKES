/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import panqueques4.EstadoPanqueques;

/**
 *
 * @author Jose Condori
 */
public class PruebaSucesoresPanqueques4 {

    public static void main(String[] args) {
        int[] p01 = {1, 3, 4, 1}; // El orden de los números indican el tamaño de los panqueques
        EstadoPanqueques e01 = new EstadoPanqueques(p01);
        e01.generarSucesores().forEach(item -> item.mostrarEstado());
    }
}

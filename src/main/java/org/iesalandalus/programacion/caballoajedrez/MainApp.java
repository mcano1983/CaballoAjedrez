package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
	
	public static void main(String[] args) {
		System.out.println("Programa para aprender a colocar y mover un caballo en el tablero de ajedrez");

		Caballo caballo = new Caballo(Color.NEGRO);
		
		System.out.println(caballo.getPosicion());
		try {
			caballo.mover(Direccion.ABAJO_DERECHA);
		}catch(OperationNotSupportedException e) {}
		
		System.out.println(caballo.getPosicion());
		try {
			caballo.mover(Direccion.ABAJO_DERECHA);
		}catch(OperationNotSupportedException e) {}
		
		System.out.println(caballo.getPosicion());
		try {
			caballo.mover(Direccion.ABAJO_DERECHA);
		}catch(OperationNotSupportedException e) {}
		
		System.out.println(caballo.getPosicion());
	}
}
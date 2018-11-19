package org.iesalandalus.programacion.caballoajedrez;

public class Posicion {
	private int fila;
	private char columna;

	public int getFila() {
		return this.fila;
	}

	public char getColumna() {
		return this.columna;
	}

	public void setFila(int fila) {
		if (fila >= 1 && fila <= 8) {
			this.fila = fila;
		} else {
			throw new IllegalArgumentException();
		}

	}

	public void setColumna(char columna) {
		if (columna == 'a' || columna == 'b' || columna == 'c' || columna == 'd' || columna == 'e' || columna == 'f'
				|| columna == 'g' || columna == 'h') {
			this.columna = columna;
		} else {
			throw new IllegalArgumentException();
		}

	}

	public Posicion(int fila, char columna) {
		this.setFila(fila);
		this.setColumna(columna);
	}
}

package org.iesalandalus.programacion.caballoajedrez;

import static org.junit.Assert.assertEquals;

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
			throw new IllegalArgumentException("ERROR: Fila no válida.");
		}

	}

	public void setColumna(char columna) {
		if (columna == 'a' || columna == 'b' || columna == 'c' || columna == 'd' || columna == 'e' || columna == 'f'
				|| columna == 'g' || columna == 'h') {
			this.columna = columna;
		} else {
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}

	}

	public Posicion(int fila, char columna) {
		this.setFila(fila);
		this.setColumna(columna);
	}

	public Posicion(Posicion nuevaPosicion) {
		if (nuevaPosicion != null) {
			this.fila = nuevaPosicion.getFila();
			this.columna = nuevaPosicion.getColumna();
		} else {
			throw new IllegalArgumentException("ERROR: No es posible copiar una posición nula.");
		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + columna;
		result = prime * result + fila;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		if (columna != other.columna)
			return false;
		if (fila != other.fila)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[fila=" + this.fila + ", columna=" + this.columna + "]";
	}

}

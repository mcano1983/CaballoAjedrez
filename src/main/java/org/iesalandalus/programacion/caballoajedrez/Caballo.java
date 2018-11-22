package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;

public class Caballo {
	private Color color;
	private Posicion posicion;

	public Color getColor() {
		return this.color;

	}

	public Posicion getPosicion() {
		return this.posicion;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public Caballo() {
		color = Color.NEGRO;
		posicion = new Posicion(8, 'b');

	}

	public Caballo(Color color) {

		this.color = color;
		if (color == Color.NEGRO) {
			posicion = new Posicion(8, 'b');
		}
		if (color == Color.BLANCO) {
			posicion = new Posicion(1, 'b');
		}
		if (color == null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		}

	}

	public Caballo(Color color, char columna) {
		this.color = color;
		if (columna == 'b' || columna == 'g') {
			if (this.color == Color.BLANCO) {
				posicion = new Posicion(1, columna);
			} else {
				posicion = new Posicion(8, columna);
			}
		} else {
			throw new IllegalArgumentException("ERROR: Columna inicial no válida.");
		}
		if (this.color == null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		}

	}

	public void mover(Direccion direccion) throws OperationNotSupportedException {
		try {

			switch (direccion) {
			case ARRIBA_DERECHA:
				posicion = new Posicion(posicion.getFila() + 2, (char) (posicion.getColumna() + 1));
				break;

			case ARRIBA_IZQUIERDA:
				posicion = new Posicion(posicion.getFila() + 2, (char) (posicion.getColumna() - 1));
				break;

			case DERECHA_ARRIBA:
				// to do
				posicion = new Posicion(posicion.getFila() + 1, (char) (posicion.getColumna() + 2));
				break;

			case DERECHA_ABAJO:
				posicion.setFila(posicion.getFila() - 1);
				posicion.setColumna((char) (posicion.getColumna() + 2));
				break;
			case ABAJO_DERECHA:
				posicion.setFila(posicion.getFila() - 2);
				posicion.setColumna((char) (posicion.getColumna() + 1));
				break;
			case ABAJO_IZQUIERDA:
				posicion = new Posicion(posicion.getFila() - 2, (char) (posicion.getColumna() - 1));
				break;
			case IZQUIERDA_ARRIBA:
				posicion = new Posicion(posicion.getFila() + 1, (char) (posicion.getColumna() - 2));
				break;
			case IZQUIERDA_ABAJO:
				posicion = new Posicion(posicion.getFila() - 1, (char) (posicion.getColumna() - 2));
				break;
			}

		} catch (IllegalArgumentException e) {
			throw new OperationNotSupportedException("ERROR: Movimiento no válido.");
		}

	}

	@Override
	public String toString() {
		return "Caballo [posición=" + posicion + ", color=" + color + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((posicion == null) ? 0 : posicion.hashCode());
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
		Caballo other = (Caballo) obj;
		if (color != other.color)
			return false;
		if (posicion == null) {
			if (other.posicion != null)
				return false;
		} else if (!posicion.equals(other.posicion))
			return false;
		return true;
	}
}

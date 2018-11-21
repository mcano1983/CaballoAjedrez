package org.iesalandalus.programacion.caballoajedrez;

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
public Caballo(Color color, Posicion posicion) {
	Posicion posicionDefectoNegro = new Posicion(8, 'b');
	Posicion posicionDefectoBlanco = new Posicion(1, 'b');
	Posicion posicionNegroG = new Posicion(8, 'g');
	Posicion posicionBlancoG = new Posicion(1, 'g');
}
}
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
 public int setFila(int fila) {
	 if(fila>=1 && fila<=8) {
		 this.fila = fila;
	 }else {
		 throw new IllegalArgumentException(); 
	 }
	 return fila;
	 
 }
 public int setColumna(char columna) {
	 if(columna=='a' || columna=='b' || columna=='c' || columna=='d' || columna=='e' || columna=='f'|| columna=='g'|| columna=='h');
	 this.columna = columna;
	 return columna;
 }

}

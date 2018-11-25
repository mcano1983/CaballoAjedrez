package org.iesalandalus.programacion.caballoajedrez;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	private static Caballo caballo;

	public MainApp() {
		caballo = null;
	}

	public static void main(String[] args) {
		System.out.println("Programa para aprender a colocar y mover un caballo en el tablero de ajedrez");
		mostrarMenu();
	}

	private static void mostrarMenu() {

		int numero = 8;
		do {
			System.out.println("ELIGE UNA OPCIÓN DEL MENÚ");
			System.out.println(
					"1.Crear caballo por defecto \n2.Crear caballo de un color \n3.Crear caballo de un color columna incial valida \n4.Mover caballo \n0.Salir");
			numero = elegirOpcion();
			ejecutarOpcion(numero);
		} while (numero > 4 || numero < 0);
	}

	private static int elegirOpcion() {
		int numero;
		do {
			System.out.println("Elige una opcion del menu");
			numero = Entrada.entero();
		} while (numero < 0 || numero > 4);
		return numero;
	}

	private static void ejecutarOpcion(int numero) {

		switch (numero) {
		case 1:
			crearCaballoDefecto();
			mostrarMenu();
			break;
		case 2:
			crearCaballoDefectoColor();
			mostrarMenu();
			break;
		case 3:
			crearCaballoColorPosicion();
			mostrarMenu();
			break;

		case 4:
			mover();
			mostrarMenu();
			break;
		case 0:
			System.exit(0);
			break;

		}
	}

	private static void crearCaballoDefecto() {

		caballo = new Caballo();
		System.out.println(caballo);
	}

	private static void crearCaballoDefectoColor() {

		Color color = elegirColor();
		caballo = new Caballo(color);
		System.out.println(caballo);
	}

	private static Color elegirColor() {
		Color color = null;
		int numeroColor;
		do {
			System.out.println("Elige un color \n1.Negro \n2.Blanco");
			numeroColor = Entrada.entero();
			if (numeroColor == 1) {
				color = Color.NEGRO;
			}
			if (numeroColor == 2) {
				color = Color.BLANCO;
			}
		} while (numeroColor != 1 && numeroColor != 2);
		return color;
	}

	private static void crearCaballoColorPosicion() {
		Color color = elegirColor();
		char columna = elegirColumnaInicial();
		caballo = new Caballo(color, columna);
		System.out.println(caballo);
	}

	private static char elegirColumnaInicial() {
		char columna;
		do {
			System.out.println("Elige una columna para tu caballo blanco entre:\n.G\n.B");
			columna = Entrada.caracter();
			if (columna == 'g') {
				columna = 'g';
			}
			if (columna == 'b') {
				columna = 'b';
			}
		} while (columna != 'b' && columna != 'g');
		return columna;
	}

	private static void mover() {

		Direccion direccion;
		mostrarMenuDirecciones();
		direccion = elegirDireccion();
		try {
			caballo.mover(direccion);
			System.out.println(caballo);
			mostrarMenu();
		} catch (OperationNotSupportedException e) {
			System.out.println("Movimiento no valido");
		}
	}

	private static void mostrarMenuDirecciones() {

		System.out.println("Elige la opción del movimiento del caballo:");
		System.out.println("1.ARRIBA DERECHA");
		System.out.println("2.ARRIBA IZQUIERDA");
		System.out.println("3.DERECHA ARRIBA");
		System.out.println("4.DERECHA ABAJO");
		System.out.println("5.ABAJO DERECHA");
		System.out.println("6.ABAJO IZQUIERDA");
		System.out.println("7.IZQUIERDA ARRIBA");
		System.out.println("8.IZQUIERDA ABAJO");
	}

	private static Direccion elegirDireccion() {
		int eleccionMenu;
		eleccionMenu = Entrada.entero();
		Direccion direccion;
		direccion = null;
		switch (eleccionMenu) {
		case 1:
			direccion = Direccion.ABAJO_DERECHA;
			break;
		case 2:
			direccion = Direccion.ARRIBA_IZQUIERDA;
			break;
		case 3:
			direccion = Direccion.DERECHA_ARRIBA;
			break;
		case 4:
			direccion = Direccion.DERECHA_ABAJO;
			break;
		case 5:
			direccion = Direccion.ABAJO_DERECHA;
			break;
		case 6:
			direccion = Direccion.ABAJO_IZQUIERDA;
			break;
		case 7:
			direccion = Direccion.IZQUIERDA_ARRIBA;
			break;
		case 8:
			direccion = Direccion.IZQUIERDA_ABAJO;
			break;
		}
		return direccion;
	}
}

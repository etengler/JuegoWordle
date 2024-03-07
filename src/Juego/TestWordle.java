package Juego;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class TestWordle {
	Juego juego= new Juego();
	
	
//	@Test
//	public void testSeleccionarPalabra() {
//		
//	}
	
	
	@Test
	public void testTieneCincoLetras() {
		assertTrue(juego.tieneCincoLetras("casas"));
		assertFalse(juego.tieneCincoLetras("mariposa"));
	}
	
	@Test
	public void testSonIgualesPalabras() {
		assertTrue(juego.sonIgualesPalabras("casas", "casas"));
		assertTrue(juego.sonIgualesPalabras("mariposa", "mariposa"));
		assertFalse(juego.sonIgualesPalabras("casas", "casaz"));
		assertFalse(juego.sonIgualesPalabras("casas", "mariposa"));
		
	}


	@Test
	public void testSonIgualesLetras() {
		assertTrue(juego.sonIgualesLetras('a', 'a'));
		assertFalse(juego.sonIgualesLetras('r', 'z'));
		String palabra1= "casa";
		String palabra2="eese";
		assertTrue(juego.sonIgualesLetras(palabra1.charAt(2), palabra2.charAt(2)));
	}
	

	
	@Test
	public void testContieneLetra() { //ver
		String palabra= "casa";
		char letra='s';
		char letra2='z';
		assertTrue(juego.contieneLetra(letra, palabra));
		assertFalse(juego.contieneLetra(letra2, palabra));
	}
	
	@Test
	public void testSetearColorCelda() {
		assertEquals(3, juego.setearColorCelda("juego", 1, 'u')); //iguales 3, contiene 2, null 1 
		assertEquals(2, juego.setearColorCelda("juego", 3, 'u'));
		assertEquals(1, juego.setearColorCelda("juego", 1, 'z'));
	}
	
	@Test
	public void testUltimoIntento() {
		juego.setIntentos(5);
		assertTrue(juego.ultimoIntento());
		juego.setIntentos(2);
		assertFalse(juego.ultimoIntento());
	}

}

package Juego;

public class Juego {
    ///////////////////////////////////////////////////////////////////////// Variables
	private int intentos;
	private boolean estadoDelJuego;
	private String[] palabrasDelJuego;
	private String palabraArriesgada;
	private String palabraAAdivinar;


	///////////////////////////////////////////////////////////////////////// Consructor////////////////////////
	/////////////////////////////////////////////////////////////////////////   Juego   ///////////////////////
	Juego() {
		this.intentos = 0;
		this.estadoDelJuego = true;
		this.palabrasDelJuego = new String[] { "abajo", "abaco", "abeja", "acero", "adios", "alzar", "ancla", "aorta","araña", "arena", "arbol", "bagre" , "baila", "banco", "beato", "bicho", "bizco", "bocio", "boldo", "borda", "braza", "brisa", "buceo", "bufon", "borax", "bujia", "cable", "caldo", "canta", "caoba", "casco", "cavar", "cazar", "cedro", "censo", "chipa", "ciego", "claro", "coati", "coima", "color", "conde", "coreo", "corto", "crema", "culto", "dalia", "danza", "dedal", "densa","deuda", "disco", "dolar", "dulce", "debil", "dueto", "dorso", "dieta", "edema", "ebrio", "enano", "enojo", "enero", "epico", "exito", "exodo", "falda", "falta", "fango", "fatal", "feliz" , "felpa", "feroz", "ferry", "fideo", "femur", "flama", "fleco", "flota" ,"fobia", "folio", "fresa", "frase", "fuego", "fusil", "gaita","gales", "gorra", "genio", "globo", "girar","grave", "greña", "grifo", "grito", "guiso", "gusto","haber", "habla", "hacha", "hebra", "harto", "helio", "himno", "hindu", "hogar", "hongo", "horno", "hotel", "humus", "hueso", "haber", "heroe","ideal","ingle","iluso","india","idolo","impar","ilion","jabon","jalar","japon","jaula","joven","juego","jurel","justo","jueza","junco","jaque","jalea","jalar","karma","koala","kayak","labio","labor","laico","lapso","largo","larva","latir", "latin", "leche", "legal", "lejos", "leona", "lerdo", "leuda", "libro","libra", "libre","licor","lijar","limbo","lirio","litro","llora","logro","madre","magia","mambo","mamut","manga","mango","medir","melon","menta","mitad","molde","momia","motor","mudar","museo","nadar","niños","naipe","nariz","natal","nieve","ninfa","nopal","notar","niñez","nueve","ñoqui","oasis","ocaso","oeste","oliva","opaco","orden","optar","obeja","opalo","oxido", "pacto","padre" , "paico","papin","parca","parto","peine","penal","pieza", "piojo","placa","plaga", "plata","polen","poste","pulpa","queja","queso","quedo", "quien", "quito","quiza","rabia","radio","rampa","rango","rasca","raspa","recio","recta","reina","reloj","rifle","roble","robot","rombo","rosca","rubor","rugir","rumor","sabio", "sabor","salsa","sauna","secta","sello","señal","sidra","socio","solar","suelo","sutil","tabla","talco","tapon","tauro","techo","telon","tenis","tieso","tifon","tinte","traje","usado","usted","ultra","usado","usual", "vagon","vacio","vapor","vejez","venda","viaje","virus","vodka","video","yacer", "yerba","yogur","yerna", "yunga","zebra","zumba","zurdo" };	
		this.palabraArriesgada = "";
		this.palabraAAdivinar= this.seleccionarPalabra();
	}

		
	//////////////////////////////////////////////////////////////////////// METOODS  /////////////////////////

	public String seleccionarPalabra() { //
		return this.palabrasDelJuego[(int) (Math.random() * (this.palabrasDelJuego.length - 1))]; // retorna una palabra random
																								
	}
	
	public boolean tieneCincoLetras(String palabraAComprobar) { //comprueba si la palabra ingresada tiene 5 letras
		return palabraAComprobar.length() == 5;
	}

	public boolean sonIgualesPalabras(String palabra1, String palagbra2) { // comprueba igualdad de 2 palabras
		return palabra1.equals(palagbra2);
	}

	public boolean sonIgualesLetras(char letra1, char letra2) {//ver
		return letra1 == letra2;
	}
	
	public boolean contieneLetra (char letra, String palabra) {
		return palabra.contains(String.valueOf(letra));
	}
	
	public int setearColorCelda(String palabraAAadivinar,int posicion, char letra1) { //1-gris  2-amarillo  3-verde  
		char letra2=palabraAAadivinar.charAt(posicion);
		if(sonIgualesLetras(letra1, letra2)) {
			return 3;
		}
		if(contieneLetra(letra1, palabraAAadivinar)) {
			return 2;
		}
		else {
			return 1;
		}			
	}
	
	public boolean ultimoIntento() {
		return this.intentos == 5;
	}
		
	
	
	
	
	/////////////////////////////////////////////////////////////// getters y setters ///////////////////////
	public int getIntentos() {
		return intentos;
	}

	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}

	public boolean isEstadoDelJuego() {
		return estadoDelJuego;
	}

	public void setEstadoDelJuego(boolean estadoDelJuego) {
		this.estadoDelJuego = estadoDelJuego;
	}


	public String getPalabraArriesgada() {
		return palabraArriesgada;
	}

	public void setPalabraArriesgada(String palabraArriesgada) {
		this.palabraArriesgada = palabraArriesgada.toLowerCase();
	}


	public String getPalabraAAdivinar() {
		return palabraAAdivinar;
	}


	public void setPalabraAAdivinar(String palabraAAdivinar) {
		this.palabraAAdivinar = palabraAAdivinar;
	}

	
}


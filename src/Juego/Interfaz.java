package Juego;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Font;

public class Interfaz {

	private JFrame frame;
	private JTextField textField;
	private JPanel panel;
	private int valor; // para imprimir letras en grilla
	private int color;
	private JLabel[] arregloCeldas = new JLabel[30];
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interfaz() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		Juego juego = new Juego();

		frame = new JFrame();
		frame.setBounds(100, 100, 529, 298);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Goudy Stout", Font.PLAIN, 15));
		textField.setBounds(64, 107, 105, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setBounds(15, 208, 202, 23);
		frame.getContentPane().add(lblNewLabel_1);
		// lblNewLabel_1.setText(juego.getPalabraAAdivinar());//imprime palabra aa
		// divinar //borrar

		JLabel lblNewLabel_Titulo = new JLabel("<html><p>Juego WORDLE</p></html>");
		lblNewLabel_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Titulo.setFont(new Font("Goudy Stout", Font.PLAIN, 13));
		lblNewLabel_Titulo.setBounds(10, 37, 213, 42);
		frame.getContentPane().add(lblNewLabel_Titulo);

		////////////////////////////////////////////////////////////////////////////////////////// GRILLA
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(227, 11, 274, 239);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(6, 5));

		for (int i = 0; i < arregloCeldas.length; i++) {
			arregloCeldas[i] = new JLabel("");
			arregloCeldas[i].setOpaque(true);
			arregloCeldas[i].setHorizontalAlignment(SwingConstants.CENTER);
			arregloCeldas[i].setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			panel.add(arregloCeldas[i]);
		}

		/////////////////////////////////////////////////////////////////////////////////////// BOTON
		JButton button = new JButton("JUGAR");
		button.setVerticalAlignment(SwingConstants.TOP);
		button.setBackground(new Color(102, 153, 204));
		button.setForeground(new Color(0, 0, 255));
		button.setFont(new Font("Bauhaus 93", Font.PLAIN, 16));
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) { //////////////////////////////////// Accion del boton

				if (juego.isEstadoDelJuego()) { // sino perdiste, podes jugar
					lblNewLabel_1.setText("");// seteo
					String palabra = textField.getText().toLowerCase(); ///// ingreso palabra

					if (!juego.tieneCincoLetras(palabra)) { // si no tiene 5 letras
						// lblNewLabel_1.setText("No es una palabra correcta"); //\n
						lblNewLabel_1.setText("<html><p>No es una palabra correcta</p></html>");
					}

					else { /////////////////// si tiene 5 letras

						juego.setPalabraArriesgada(palabra); ///// guardo palabra arriesagada en el juego

						if (juego.sonIgualesPalabras(juego.getPalabraArriesgada(), juego.getPalabraAAdivinar())) { // si
																													// SON
																													// IGUALES
							setearFila(palabra, juego.getIntentos());
							lblNewLabel_1.setText("¡¡GANASTE!!");
							juego.setEstadoDelJuego(false);

						}

						else { // si NO son iguales

							setearFila(palabra, juego.getIntentos());

							if (juego.ultimoIntento()) {

								juego.setEstadoDelJuego(false);
								lblNewLabel_1.setText("PERDISTE! La palabra era: " + juego.getPalabraAAdivinar());
							

							}
						}
						juego.setIntentos(juego.getIntentos() + 1); // sumo a intentos
					}
					// ver
					textField.setText(""); // seteo el cartel

				}

			}

			public void setearFila(String palabra, int intento) { // setea letra por letra, junto al color que le
																	// corresponde
				if (intento == 0) {
					valor = 0;
				}
				if (intento == 1) {
					valor = 5;
				}
				if (intento == 2) {
					valor = 10;
				}
				if (intento == 3) {
					valor = 15;
				}
				if (intento == 4) {
					valor = 20;
				}
				if (intento == 5) {
					valor = 25;
				}

				for (int i = 0; i < palabra.length(); i++) {
					char letra = palabra.charAt(i);
					String letraString = String.valueOf(letra);
					arregloCeldas[valor].setText(letraString); // seteo letra en posicion

					// SETEAR COLOR
					color = juego.setearColorCelda(juego.getPalabraAAdivinar(), i, letra); // color queda con 1,2 o 3
					arregloCeldas[valor].setBackground(setearColor(color));
					// juego.setearColorCelda(juego.getPalabraAAdivinar(), i, letra); //setea en
					// juego ver

					valor++;
				}
			}

			public Color setearColor(int color) {
				if (color == 1) {
					return Color.gray;
				}
				if (color == 2) {
					return Color.yellow;
				} else {
					return Color.green;
				}
			}

		});

		
		
		
		
		button.setBounds(68, 148, 97, 30);
		frame.getContentPane().add(button);
		
		///////////////////////////////////////////////////////////////////////////////////
	}
}

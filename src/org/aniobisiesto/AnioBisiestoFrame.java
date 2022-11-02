package org.aniobisiesto;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.aniobisiesto.calendario.Gregoriano;
import org.aniobisiesto.calendario.Juliano;
import org.aniobisiesto.utils.MessageBox;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class AnioBisiestoFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtAnioNacimiento;

	Juliano juli = new Juliano();
	Gregoriano grego = new Gregoriano();
	MessageBox alert = new MessageBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnioBisiestoFrame frame = new AnioBisiestoFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame. Builder default constructor with initial parameters
	 */
	public AnioBisiestoFrame() {
		setTitle("Añio Bisiesto - Eclipse IDE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 194);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("es Bisiesto?");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setBounds(103, 15, 106, 26);
		contentPane.add(lblTitulo);

		JLabel lblAnioNacimiento = new JLabel("Ingrese su año de nacimiento:");
		lblAnioNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnioNacimiento.setBounds(20, 58, 195, 26);
		contentPane.add(lblAnioNacimiento);

		txtAnioNacimiento = new JTextField();
		txtAnioNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAnioNacimiento.setBounds(211, 59, 86, 26);
		contentPane.add(txtAnioNacimiento);
		txtAnioNacimiento.setColumns(10);

		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnCalcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtAnioNacimiento.getText().isEmpty()) {
					alert.showMessageDialog(rootPane, "Debe ingresar su año de nacimiento", 0);
				} else if (txtAnioNacimiento.getText().equals("0")) {
					alert.showMessageDialog(rootPane, "El valor ingresado debe ser mayor a cero", 2);

				} else {
					int anio = Integer.parseInt(txtAnioNacimiento.getText());

					if (anio < 1582) {
						if (juli.esJuliano(anio)) {
							alert.showMessageDialog(rootPane, String.format(
									"El año %d ingresado es bisiesto segun " + "el calendario juliano", anio), 1);
						} else {
							alert.showMessageDialog(rootPane, String.format(
									"El año %d ingresado NO es bisiesto segun " + "el calendario juliano", anio), 1);
						}

					} else if (anio >= 1582) {
						if (grego.esGregoriano(anio)) {
							alert.showMessageDialog(rootPane, String.format(
									"El año %d ingresado es bisiesto segun " + "el calendario gregoriano", anio), 1);
						} else {
							alert.showMessageDialog(rootPane, String.format(
									"El año %d ingresado NO es bisiesto segun " + "el calendario gregoriano", anio), 1);
						}
					}
				}
			}
		});
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCalcular.setBounds(103, 109, 106, 23);
		contentPane.add(btnCalcular);
	}
}

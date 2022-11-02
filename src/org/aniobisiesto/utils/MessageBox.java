package org.aniobisiesto.utils;

import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 * Clase para mostrar mensaje personalizado genericos
 * 
 * Valores predeterminados iconos JOptionPane
 * 	JOPtionPane.PLAIN_MESSAGE = -1
 * 	JOPtionPane.ERROR_MESSAGE = 0
 * 	JOPtionPane.INFORMATION_MESSAGE = 1
 * 	JOPtionPane.WARNING_MESSAGE = 2
 * 	JOPtionPane.QUESTION_MESSAGE = 3 
 */

public class MessageBox {
	
	private static final String TITULO = "Año Bisiesto - Eclipse IDE"; 
	
	public void showMessageDialog(JRootPane contentPane, String mensaje, Integer icono) {
		JOptionPane.showMessageDialog(contentPane, mensaje, TITULO, icono);
	}
}

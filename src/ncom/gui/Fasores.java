package ncom.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ncom.Complejo;
import ncom.Fasor;
	
public class Fasores {

	public static JPanel crearPanel() {
		final JPanel panel =new JPanel();
		panel.setLayout(null);
			
		final JLabel lblPrimeraFuncion = new JLabel(Textos.PRIMERA_FUNCION);
		lblPrimeraFuncion.setBounds(10, 15, 160, 15);
		panel.add(lblPrimeraFuncion);
		
		final JTextField amplitudPrimeraFuncion = new JTextField();
		amplitudPrimeraFuncion.setBounds(10, 50, 45, 20);
		panel.add(amplitudPrimeraFuncion);
		amplitudPrimeraFuncion.setColumns(10);
		
		final JLabel lblPrimerPor = new JLabel(Textos.PRODUCTO);
		lblPrimerPor.setBounds(60, 50, 10, 20);
		panel.add(lblPrimerPor);
		
		final JRadioButton radioPrimeraFuncionSeno = new JRadioButton(Textos.SENO);
		radioPrimeraFuncionSeno.setBounds(70, 40, 55, 20);
		radioPrimeraFuncionSeno.doClick();
		panel.add(radioPrimeraFuncionSeno);
		final JRadioButton radioPrimeraFuncionCoseno = new JRadioButton(Textos.COSENO);
		radioPrimeraFuncionCoseno.setBounds(70, 60, 50, 20);
		panel.add(radioPrimeraFuncionCoseno);
		
		final JLabel lblAbreParentesis = new JLabel(Textos.ABRE_PARENTESIS);
		lblAbreParentesis.setBounds(125, 50, 20, 20);
		panel.add(lblAbreParentesis);
		
		final JTextField omegaPrimeraFuncion = new JTextField();
		omegaPrimeraFuncion.setColumns(10);
		omegaPrimeraFuncion.setBounds(135, 50, 35, 20);
		panel.add(omegaPrimeraFuncion);
		
		final JLabel lblPrimerTMas = new JLabel(Textos.T_MAS);
		lblPrimerTMas.setBounds(175, 50, 30, 20);
		panel.add(lblPrimerTMas);

		final JTextField fasePrimeraFuncion = new JTextField();
		fasePrimeraFuncion.setColumns(10);
		fasePrimeraFuncion.setBounds(195, 50, 35, 20);
		panel.add(fasePrimeraFuncion);
		
		final JLabel lblCierraPrimerParentesis = new JLabel(Textos.CIERRA_PARENTESIS);
		lblCierraPrimerParentesis.setBounds(235, 50, 20, 20);
		panel.add(lblCierraPrimerParentesis);
		
		final ButtonGroup radioPrimeraFuncion = new ButtonGroup();    
		radioPrimeraFuncion.add(radioPrimeraFuncionSeno);
		radioPrimeraFuncion.add(radioPrimeraFuncionCoseno);
		
		final JLabel lblSegundaFuncion = new JLabel(Textos.SEGUNDA_FUNCION);
		lblSegundaFuncion.setBounds(10, 105, 160, 15);
		panel.add(lblSegundaFuncion);
		
		final JTextField amplitudSegundaFuncion = new JTextField();
		amplitudSegundaFuncion.setBounds(10, 150, 45, 20);
		panel.add(amplitudSegundaFuncion);
		amplitudSegundaFuncion.setColumns(10);
		
		final JLabel lblSegundoPor = new JLabel(Textos.PRODUCTO);
		lblSegundoPor.setBounds(60, 150, 10, 20);
		panel.add(lblSegundoPor);
		
		final JRadioButton radioSegundaFuncionSeno = new JRadioButton(Textos.SENO);
		radioSegundaFuncionSeno.setBounds(70, 140, 55, 20);
		radioSegundaFuncionSeno.doClick();
		panel.add(radioSegundaFuncionSeno);
		final JRadioButton radioSegundaFuncionCoseno = new JRadioButton(Textos.COSENO);
		radioSegundaFuncionCoseno.setBounds(75, 160, 50, 20);
		panel.add(radioSegundaFuncionCoseno);
		
		final JLabel lblAbreSegundoParentesis = new JLabel(Textos.ABRE_PARENTESIS);
		lblAbreSegundoParentesis.setBounds(125, 150, 20, 20);
		panel.add(lblAbreSegundoParentesis);
		
		final JTextField omegaSegundaFuncion = new JTextField();
		omegaSegundaFuncion.setColumns(10);
		omegaSegundaFuncion.setBounds(135, 150, 35, 20);
		panel.add(omegaSegundaFuncion);
		
		final JLabel lblSegundoTMas = new JLabel(Textos.T_MAS);
		lblSegundoTMas.setBounds(175, 150, 30, 20);
		panel.add(lblSegundoTMas);

		final JTextField faseSegundaFuncion = new JTextField();
		faseSegundaFuncion.setColumns(10);
		faseSegundaFuncion.setBounds(195, 150, 35, 20);
		panel.add(faseSegundaFuncion);
		
		final JLabel lblCierraSegundoParentesis = new JLabel(Textos.CIERRA_PARENTESIS);
		lblCierraSegundoParentesis.setBounds(235, 150, 20, 20);
		panel.add(lblCierraSegundoParentesis);
		
		final ButtonGroup radioSegundaFuncion = new ButtonGroup();    
		radioSegundaFuncion.add(radioSegundaFuncionSeno);
		radioSegundaFuncion.add(radioSegundaFuncionCoseno);
		
		final JButton btnSumar = new JButton(Textos.SUMA);
		btnSumar.setBounds(10, 200, 200, 25);
		panel.add(btnSumar);
		
		final JLabel lblResultado = new JLabel(Textos.RESULTADO);
		lblResultado.setBounds(10, 240, 100, 25);
		panel.add(lblResultado);
		
		final JLabel lblRespuesta = new JLabel();
		lblRespuesta.setBounds(10, 270, 800, 25);
		panel.add(lblRespuesta);
		
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				
				
				
				final Fasor complejoUno = radioPrimeraFuncionSeno.isSelected() ? new Fasor("sen",Double.parseDouble(omegaPrimeraFuncion.getText()),Double.parseDouble(fasePrimeraFuncion.getText()),Double.parseDouble(amplitudPrimeraFuncion.getText())):new Fasor("cos",Double.parseDouble(omegaPrimeraFuncion.getText()),Double.parseDouble(fasePrimeraFuncion.getText()),Double.parseDouble(amplitudPrimeraFuncion.getText())); 
				final Fasor complejoDos = radioSegundaFuncionSeno.isSelected() ? new Fasor("sen",Double.parseDouble(omegaSegundaFuncion.getText()),Double.parseDouble(faseSegundaFuncion.getText()),Double.parseDouble(amplitudSegundaFuncion.getText())):new Fasor("cos",Double.parseDouble(omegaSegundaFuncion.getText()),Double.parseDouble(faseSegundaFuncion.getText()),Double.parseDouble(amplitudSegundaFuncion.getText()));
				if(complejoUno != null && complejoDos != null) {
					lblRespuesta.setText(complejoUno.sumar(complejoDos));
				} else {
					lblRespuesta.setText("ERROR");
				}
				//lblRespuesta.setText("Aqui va la respuesta");
			}
		});
		
		return panel;
	}
	
}

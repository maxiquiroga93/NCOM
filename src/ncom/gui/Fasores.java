package ncom.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
	
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
		radioPrimeraFuncionSeno.setBounds(70, 40, 50, 20);
		radioPrimeraFuncionSeno.doClick();
		panel.add(radioPrimeraFuncionSeno);
		final JRadioButton radioPrimeraFuncionCoseno = new JRadioButton(Textos.COSENO);
		radioPrimeraFuncionCoseno.setBounds(70, 60, 50, 20);
		panel.add(radioPrimeraFuncionCoseno);
		
		final JLabel lblAbreParentesis = new JLabel(Textos.ABRE_PARENTESIS);
		lblAbreParentesis.setBounds(120, 50, 20, 20);
		panel.add(lblAbreParentesis);
		
		final JTextField omegaPrimeraFuncion = new JTextField();
		omegaPrimeraFuncion.setColumns(10);
		omegaPrimeraFuncion.setBounds(130, 50, 35, 20);
		panel.add(omegaPrimeraFuncion);
		
		final JLabel lblPrimerTMas = new JLabel(Textos.T_MAS);
		lblPrimerTMas.setBounds(170, 50, 30, 20);
		panel.add(lblPrimerTMas);

		final JTextField fasePrimeraFuncion = new JTextField();
		fasePrimeraFuncion.setColumns(10);
		fasePrimeraFuncion.setBounds(190, 50, 35, 20);
		panel.add(fasePrimeraFuncion);
		
		final JLabel lblCierraPrimerParentesis = new JLabel(Textos.CIERRA_PARENTESIS);
		lblCierraPrimerParentesis.setBounds(230, 50, 20, 20);
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
		radioSegundaFuncionSeno.setBounds(70, 140, 50, 20);
		radioSegundaFuncionSeno.doClick();
		panel.add(radioSegundaFuncionSeno);
		final JRadioButton radioSegundaFuncionCoseno = new JRadioButton(Textos.COSENO);
		radioSegundaFuncionCoseno.setBounds(70, 160, 50, 20);
		panel.add(radioSegundaFuncionCoseno);
		
		final JLabel lblAbreSegundoParentesis = new JLabel(Textos.ABRE_PARENTESIS);
		lblAbreSegundoParentesis.setBounds(120, 150, 20, 20);
		panel.add(lblAbreSegundoParentesis);
		
		final JTextField omegaSegundaFuncion = new JTextField();
		omegaSegundaFuncion.setColumns(10);
		omegaSegundaFuncion.setBounds(130, 150, 35, 20);
		panel.add(omegaSegundaFuncion);
		
		final JLabel lblSegundoTMas = new JLabel(Textos.T_MAS);
		lblSegundoTMas.setBounds(170, 150, 30, 20);
		panel.add(lblSegundoTMas);

		final JTextField faseSegundaFuncion = new JTextField();
		faseSegundaFuncion.setColumns(10);
		faseSegundaFuncion.setBounds(190, 150, 35, 20);
		panel.add(faseSegundaFuncion);
		
		final JLabel lblCierraSegundoParentesis = new JLabel(Textos.CIERRA_PARENTESIS);
		lblCierraSegundoParentesis.setBounds(230, 150, 20, 20);
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
		lblRespuesta.setBounds(10, 270, 200, 25);
		panel.add(lblRespuesta);
		
		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
//				final Complejo complejoUno = radioPrimerNumeroBinomica.isSelected() ?  crearBinario(textoPrimerNumeroBinomicaReal,textoPrimerNumeroBinomicaImaginaria) : crearPolar(textoPrimerNumeroPolarModulo,textoPrimerNumeroPolarFase);
//				final Complejo complejoDos = radioSegundoNumeroBinomica.isSelected() ?  crearBinario(textoSegundoNumeroBinomicaReal,textoSegundoNumeroBinomicaImaginaria) : crearPolar(textoSegundoNumeroPolarModulo,textoSegundoNumeroPolarFase);
//				if(complejoUno != null && complejoDos != null) {
//					final Complejo suma = complejoUno.sumar(complejoDos);
//					rtaBinomica.setText(suma.aBinario().toString());
//					rtaPolar.setText(suma.aPolar().toString());
//				} else {
//					rtaBinomica.setText("ERROR");
//					rtaPolar.setText("ERROR");
//				}
				lblRespuesta.setText("Aqui va la respuesta");
			}
		});
		
		return panel;
	}
	
}

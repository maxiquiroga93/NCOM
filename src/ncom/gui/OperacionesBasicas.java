package ncom.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ncom.Binario;
import ncom.Complejo;
import ncom.Polar;
	
public class OperacionesBasicas {

	public static JPanel crearPanel() {
		final JPanel panel =new JPanel();
		panel.setLayout(null);
		
		final JLabel lblPrimerOperando = new JLabel(Textos.PRIMER_OPERANDO);
		lblPrimerOperando.setBounds(10, 15, 160, 15);
		panel.add(lblPrimerOperando);

		final JRadioButton radioPrimerNumeroBinomica = new JRadioButton();
		radioPrimerNumeroBinomica.setBounds(10, 40, 20, 20);
		panel.add(radioPrimerNumeroBinomica);
		
		final JTextField textoPrimerNumeroBinomicaReal = new JTextField();
		textoPrimerNumeroBinomicaReal.setBounds(30, 40, 50, 20);
		textoPrimerNumeroBinomicaReal.setColumns(10);
		panel.add(textoPrimerNumeroBinomicaReal);
		
		final JLabel lblMasI1 = new JLabel(Textos.MAS_I);
		lblMasI1.setBounds(85, 40, 20, 20);
		panel.add(lblMasI1);
		
		final JTextField textoPrimerNumeroBinomicaImaginaria = new JTextField();
		textoPrimerNumeroBinomicaImaginaria.setColumns(10);
		textoPrimerNumeroBinomicaImaginaria.setBounds(105, 40, 50, 20);
		panel.add(textoPrimerNumeroBinomicaImaginaria);
		
		final JRadioButton radioPrimerNumeroPolar = new JRadioButton();
		radioPrimerNumeroPolar.setBounds(10, 70, 20, 20);
		panel.add(radioPrimerNumeroPolar);

		final JLabel lblMod1 = new JLabel(Textos.MODULO);
		lblMod1.setBounds(30, 70, 30, 20);
		panel.add(lblMod1);
		
		final JTextField textoPrimerNumeroPolarModulo = new JTextField();
		textoPrimerNumeroPolarModulo.setColumns(10);
		textoPrimerNumeroPolarModulo.setBounds(60, 70, 50, 20);
		panel.add(textoPrimerNumeroPolarModulo);
		
		final JLabel lblFase1 = new JLabel(Textos.FASE);
		lblFase1.setBounds(120, 70, 30, 20);
		panel.add(lblFase1);
		
		final JTextField textoPrimerNumeroPolarFase = new JTextField();
		textoPrimerNumeroPolarFase.setColumns(10);
		textoPrimerNumeroPolarFase.setBounds(150, 70, 50, 20);
		panel.add(textoPrimerNumeroPolarFase);

		final ButtonGroup radioPrimerNumero = new ButtonGroup();    
		radioPrimerNumero.add(radioPrimerNumeroBinomica);
		radioPrimerNumero.add(radioPrimerNumeroPolar);

		final JLabel lblSegundoOperando = new JLabel(Textos.SEGUNDO_OPERANDO);
		lblSegundoOperando.setBounds(10, 115, 160, 15);
		panel.add(lblSegundoOperando);
		
		final JRadioButton radioSegundoNumeroBinomica = new JRadioButton();
		radioSegundoNumeroBinomica.setBounds(10, 140, 20, 20);
		panel.add(radioSegundoNumeroBinomica);
		
		final JTextField textoSegundoNumeroBinomicaReal = new JTextField();
		textoSegundoNumeroBinomicaReal.setColumns(10);
		textoSegundoNumeroBinomicaReal.setBounds(30, 140, 50, 20);
		panel.add(textoSegundoNumeroBinomicaReal);
		
		final JLabel lblMasI2 = new JLabel(Textos.MAS_I);
		lblMasI2.setBounds(85, 140, 20, 20);
		panel.add(lblMasI2);
		
		final JTextField textoSegundoNumeroBinomicaImaginaria = new JTextField();
		textoSegundoNumeroBinomicaImaginaria.setColumns(10);
		textoSegundoNumeroBinomicaImaginaria.setBounds(105, 140, 50, 20);
		panel.add(textoSegundoNumeroBinomicaImaginaria);
		
		final JRadioButton radioSegundoNumeroPolar = new JRadioButton();
		radioSegundoNumeroPolar.setBounds(10, 170, 20, 20);
		panel.add(radioSegundoNumeroPolar);
		
		final JLabel lblMod2 = new JLabel(Textos.MODULO);
		lblMod2.setBounds(30, 170, 30, 20);
		panel.add(lblMod2);
		
		final JTextField textoSegundoNumeroPolarModulo = new JTextField();
		textoSegundoNumeroPolarModulo.setColumns(10);
		textoSegundoNumeroPolarModulo.setBounds(60, 170, 50, 20);
		panel.add(textoSegundoNumeroPolarModulo);
		
		final JLabel lblFase2 = new JLabel(Textos.FASE);
		lblFase2.setBounds(120, 170, 30, 20);
		panel.add(lblFase2);
		
		final JTextField textoSegundoNumeroPolarFase = new JTextField();
		textoSegundoNumeroPolarFase.setColumns(10);
		textoSegundoNumeroPolarFase.setBounds(150, 170, 50, 20);
		panel.add(textoSegundoNumeroPolarFase);
		
		final ButtonGroup radioSegundoNumero = new ButtonGroup();    
		radioSegundoNumero.add(radioSegundoNumeroBinomica);
		radioSegundoNumero.add(radioSegundoNumeroPolar); 
		
		final JButton btnSumar = new JButton(Textos.SUMA);
		btnSumar.setBounds(10, 210, 45, 25);
		panel.add(btnSumar);
		
		final JButton btnRestar = new JButton(Textos.RESTA);
		btnRestar.setBounds(60, 210, 45, 25);
		panel.add(btnRestar);
		
		final JButton btnMultiplicar = new JButton(Textos.PRODUCTO);
		btnMultiplicar.setBounds(110, 210, 45, 25);
		panel.add(btnMultiplicar);
		
		final JButton btnDividir = new JButton(Textos.COCIENTE);
		btnDividir.setBounds(160, 210, 45, 25);
		panel.add(btnDividir);
		
		final JLabel lblResultado = new JLabel(Textos.RESULTADO);
		lblResultado.setBounds(10, 250, 100, 25);
		panel.add(lblResultado);
		
		final JLabel lblBinomica = new JLabel(Textos.BINOMICA);
		lblBinomica.setBounds(10, 280, 70, 25);
		panel.add(lblBinomica);
		
		final JLabel rtaBinomica = new JLabel();
		rtaBinomica.setBounds(80, 280, 100, 25);
		panel.add(rtaBinomica);
		
		final JLabel lblPolar = new JLabel(Textos.POLAR);
		lblPolar.setBounds(10, 310, 70, 25);
		panel.add(lblPolar);
		
		final JLabel rtaPolar = new JLabel();
		rtaPolar.setBounds(80, 310, 100, 25);
		panel.add(rtaPolar);
		
		agregarListenerClickRadio(radioPrimerNumeroBinomica,textoPrimerNumeroBinomicaReal,textoPrimerNumeroBinomicaImaginaria,textoPrimerNumeroPolarModulo,textoPrimerNumeroPolarFase);
		agregarListenerClickRadio(radioPrimerNumeroPolar,textoPrimerNumeroPolarModulo,textoPrimerNumeroPolarFase,textoPrimerNumeroBinomicaReal,textoPrimerNumeroBinomicaImaginaria);
		agregarListenerClickRadio(radioSegundoNumeroBinomica,textoSegundoNumeroBinomicaReal,textoSegundoNumeroBinomicaImaginaria,textoSegundoNumeroPolarModulo,textoSegundoNumeroPolarFase);
		agregarListenerClickRadio(radioSegundoNumeroPolar,textoSegundoNumeroPolarModulo,textoSegundoNumeroPolarFase,textoSegundoNumeroBinomicaReal,textoSegundoNumeroBinomicaImaginaria);

		btnSumar.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				final Complejo complejoUno = radioPrimerNumeroBinomica.isSelected() ?  crearBinario(textoPrimerNumeroBinomicaReal,textoPrimerNumeroBinomicaImaginaria) : crearPolar(textoPrimerNumeroPolarModulo,textoPrimerNumeroPolarFase);
				final Complejo complejoDos = radioSegundoNumeroBinomica.isSelected() ?  crearBinario(textoSegundoNumeroBinomicaReal,textoSegundoNumeroBinomicaImaginaria) : crearPolar(textoSegundoNumeroPolarModulo,textoSegundoNumeroPolarFase);
				if(complejoUno != null && complejoDos != null) {
					final Complejo suma = complejoUno.sumar(complejoDos);
					rtaBinomica.setText(suma.aBinario().toString());
					rtaPolar.setText(suma.aPolar().toString());
				} else {
					rtaBinomica.setText("ERROR");
					rtaPolar.setText("ERROR");
				}
			}
		});
		
		btnRestar.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				final Complejo complejoUno = radioPrimerNumeroBinomica.isSelected() ?  crearBinario(textoPrimerNumeroBinomicaReal,textoPrimerNumeroBinomicaImaginaria) : crearPolar(textoPrimerNumeroPolarModulo,textoPrimerNumeroPolarFase);
				final Complejo complejoDos = radioSegundoNumeroBinomica.isSelected() ?  crearBinario(textoSegundoNumeroBinomicaReal,textoSegundoNumeroBinomicaImaginaria) : crearPolar(textoSegundoNumeroPolarModulo,textoSegundoNumeroPolarFase);
				if(complejoUno != null && complejoDos != null) {
					final Complejo diferencia = complejoUno.restar(complejoDos);
					rtaBinomica.setText(diferencia.aBinario().toString());
					rtaPolar.setText(diferencia.aPolar().toString());
				} else {
					rtaBinomica.setText("ERROR");
					rtaPolar.setText("ERROR");
				}
			}
		});
		
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				final Complejo complejoUno = radioPrimerNumeroBinomica.isSelected() ?  crearBinario(textoPrimerNumeroBinomicaReal,textoPrimerNumeroBinomicaImaginaria) : crearPolar(textoPrimerNumeroPolarModulo,textoPrimerNumeroPolarFase);
				final Complejo complejoDos = radioSegundoNumeroBinomica.isSelected() ?  crearBinario(textoSegundoNumeroBinomicaReal,textoSegundoNumeroBinomicaImaginaria) : crearPolar(textoSegundoNumeroPolarModulo,textoSegundoNumeroPolarFase);
				if(complejoUno != null && complejoDos != null) {
					final Complejo producto = complejoUno.multiplicar(complejoDos);
					rtaBinomica.setText(producto.aBinario().toString());
					rtaPolar.setText(producto.aPolar().toString());
				} else {
					rtaBinomica.setText("ERROR");
					rtaPolar.setText("ERROR");
				}
			}
		});
		
		btnDividir.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				final Complejo complejoUno = radioPrimerNumeroBinomica.isSelected() ?  crearBinario(textoPrimerNumeroBinomicaReal,textoPrimerNumeroBinomicaImaginaria) : crearPolar(textoPrimerNumeroPolarModulo,textoPrimerNumeroPolarFase);
				final Complejo complejoDos = radioSegundoNumeroBinomica.isSelected() ?  crearBinario(textoSegundoNumeroBinomicaReal,textoSegundoNumeroBinomicaImaginaria) : crearPolar(textoSegundoNumeroPolarModulo,textoSegundoNumeroPolarFase);
				if(complejoUno != null && complejoDos != null) {
					final Complejo cociente = complejoUno.dividir(complejoDos);
					if(cociente != null) {
						rtaBinomica.setText(cociente.aBinario().toString());
						rtaPolar.setText(cociente.aPolar().toString());
					} else {
						rtaBinomica.setText("ERROR DIV/0");
						rtaPolar.setText("ERROR DIV/0");
					}
				} else {
					rtaBinomica.setText("ERROR");
					rtaPolar.setText("ERROR");
				}
			}
		});
		
		radioPrimerNumeroBinomica.doClick();
		radioSegundoNumeroBinomica.doClick();
		
		return panel;
	}
	
	private static void agregarListenerClickRadio(final JRadioButton btn, final JTextField textoUnoAHabilitar, final JTextField textoDosAHabilitar, final JTextField textoUnoADeshabilitar, final JTextField textoDosADeshabilitar){
		btn.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(final ActionEvent e) {
	        	textoUnoAHabilitar.setEditable(true);
	        	textoDosAHabilitar.setEditable(true);
	        	textoUnoADeshabilitar.setEditable(false);
	        	textoDosADeshabilitar.setEditable(false);
	        }
	    });
	}
	
	private static Binario crearBinario(final JTextField real, final JTextField imaginario) {
		try{
			final String textoReal = real.getText().trim();
			final String textoImaginario = imaginario.getText().trim();
			final Double parteReal = Double.parseDouble(textoReal.isEmpty() ? "0" : textoReal);
			final Double parteImaginaria = Double.parseDouble(textoImaginario.isEmpty() ? "0" : textoImaginario);
			return new Binario(parteReal, parteImaginaria);
		} catch(final NullPointerException|NumberFormatException e) {
			System.out.println("Error al leer el numero ingresado en forma binomica");
		}
		return null;
	}
	
	private static Polar crearPolar(final JTextField modulo, final JTextField fase) {
		try{
			final String textoModulo = modulo.getText().trim();
			final String textoFase = fase.getText().trim();
			final Double parteModulo = Double.parseDouble(textoModulo.isEmpty() ? "0" : textoModulo);
			final Double parteFase = Double.parseDouble(textoFase.isEmpty() ? "0" : textoFase);
			return new Polar(parteModulo,parteFase);
		} catch(final NullPointerException|NumberFormatException e) {
			System.out.println("Error al leer el numero ingresado en forma polar");
		}
		return null;
	}
	
}

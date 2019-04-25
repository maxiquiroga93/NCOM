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
			
		final JTextField textoPrimerNumeroBinomicaReal = new JTextField();
		textoPrimerNumeroBinomicaReal.setBounds(36, 41, 49, 20);
		panel.add(textoPrimerNumeroBinomicaReal);
		textoPrimerNumeroBinomicaReal.setColumns(10);
		final JRadioButton radioPrimerNumeroBinomica = new JRadioButton("",true);
		radioPrimerNumeroBinomica.setBounds(10, 38, 20, 23);
		panel.add(radioPrimerNumeroBinomica);
		
		final JTextField textoPrimerNumeroPolarFase = new JTextField();
		textoPrimerNumeroPolarFase.setColumns(10);
		textoPrimerNumeroPolarFase.setBounds(150, 72, 86, 20);
		panel.add(textoPrimerNumeroPolarFase);

		final JLabel lblBinomica = new JLabel(Textos.BINOMICA);
		lblBinomica.setBounds(10, 226, 46, 17);
		panel.add(lblBinomica);
		final JTextField rtaBinomica = new JTextField();
		rtaBinomica.setColumns(10);
		rtaBinomica.setBounds(62, 224, 162, 20);
		panel.add(rtaBinomica);

		final JTextField textoPrimerNumeroBinomicaImaginaria = new JTextField();
		textoPrimerNumeroBinomicaImaginaria.setColumns(10);
		textoPrimerNumeroBinomicaImaginaria.setBounds(109, 41, 49, 20);
		panel.add(textoPrimerNumeroBinomicaImaginaria);
		
		final JLabel lblMasI1 = new JLabel(Textos.MAS_I);
		lblMasI1.setBounds(90, 43, 20, 17);
		panel.add(lblMasI1);
		
		final JRadioButton radioPrimerNumeroPolar = new JRadioButton("");
		radioPrimerNumeroPolar.setBounds(10, 72, 20, 23);
		panel.add(radioPrimerNumeroPolar);
		
		final ButtonGroup radioPrimerNumero = new ButtonGroup();    
		radioPrimerNumero.add(radioPrimerNumeroBinomica);
		radioPrimerNumero.add(radioPrimerNumeroPolar);
		
		final JTextField textoPrimerNumeroPolarModulo = new JTextField();
		textoPrimerNumeroPolarModulo.setColumns(10);
		textoPrimerNumeroPolarModulo.setBounds(61, 72, 49, 20);
		panel.add(textoPrimerNumeroPolarModulo);
		
		final JLabel lblPrimerOperando = new JLabel(Textos.PRIMER_OPERANDO);
		lblPrimerOperando.setBounds(10, 14, 89, 14);
		panel.add(lblPrimerOperando);
		
		final JLabel lblMod1 = new JLabel(Textos.MODULO);
		lblMod1.setBounds(36, 72, 38, 23);
		panel.add(lblMod1);
		
		final JLabel lblFase1 = new JLabel(Textos.FASE);
		lblFase1.setBounds(119, 72, 28, 23);
		panel.add(lblFase1);
		
		final JLabel lblSegundoOperando = new JLabel(Textos.SEGUNDO_OPERANDO);
		lblSegundoOperando.setBounds(10, 102, 111, 14);
		panel.add(lblSegundoOperando);
		
		final JRadioButton radioSegundoNumeroBinomica = new JRadioButton("",true);
		radioSegundoNumeroBinomica.setBounds(10, 126, 20, 23);
		panel.add(radioSegundoNumeroBinomica);
		
		final JTextField textoSegundoNumeroBinomicaReal = new JTextField();
		textoSegundoNumeroBinomicaReal.setColumns(10);
		textoSegundoNumeroBinomicaReal.setBounds(36, 129, 49, 20);
		panel.add(textoSegundoNumeroBinomicaReal);
		
		final JLabel lblMasI2 = new JLabel(Textos.MAS_I);
		lblMasI2.setBounds(90, 131, 20, 17);
		panel.add(lblMasI2);
		
		final JTextField textoSegundoNumeroBinomicaImaginaria = new JTextField();
		textoSegundoNumeroBinomicaImaginaria.setColumns(10);
		textoSegundoNumeroBinomicaImaginaria.setBounds(109, 129, 49, 20);
		panel.add(textoSegundoNumeroBinomicaImaginaria);
		
		final JTextField textoSegundoNumeroPolarFase = new JTextField();
		textoSegundoNumeroPolarFase.setColumns(10);
		textoSegundoNumeroPolarFase.setBounds(150, 160, 86, 20);
		panel.add(textoSegundoNumeroPolarFase);
		
		final JLabel lblFase2 = new JLabel(Textos.FASE);
		lblFase2.setBounds(119, 160, 28, 23);
		panel.add(lblFase2);
		
		final JTextField textoSegundoNumeroPolarModulo = new JTextField();
		textoSegundoNumeroPolarModulo.setColumns(10);
		textoSegundoNumeroPolarModulo.setBounds(61, 160, 49, 20);
		panel.add(textoSegundoNumeroPolarModulo);
		
		final JLabel lblMod2 = new JLabel(Textos.MODULO);
		lblMod2.setBounds(36, 160, 38, 23);
		panel.add(lblMod2);
		
		final JRadioButton radioSegundoNumeroPolar = new JRadioButton("");
		radioSegundoNumeroPolar.setBounds(10, 160, 20, 23);
		panel.add(radioSegundoNumeroPolar);
		agregarListenerClickRadio(radioSegundoNumeroBinomica,textoSegundoNumeroBinomicaReal,textoSegundoNumeroBinomicaImaginaria,textoSegundoNumeroPolarModulo,textoSegundoNumeroPolarFase);
		
		final ButtonGroup radioSegundoNumero = new ButtonGroup();    
		radioSegundoNumero.add(radioSegundoNumeroBinomica);
		radioSegundoNumero.add(radioSegundoNumeroPolar); 
		
		final JTextField rtaPolar = new JTextField();
		rtaPolar.setColumns(10);
		rtaPolar.setBounds(62, 249, 162, 20);
		panel.add(rtaPolar);
		
		final JLabel lblPolar = new JLabel(Textos.POLAR);
		lblPolar.setBounds(10, 252, 46, 17);
		panel.add(lblPolar);
		
		agregarListenerClickRadio(radioPrimerNumeroBinomica,textoPrimerNumeroBinomicaReal,textoPrimerNumeroBinomicaImaginaria,textoPrimerNumeroPolarModulo,textoPrimerNumeroPolarFase);
		agregarListenerClickRadio(radioPrimerNumeroPolar,textoPrimerNumeroPolarModulo,textoPrimerNumeroPolarFase,textoPrimerNumeroBinomicaReal,textoPrimerNumeroBinomicaImaginaria);
		agregarListenerClickRadio(radioSegundoNumeroBinomica,textoSegundoNumeroBinomicaReal,textoSegundoNumeroBinomicaImaginaria,textoSegundoNumeroPolarModulo,textoSegundoNumeroPolarFase);
		agregarListenerClickRadio(radioSegundoNumeroPolar,textoSegundoNumeroPolarModulo,textoSegundoNumeroPolarFase,textoSegundoNumeroBinomicaReal,textoSegundoNumeroBinomicaImaginaria);
		
		textoPrimerNumeroPolarModulo.setEditable(false);
		textoPrimerNumeroPolarFase.setEditable(false);
		textoSegundoNumeroPolarModulo.setEditable(false);
		textoSegundoNumeroPolarFase.setEditable(false);
		
		rtaBinomica.setEditable(false);
		rtaPolar.setEditable(false);
		
		final JButton btnSumar = new JButton(Textos.SUMA);
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
		btnSumar.setBounds(10, 190, 46, 23);
		panel.add(btnSumar);
		
		final JButton btnRestar = new JButton(Textos.RESTA);
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
		btnRestar.setBounds(66, 190, 46, 23);
		panel.add(btnRestar);
		
		final JButton btnMultiplicar = new JButton(Textos.PRODUCTO);
		btnMultiplicar.setBounds(122, 190, 46, 23);
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
		panel.add(btnMultiplicar);
		
		final JButton btnDividir = new JButton(Textos.COCIENTE);
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
		btnDividir.setBounds(178, 190, 46, 23);
		panel.add(btnDividir);
		
		return panel;
	}
	
	private static void agregarListenerClickRadio(final JRadioButton btn, final JTextField textoUnoAHabilitar, final JTextField textoDosAHabilitar, final JTextField textoUnoADeshabilitar, final JTextField textoDosADeshabilitar){
		btn.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
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

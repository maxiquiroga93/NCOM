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
	
public class OperacionesAvanzadas {

	public static JPanel crearPanel() {
		final JPanel panel =new JPanel();
		panel.setLayout(null);
			
		final JTextField textoBaseBinomicaReal = new JTextField();
		textoBaseBinomicaReal.setBounds(36, 41, 49, 20);
		panel.add(textoBaseBinomicaReal);
		textoBaseBinomicaReal.setColumns(10);
		final JRadioButton radioBaseBinomica = new JRadioButton("",true);
		radioBaseBinomica.setBounds(10, 38, 20, 23);
		panel.add(radioBaseBinomica);
		
		final JTextField textoBasePolarFase = new JTextField();
		textoBasePolarFase.setColumns(10);
		textoBasePolarFase.setBounds(150, 72, 86, 20);
		panel.add(textoBasePolarFase);

		final JLabel lblBinomica = new JLabel(Textos.BINOMICA);
		lblBinomica.setBounds(10, 226, 46, 17);
		panel.add(lblBinomica);
		final JTextField rtaBinomica = new JTextField();
		rtaBinomica.setColumns(10);
		rtaBinomica.setBounds(62, 224, 162, 20);
		panel.add(rtaBinomica);

		final JTextField textoBaseBinomicaImaginaria = new JTextField();
		textoBaseBinomicaImaginaria.setColumns(10);
		textoBaseBinomicaImaginaria.setBounds(109, 41, 49, 20);
		panel.add(textoBaseBinomicaImaginaria);
		
		final JLabel lblMasI1 = new JLabel(Textos.MAS_I);
		lblMasI1.setBounds(90, 43, 20, 17);
		panel.add(lblMasI1);
		
		final JRadioButton radioBasePolar = new JRadioButton("");
		radioBasePolar.setBounds(10, 72, 20, 23);
		panel.add(radioBasePolar);
		
		final ButtonGroup radioBase = new ButtonGroup();    
		radioBase.add(radioBaseBinomica);
		radioBase.add(radioBasePolar);
		
		final JTextField textoBasePolarModulo = new JTextField();
		textoBasePolarModulo.setColumns(10);
		textoBasePolarModulo.setBounds(61, 72, 49, 20);
		panel.add(textoBasePolarModulo);
		
		final JLabel lblBase = new JLabel(Textos.BASE + Textos.BARRA + Textos.RADICANDO);
		lblBase.setBounds(10, 14, 89, 14);
		panel.add(lblBase);
		
		final JLabel lblModBase = new JLabel(Textos.MODULO);
		lblModBase.setBounds(36, 72, 38, 23);
		panel.add(lblModBase);
		
		final JLabel lblFaseBase = new JLabel(Textos.FASE);
		lblFaseBase.setBounds(119, 72, 28, 23);
		panel.add(lblFaseBase);
		
		final JLabel lblExponente = new JLabel(Textos.EXPONENTE + Textos.BARRA + Textos.INDICE);
		lblExponente.setBounds(10, 102, 111, 14);
		panel.add(lblExponente);
		
		final JTextField textoExponente = new JTextField();
		textoExponente.setColumns(10);
		textoExponente.setBounds(36, 129, 49, 20);
		panel.add(textoExponente);
		
		final JTextField rtaPolar = new JTextField();
		rtaPolar.setColumns(10);
		rtaPolar.setBounds(62, 249, 162, 20);
		panel.add(rtaPolar);
		
		final JLabel lblPolar = new JLabel(Textos.POLAR);
		lblPolar.setBounds(10, 252, 46, 17);
		panel.add(lblPolar);
		
		agregarListenerClickRadio(radioBaseBinomica,textoBaseBinomicaReal,textoBaseBinomicaImaginaria,textoBasePolarModulo,textoBasePolarFase);
		agregarListenerClickRadio(radioBasePolar,textoBasePolarModulo,textoBasePolarFase,textoBaseBinomicaReal,textoBaseBinomicaImaginaria);
		
		textoBasePolarModulo.setEditable(false);
		textoBasePolarFase.setEditable(false);
		
		rtaBinomica.setEditable(false);
		rtaPolar.setEditable(false);
		
		final JButton btnElevar = new JButton(Textos.POTENCIA);
		btnElevar.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				final Complejo base = radioBaseBinomica.isSelected() ?  crearBinario(textoBaseBinomicaReal,textoBaseBinomicaImaginaria) : crearPolar(textoBasePolarModulo,textoBasePolarFase);
				final Integer exponente = parsearEntero(textoExponente);
				if(base != null && exponente != null) {
					final Complejo potencia = base.elevarA(exponente);
					rtaBinomica.setText(potencia.aBinario().toString());
					rtaPolar.setText(potencia.aPolar().toString());
				} else {
					rtaBinomica.setText("ERROR");
					rtaPolar.setText("ERROR");
				}
			}
		});
		btnElevar.setBounds(10, 190, 46, 23);
		panel.add(btnElevar);
		
		final JButton btnRaiz = new JButton(Textos.RAIZ);
		btnRaiz.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				final Complejo radicando = radioBaseBinomica.isSelected() ?  crearBinario(textoBaseBinomicaReal,textoBaseBinomicaImaginaria) : crearPolar(textoBasePolarModulo,textoBasePolarFase);
				final Integer indice = parsearEntero(textoExponente);
				if(radicando != null && indice != null) {
					final Complejo raiz = radicando.raiz(indice);
					if(raiz != null) {
						rtaBinomica.setText(raiz.aBinario().toString());
						rtaPolar.setText(raiz.aPolar().toString());
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
		btnRaiz.setBounds(66, 190, 46, 23);
		panel.add(btnRaiz);
		
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
	
	private static Integer parsearEntero(final JTextField exponente){
		try{
			final String textoExponente = exponente.getText().trim();
			return textoExponente.isEmpty() ? 0 : Integer.parseInt(textoExponente);	
		} catch(final NullPointerException|NumberFormatException e) {
			System.out.println("Error al leer el numero entero ingresado");
		}
		return null;
	}
	
}

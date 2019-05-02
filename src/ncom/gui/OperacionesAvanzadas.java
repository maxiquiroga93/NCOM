package ncom.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
			
		final JLabel lblBase = new JLabel(Textos.BASE + Textos.BARRA + Textos.RADICANDO);
		lblBase.setBounds(10, 15, 160, 15);
		panel.add(lblBase);

		final JRadioButton radioBaseBinomica = new JRadioButton();
		radioBaseBinomica.setBounds(10, 40, 20, 20);
		panel.add(radioBaseBinomica);
		
		final JTextField textoBaseBinomicaReal = new JTextField();
		textoBaseBinomicaReal.setBounds(30, 40, 50, 20);
		textoBaseBinomicaReal.setColumns(10);
		panel.add(textoBaseBinomicaReal);
		
		final JLabel lblMasI = new JLabel(Textos.MAS_I);
		lblMasI.setBounds(85, 40, 20, 20);
		panel.add(lblMasI);
		
		final JTextField textoBaseBinomicaImaginaria = new JTextField();
		textoBaseBinomicaImaginaria.setColumns(10);
		textoBaseBinomicaImaginaria.setBounds(105, 40, 50, 20);
		panel.add(textoBaseBinomicaImaginaria);
		
		final JRadioButton radioBasePolar = new JRadioButton();
		radioBasePolar.setBounds(10, 70, 20, 20);
		panel.add(radioBasePolar);

		final JLabel lblMod = new JLabel(Textos.MODULO);
		lblMod.setBounds(30, 70, 30, 20);
		panel.add(lblMod);
		
		final JTextField textoBasePolarModulo = new JTextField();
		textoBasePolarModulo.setColumns(10);
		textoBasePolarModulo.setBounds(60, 70, 50, 20);
		panel.add(textoBasePolarModulo);
		
		final JLabel lblFase = new JLabel(Textos.FASE);
		lblFase.setBounds(120, 70, 30, 20);
		panel.add(lblFase);
		
		final JTextField textoBasePolarFase = new JTextField();
		textoBasePolarFase.setColumns(10);
		textoBasePolarFase.setBounds(150, 70, 50, 20);
		panel.add(textoBasePolarFase);

		final ButtonGroup radioBase = new ButtonGroup();    
		radioBase.add(radioBaseBinomica);
		radioBase.add(radioBasePolar);

		final JLabel lblExponente = new JLabel(Textos.EXPONENTE + Textos.BARRA + Textos.INDICE);
		lblExponente.setBounds(10, 115, 160, 15);
		panel.add(lblExponente);
		
		final JTextField textoExponente = new JTextField();
		textoExponente.setBounds(30, 140, 50, 20);
		textoExponente.setColumns(10);
		panel.add(textoExponente);
		
		final JButton btnElevar = new JButton(Textos.POTENCIA);
		btnElevar.setBounds(10, 170, 90, 25);
		panel.add(btnElevar);
		
		final JButton btnRaiz = new JButton(Textos.RAIZ);
		btnRaiz.setBounds(105, 170, 90, 25);
		panel.add(btnRaiz);
		
		final JLabel lblResultado = new JLabel(Textos.RESULTADO);
		lblResultado.setBounds(10, 210, 100, 25);
		panel.add(lblResultado);
		
		final JLabel lblBinomica = new JLabel(Textos.BINOMICA);
		lblBinomica.setBounds(10, 240, 70, 25);
		panel.add(lblBinomica);
		
		final JLabel rtaBinomica = new JLabel();
		rtaBinomica.setBounds(80, 240, 100, 25);
		panel.add(rtaBinomica);
		
		final JLabel lblPolar = new JLabel(Textos.POLAR);
		lblPolar.setBounds(10, 270, 70, 25);
		panel.add(lblPolar);
		
		final JLabel rtaPolar = new JLabel();
		rtaPolar.setBounds(80, 270, 100, 25);
		panel.add(rtaPolar);
		
		agregarListenerClickRadio(radioBaseBinomica,textoBaseBinomicaReal,textoBaseBinomicaImaginaria,textoBasePolarModulo,textoBasePolarFase);
		agregarListenerClickRadio(radioBasePolar,textoBasePolarModulo,textoBasePolarFase,textoBaseBinomicaReal,textoBaseBinomicaImaginaria);
		
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
		
		btnRaiz.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				final Complejo radicando = radioBaseBinomica.isSelected() ?  crearBinario(textoBaseBinomicaReal,textoBaseBinomicaImaginaria) : crearPolar(textoBasePolarModulo,textoBasePolarFase);
				final Integer indice = parsearEntero(textoExponente);
				if(radicando != null && indice != null) {
					final ArrayList<Complejo> raiz = radicando.raiz(indice);
					if(raiz != null) {
						//rtaBinomica.setText(raiz.aBinario().toString()); A CORREGIR
						//rtaPolar.setText(raiz.aPolar().toString());
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
		
		radioBaseBinomica.doClick();
		
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

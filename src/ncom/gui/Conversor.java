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
	
public class Conversor {

	public static JPanel crearPanel() {
		final JPanel panel =new JPanel();
		panel.setLayout(null);
			
		final JLabel lblNumeroComplejo = new JLabel(Textos.NUMERO_COMPLEJO);
		lblNumeroComplejo.setBounds(10, 15, 160, 15);
		panel.add(lblNumeroComplejo);

		final JRadioButton radioNumeroComplejoBinomica = new JRadioButton();
		radioNumeroComplejoBinomica.setBounds(10, 40, 20, 20);
		panel.add(radioNumeroComplejoBinomica);
		
		final JTextField textoNumeroComplejoBinomicaReal = new JTextField();
		textoNumeroComplejoBinomicaReal.setBounds(30, 40, 50, 20);
		textoNumeroComplejoBinomicaReal.setColumns(10);
		panel.add(textoNumeroComplejoBinomicaReal);
		
		final JLabel lblMasI = new JLabel(Textos.MAS_I);
		lblMasI.setBounds(85, 40, 20, 20);
		panel.add(lblMasI);
		
		final JTextField textoNumeroComplejoBinomicaImaginaria = new JTextField();
		textoNumeroComplejoBinomicaImaginaria.setColumns(10);
		textoNumeroComplejoBinomicaImaginaria.setBounds(105, 40, 50, 20);
		panel.add(textoNumeroComplejoBinomicaImaginaria);
		
		final JRadioButton radioNumeroComplejoPolar = new JRadioButton();
		radioNumeroComplejoPolar.setBounds(10, 70, 20, 20);
		panel.add(radioNumeroComplejoPolar);

		final JLabel lblMod = new JLabel(Textos.MODULO);
		lblMod.setBounds(30, 70, 60, 20);
		panel.add(lblMod);
		
		final JTextField textoNumeroComplejoPolarModulo = new JTextField();
		textoNumeroComplejoPolarModulo.setColumns(10);
		textoNumeroComplejoPolarModulo.setBounds(85, 70, 50, 20);
		panel.add(textoNumeroComplejoPolarModulo);
		
		final JLabel lblFase = new JLabel(Textos.FASE);
		lblFase.setBounds(140, 70, 45, 20);
		panel.add(lblFase);
		
		final JTextField textoNumeroComplejoPolarFase = new JTextField();
		textoNumeroComplejoPolarFase.setColumns(10);
		textoNumeroComplejoPolarFase.setBounds(180, 70, 50, 20);
		panel.add(textoNumeroComplejoPolarFase);

		final ButtonGroup radioBase = new ButtonGroup();    
		radioBase.add(radioNumeroComplejoBinomica);
		radioBase.add(radioNumeroComplejoPolar);

		final JButton btnConvertir = new JButton(Textos.CONVERTIR);
		btnConvertir.setBounds(10, 115, 200, 25);
		panel.add(btnConvertir);
		
		final JLabel lblResultado = new JLabel(Textos.RESULTADO);
		lblResultado.setBounds(10, 150, 100, 25);
		panel.add(lblResultado);
		
		final JLabel lblBinomica = new JLabel(Textos.BINOMICA);
		lblBinomica.setBounds(10, 180, 70, 25);
		panel.add(lblBinomica);
		
		final JLabel rtaBinomica = new JLabel();
		rtaBinomica.setBounds(80, 180, 800, 25);
		panel.add(rtaBinomica);
		
		final JLabel lblPolar = new JLabel(Textos.POLAR);
		lblPolar.setBounds(10, 210, 70, 25);
		panel.add(lblPolar);
		
		final JLabel rtaPolar = new JLabel();
		rtaPolar.setBounds(80, 210, 800, 25);
		panel.add(rtaPolar);
		
		agregarListenerClickRadio(radioNumeroComplejoBinomica,textoNumeroComplejoBinomicaReal,textoNumeroComplejoBinomicaImaginaria,textoNumeroComplejoPolarModulo,textoNumeroComplejoPolarFase);
		agregarListenerClickRadio(radioNumeroComplejoPolar,textoNumeroComplejoPolarModulo,textoNumeroComplejoPolarFase,textoNumeroComplejoBinomicaReal,textoNumeroComplejoBinomicaImaginaria);
		
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				final Complejo numeroComplejo = radioNumeroComplejoBinomica.isSelected() ?  crearBinario(textoNumeroComplejoBinomicaReal,textoNumeroComplejoBinomicaImaginaria) : crearPolar(textoNumeroComplejoPolarModulo,textoNumeroComplejoPolarFase);
				if(numeroComplejo != null) {
					rtaBinomica.setText(numeroComplejo.aBinario().toString());
					rtaPolar.setText(numeroComplejo.aPolar().toString());
				} else {
					rtaBinomica.setText("ERROR");
					rtaPolar.setText("ERROR");
				}
			}
		});
		
		radioNumeroComplejoBinomica.doClick();
		
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

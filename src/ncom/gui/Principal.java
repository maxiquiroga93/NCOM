package ncom.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Principal {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					final Principal window = new Principal();
					window.frame.setSize(1200, 600);
					window.frame.setVisible(true);
				} catch (final Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(10, 10, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.add(Textos.CONVERTIR,Conversor.crearPanel());
		tabbedPane.add(Textos.OPERACIONES_BASICAS,OperacionesBasicas.crearPanel());
		tabbedPane.add(Textos.OPERACIONES_AVANZADAS,OperacionesAvanzadas.crearPanel());
		tabbedPane.add(Textos.SUMA_FASORES,Fasores.crearPanel());
			
		frame.getContentPane().add(tabbedPane);  
		frame.setSize(415,400);
		frame.setVisible(true);  
	}
	
}
	
package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class frmBusqueda extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmBusqueda frame = new frmBusqueda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmBusqueda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 312, 334);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(10, 11, 276, 39);
		contentPane.add(panel);
		
		JLabel lblBusqueda = new JLabel("Busqueda");
		lblBusqueda.setForeground(Color.WHITE);
		lblBusqueda.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblBusqueda.setBackground(Color.WHITE);
		panel.add(lblBusqueda);
		
		JLabel lblImporteMinimo = new JLabel("Importe Minimo");
		lblImporteMinimo.setBounds(28, 98, 92, 14);
		contentPane.add(lblImporteMinimo);
		
		JLabel lblImporteMaximo = new JLabel("Importe Maximo");
		lblImporteMaximo.setBounds(28, 143, 92, 14);
		contentPane.add(lblImporteMaximo);
		
		JLabel lblConsumoEnergetico = new JLabel("Consumo Energetico");
		lblConsumoEnergetico.setBounds(28, 183, 109, 14);
		contentPane.add(lblConsumoEnergetico);
		
		JSpinner spnMinimo = new JSpinner();
		spnMinimo.setBounds(188, 95, 45, 20);
		contentPane.add(spnMinimo);
		
		JSpinner spnMaximo = new JSpinner();
		spnMaximo.setBounds(188, 140, 45, 17);
		contentPane.add(spnMaximo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(188, 180, 45, 20);
		contentPane.add(comboBox);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(96, 236, 109, 29);
		contentPane.add(btnBuscar);
	}
}

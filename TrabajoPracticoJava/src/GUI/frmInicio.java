package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JButton;

import Data.ElectrodomesticoAdapter;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class frmInicio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnlTabla;
	private JTable tblElectrodomesticos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmInicio frame = new frmInicio();
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
	public frmInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlTitulo = new JPanel();
		pnlTitulo.setBackground(Color.BLACK);
		pnlTitulo.setBounds(5, 5, 728, 60);
		contentPane.add(pnlTitulo);
		
		JLabel lblElectrodomsticos = new JLabel("Electrodom\u00E9sticos");
		lblElectrodomsticos.setHorizontalAlignment(SwingConstants.CENTER);
		lblElectrodomsticos.setForeground(Color.WHITE);
		lblElectrodomsticos.setFont(new Font("Stencil", Font.PLAIN, 35));
		pnlTitulo.add(lblElectrodomsticos);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(44, 76, 89, 23);
		contentPane.add(btnNuevo);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(169, 76, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(292, 76, 89, 23);
		contentPane.add(btnEliminar);
		
		pnlTabla = new JPanel();
		pnlTabla.setBounds(10, 110, 580, 181);
		contentPane.add(pnlTabla);
		
		tblElectrodomesticos = new JTable();
		tblElectrodomesticos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tipo", "Descripcion", "Color", "Consumo", "Peso", "Carga", "Resolucion", "TDT", "Precio"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class, Object.class, Object.class, Float.class, Float.class, Float.class, Boolean.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblElectrodomesticos.getColumnModel().getColumn(1).setPreferredWidth(90);
		tblElectrodomesticos.getColumnModel().getColumn(3).setPreferredWidth(60);
		tblElectrodomesticos.getColumnModel().getColumn(4).setPreferredWidth(60);
		tblElectrodomesticos.getColumnModel().getColumn(7).setPreferredWidth(50);
		tblElectrodomesticos.setPreferredScrollableViewportSize(new Dimension(570, 145));
		JScrollPane scrollPane = new JScrollPane(tblElectrodomesticos);
		pnlTabla.add(scrollPane, BorderLayout.CENTER);
		
		cargarDatos();
	}

	private void cargarDatos() {
	}
}

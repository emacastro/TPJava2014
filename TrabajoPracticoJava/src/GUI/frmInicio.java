package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;

import Entidades.*;
import Negocio.*;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;

public class frmInicio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnlTabla;
	private JTable tblElectrodomesticos;
	private DefaultTableModel model;//probando modelo
	private ArrayList<Electrodomestico> lista;//probando arraylist

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
		btnNuevo.setBounds(627, 105, 89, 23);
		contentPane.add(btnNuevo);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(627, 139, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(627, 173, 89, 23);
		contentPane.add(btnEliminar);
		
		pnlTabla = new JPanel();
		pnlTabla.setBounds(15, 76, 582, 215);
		contentPane.add(pnlTabla);
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers(new Object[] {
				"Tipo", "Descripcion", "Color", "Consumo", "Peso", "Carga", "Resolucion", "TDT", "Precio"
			});
		
		
		JButton btnBusqueda = new JButton("Busqueda");
		btnBusqueda.setBounds(627, 207, 89, 23);
		contentPane.add(btnBusqueda);
		
		cargarDatos();
	}

	private void cargarDatos() {
		model.setNumRows(0);
	    lista = new ArrayList<Electrodomestico>();
	    NegElectrodomestico elec = new NegElectrodomestico();
	    lista = elec.listarElectrodomesticos();
	    
	    for (Iterator<Electrodomestico> it = lista.iterator(); it.hasNext();) {
	    
	        Electrodomestico e = (Electrodomestico) it.next();
	        model.addRow(new Object[]{
	            e.getId(),null,e.getColor().getColor(),e.getConsumo().getConsumo(),e.getPrecioBase(),null,null
	        });
	    }
	    
	    tblElectrodomesticos = new JTable(model);
	    /*tblElectrodomesticos.getColumnModel().getColumn(1).setPreferredWidth(90);
		tblElectrodomesticos.getColumnModel().getColumn(3).setPreferredWidth(60);
		tblElectrodomesticos.getColumnModel().getColumn(4).setPreferredWidth(60);
		tblElectrodomesticos.getColumnModel().getColumn(7).setPreferredWidth(50);
		tblElectrodomesticos.setPreferredScrollableViewportSize(new Dimension(575, 180));*/
	    
		JScrollPane scrollPane = new JScrollPane(tblElectrodomesticos);
		scrollPane.setBounds(10, 11, 456, 104);
		pnlTabla.add(scrollPane);
		
	}
	
}
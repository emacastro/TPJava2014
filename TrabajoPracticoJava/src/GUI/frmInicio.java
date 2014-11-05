package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmInicio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultTableModel model;
	private ArrayList<Electrodomestico> elecs;
	private JTable table;

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
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmNuevo formNuevo = new frmNuevo();
				formNuevo.setVisible(true);
			}
		});
		btnNuevo.setBounds(627, 105, 106, 23);
		contentPane.add(btnNuevo);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			int row = table.getSelectedRow();
				if(row < 0){
					JOptionPane.showMessageDialog(null,"Debe Elegir un Articulo");
					}
					else{
						String id= table.getValueAt(row, 0).toString();
						String tipo = table.getValueAt(row, 1).toString();
						elecs = (new NegElectrodomestico()).listarElectrodomesticos();
						Electrodomestico el = null;
						for (int i = 0; i < elecs.size(); i++) {
							if(elecs.get(i).getId()==Integer.parseInt(id))
							{
								el=elecs.get(i);
							}
						}
						frmModificar formModificar = new frmModificar(el);
						formModificar.setVisible(true);
					}
			}
		});
		btnModificar.setBounds(627, 139, 106, 23);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				if(row < 0){
					JOptionPane.showMessageDialog(null,"Debe Elegir un Articulo");
					}
					else{
						String id= table.getValueAt(row, 0).toString();
						NegElectrodomestico ne = new NegElectrodomestico();
						ne.eliminarElectrodomestico(Integer.parseInt(id));
						DefaultTableModel modelo = (DefaultTableModel)table.getModel(); 
						modelo.removeRow(row);
					}
			}
		});
		btnEliminar.setBounds(627, 173, 106, 23);
		contentPane.add(btnEliminar);
		
		
		JButton btnBusqueda = new JButton("Busqueda");
		btnBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmBusqueda formBusqueda = new frmBusqueda();
				formBusqueda.setVisible(true);
			}
		});
		btnBusqueda.setBounds(627, 207, 106, 23);
		contentPane.add(btnBusqueda);
		
		model = new DefaultTableModel();
		model.setColumnCount(9);
		model.setColumnIdentifiers(new Object[] {
				"Id", "Tipo", "Color", "Consumo", "Peso", "Carga", "Resolucion", "TDT", "Precio"
			});
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 89, 566, 182);
		contentPane.add(scrollPane);
		
		table = new JTable(model);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(table);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(627, 241, 106, 23);
		contentPane.add(btnSalir);
		
		cargarDatos();
	}

	private void cargarDatos() {
		model.setNumRows(0);
		elecs = (new NegElectrodomestico()).listarElectrodomesticos();
		for (Electrodomestico e : elecs) {
			if (e instanceof Lavarropas){
	        model.addRow(new Object[]{
	        		e.getId(),e.getClass().getSimpleName(),e.getColor().getColor(),e.getConsumo().getConsumo(),e.getPeso(),((Lavarropas) e).getCarga(),null,null,e.getPrecioBase()
	        	});
			}
			else {
				model.addRow(new Object[]{
		        		e.getId(),e.getClass().getSimpleName(),e.getColor().getColor(),e.getConsumo().getConsumo(),e.getPeso(),null,((Television) e).getResolucion(),((Television) e).isSintonizador(),e.getPrecioBase()
		        	});
			}
	    	}
	    }
}
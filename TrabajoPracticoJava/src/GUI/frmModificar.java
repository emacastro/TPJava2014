package GUI;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Entidades.*;
import Negocio.*;

public class frmModificar extends JFrame {
	
	private JTextField txtPrecio;
	private JTextField txtPeso;
	private JLabel lblPrecio;
	private JLabel lblPeso;
	private JLabel lblConsumo;
	private JLabel lblColor;
	private JButton btnGuardar;
	private JButton btnCancelar;
	
	private JComboBox cbxTipo;
	private JLabel lblResolucion;
	private JLabel lblTdt;
	private JTextField txtResolucion;
	private JRadioButton rbtFalse;
	private JRadioButton rbtTrue;
	private JTextField txtCarga;
	private JLabel lblCarga;
	private ButtonGroup botones = new ButtonGroup();
	
	private JComboBox cbxColor;
	private JComboBox cbxConsumo;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmModificar frame = new frmModificar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public frmModificar(final Electrodomestico elec) {
		setTitle("Modificar Electrodomestico");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 487, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		JLabel lblTipoDeElectrodomestico = new JLabel("Tipo de Electrodomestico:");
		lblTipoDeElectrodomestico.setBounds(10, 39, 166, 14);
		lblTipoDeElectrodomestico.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblTipoDeElectrodomestico);
		
		cbxTipo = new JComboBox();
		cbxTipo.setBounds(205, 34, 127, 25);
		cbxTipo.setModel(new DefaultComboBoxModel(new String[] {"Lavarropa", "Televisor"}));
		if (elec instanceof Lavarropas)
		{
			cbxTipo.setSelectedItem("Lavarropa");
		}
		else
		{
			cbxTipo.setSelectedItem("Televisor");
		}
		cbxTipo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					if (cbxTipo.getSelectedIndex() == 0) // Muestra los controles que se pueden usar si se selecciona la opcion Lavarropa
					{
						agregarElectrodomestico();
						agregarLavarropa();
					}
					else // Muestra los controles que se pueden usar si se selecciona la opcion Televisor
					{
						agregarElectrodomestico();
						agregarTelevisor();
					}
			}
		});
		cbxTipo.setToolTipText("");
		contentPane.add(cbxTipo);
	
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(130, 89, 46, 14);
		lblPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblPrecio);
		lblPrecio.setVisible(false);
		
		lblColor = new JLabel("Color:");
		lblColor.setBounds(130, 171, 46, 14);
		lblColor.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblColor);
     	lblColor.setVisible(false);
		
		lblConsumo = new JLabel("Consumo:");
		lblConsumo.setBounds(94, 211, 83, 14);
		lblConsumo.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblConsumo);
		lblConsumo.setVisible(false);
		
		lblPeso = new JLabel("Peso:");
		lblPeso.setBounds(130, 129, 46, 14);
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblPeso);
		lblPeso.setVisible(false);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(205, 84, 200, 25);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		txtPrecio.setText(String.valueOf(elec.getPrecioBase()));
		txtPrecio.setVisible(false);
		
		txtPeso = new JTextField();
		txtPeso.setBounds(205, 124, 200, 25);
		txtPeso.setColumns(10);
		contentPane.add(txtPeso);
		txtPeso.setText(String.valueOf(elec.getPeso()));
		txtPeso.setVisible(false);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(205, 378, 89, 23);
		btnGuardar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				elec.setPrecioBase(Double.parseDouble(txtPrecio.getText()));
				ConsumoEnergetico consumo = new ConsumoEnergetico((cbxConsumo.getSelectedItem().toString()).charAt(0));
				elec.setConsumo(consumo);
				elec.setPeso(Double.parseDouble(txtPeso.getText()));
				NegElectrodomestico ne = new NegElectrodomestico();
				if (elec instanceof Lavarropas)
				{
				((Lavarropas) elec).setCarga(Double.parseDouble(txtCarga.getText()));
				ne.modificarElectrodomestico(elec, "lavarropas");
				}
				else
				{
				((Television) elec).setResolucion(Integer.parseInt(txtResolucion.getText()));
				((Television) elec).setSintonizador(rbtTrue.isSelected());
				ne.modificarElectrodomestico(elec, "television");
				}
				JOptionPane.showMessageDialog(null, "Electrodomestico modificado", "Información", JOptionPane.INFORMATION_MESSAGE);	
			}
		});
		contentPane.add(btnGuardar);
		btnGuardar.setVisible(false);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(316, 378, 89, 23);
		btnCancelar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int i = JOptionPane.showConfirmDialog(null,"¿Desea Cancelar?","Cancelación",JOptionPane.YES_NO_OPTION);  
				if(i==0){
				dispose();
				}								
			}
		});
		contentPane.add(btnCancelar);
		btnCancelar.setVisible(true);
		
		lblResolucion = new JLabel("Resolucion:");
		lblResolucion.setBounds(94, 291, 82, 14);
		lblResolucion.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblResolucion);
		lblResolucion.setVisible(false);
		
		lblTdt = new JLabel("TDT:");
		lblTdt.setBounds(130, 339, 46, 14);
		lblTdt.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblTdt);
		lblTdt.setVisible(false);
		
		txtResolucion = new JTextField();
		txtResolucion.setBounds(205, 286, 200, 25);
		txtResolucion.addKeyListener(new KeyAdapter() {			
			public void keyTyped(KeyEvent evt) {
				char car = evt.getKeyChar();
				if((car<'0' || car>'9')) evt.consume();
			} // Valida que solo ingrese valores entre 0 y 9
		});
		contentPane.add(txtResolucion);
		txtResolucion.setColumns(10);
		txtResolucion.setVisible(false);
		
		rbtTrue = new JRadioButton("True");
		rbtTrue.setBounds(227, 335, 67, 23);
		contentPane.add(rbtTrue);
		rbtTrue.setVisible(false);
		
		rbtFalse = new JRadioButton("False");
		rbtFalse.setBounds(297, 335, 59, 23);
		contentPane.add(rbtFalse);
		rbtFalse.setVisible(false);
		
		botones.add(rbtTrue);
		botones.add(rbtFalse);
		
		txtCarga = new JTextField();
		txtCarga.setBounds(205, 243, 200, 25);
		contentPane.add(txtCarga);
		txtCarga.setColumns(10);
		txtCarga.setVisible(false);
		
		lblCarga = new JLabel("Carga:");
		lblCarga.setBounds(94, 248, 82, 14);
		lblCarga.setHorizontalAlignment(SwingConstants.RIGHT);
		contentPane.add(lblCarga);
		lblCarga.setVisible(false);
		
		cbxColor = new JComboBox(Color.getColores()); //Mostrar los datos desde la bd?
		cbxColor.setBounds(205, 167, 200, 25);
		contentPane.add(cbxColor);
		cbxColor.setSelectedItem(elec.getColor().getColor());
		cbxColor.setVisible(false);
		
		String cons= String.valueOf(ConsumoEnergetico.getTipos()); //idem
		String[] consumos = cons.split("");
		cbxConsumo = new JComboBox(consumos);
		cbxConsumo.setBounds(205, 206, 200, 25);
		contentPane.add(cbxConsumo);
		cbxConsumo.setSelectedItem(elec.getConsumo().getConsumo());
		cbxConsumo.setVisible(false);
		
		datosDeElec(elec);
	}

	public void agregarElectrodomestico()
	{
		lblPrecio.setVisible(true);
		lblPeso.setVisible(true);
		lblConsumo.setVisible(true);
		lblColor.setVisible(true);
		
		txtPrecio.setVisible(true);
		txtPeso.setVisible(true);
		
		btnGuardar.setVisible(true);
		
		cbxColor.setVisible(true);
		cbxConsumo.setVisible(true);
	}
	
	public void agregarTelevisor()
	{
		txtCarga.setVisible(false);
		lblCarga.setVisible(false);
		
		lblResolucion.setVisible(true);
		lblTdt.setVisible(true);
		txtResolucion.setVisible(true);
		rbtTrue.setVisible(true);
		rbtFalse.setVisible(true);		
	}
	
	public void agregarLavarropa()
	{
		
		lblResolucion.setVisible(false);
		lblTdt.setVisible(false);
		txtResolucion.setVisible(false);
		rbtTrue.setVisible(false);
		rbtFalse.setVisible(false);
		
		txtCarga.setVisible(true);
		lblCarga.setVisible(true);
	}
	
	public void datosDeElec(Electrodomestico el)
	{
		if(el instanceof Lavarropas)
		{
			txtCarga.setText(String.valueOf(((Lavarropas) el).getCarga()));
			txtResolucion.setText("0");
		}
		else
		{
			txtResolucion.setText(String.valueOf(((Television)el).getResolucion()));
			if (((Television) el).isSintonizador())
			{
				rbtTrue.setSelected(true);
			}
			else {
				rbtFalse.setSelected(true);
			}
			txtCarga.setText("0");
		}
	}
	
}

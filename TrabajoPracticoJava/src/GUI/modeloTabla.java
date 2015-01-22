package GUI;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import Entidades.*;
import Entidades.Lavarropas;
import Entidades.Television;
import Negocio.NegElectrodomestico;

public class modeloTabla implements TableModel {

	private ArrayList<Electrodomestico> elec;
	private String[] columnas = {"Id", "Tipo", "Color", "Consumo", "Peso", "Carga", "Resolucion", "TDT", "Precio"};
	private LinkedList listeners = new LinkedList();
	
	public modeloTabla (ArrayList<Electrodomestico> listado)
	{
		this.elec = listado;
	}
	
	
	public ArrayList<Electrodomestico> getElecs() {
		return elec;
	}

	public void setElecs(ArrayList<Electrodomestico> elecs) {
		this.elec = elecs;
	}


	@Override
	public int getColumnCount() {
		return columnas.length;
	}
	
	@Override
	public String getColumnName(int columnIndex) {
		return columnas[columnIndex];
	}

	@Override
	public int getRowCount() {
		if (elec==null) {
			return 0;
		}
		return elec.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Electrodomestico eAct = elec.get(rowIndex);
		Object e;
		switch (columnIndex) {
		case 0:
			e = eAct.getId();
			break;
		case 1:
			e = eAct.getClass().getSimpleName();
			break;
		case 2:
			e = eAct.getColor().getColor();
			break;
		case 3:
			e = eAct.getConsumo().getConsumo();
			break;
		case 4:
			e = eAct.getPeso();
			break;
		case 5:
			if (eAct instanceof Lavarropas) {
				e = ((Lavarropas) eAct).getCarga();
			}
			else
			{
				e = "";
			}
			break;
		case 6:
			if(eAct instanceof Television) {
				e = ((Television) eAct).getResolucion();
			}
			else
			{
				e = "";
			}
			break;
		case 7:
			if (eAct instanceof Television) {
				e = ((Television) eAct).isSintonizador();	
			}
			else
			{
				e = false;
			}
			break;
		case 8:
			e = eAct.getPrecioBase();
			break;
		default:
			e = null;
			break;
		}
		return e;
	}

	@Override
	public boolean isCellEditable(int row, int column) {
	      return false;
	   }
	
	@Override
	public Class getColumnClass(int column) {
        return getValueAt(1, column).getClass();
    }

	public void borraFila (int row, String id) {
		NegElectrodomestico ne = new NegElectrodomestico();
		ne.eliminarElectrodomestico(Integer.parseInt(id));
		elec.remove(row);
		TableModelEvent evento = new TableModelEvent(this, row, row, TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
		aviso(evento);
	}
	
	public void nuevaFila (Electrodomestico el)
	{
		elec.add(el);
		TableModelEvent evento;
		evento = new TableModelEvent(this, this.getRowCount()-1, this.getRowCount()-1, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		aviso(evento);
	}


	@Override
	public void addTableModelListener(TableModelListener l) {
		listeners.add(l);
	}


	@Override
	public void removeTableModelListener(TableModelListener l) {
		listeners.remove(l);
	}


	@Override
	public void setValueAt(Object value, int row, int column) {
		// TODO Auto-generated method stub
		Electrodomestico elecAct;
		elecAct = (Electrodomestico)(elec.get(row));
		switch(column)
		{
		case 0://ID
			elecAct.setId(((Integer)value).intValue());
			break;
		case 1://Class
			
			break;
		case 2://Color
			elecAct.setColor(new Color((String)value));
			break;
		case 3://Consumo
			elecAct.setConsumo(new ConsumoEnergetico((char)value));
			break;
		case 4://Peso
			elecAct.setPeso((double)value);
			break;
		case 5://Carga (Lavarropas)
			((Lavarropas)elecAct).setCarga((double)value);;
			break;
		case 6://Resolucion (Televisor)
			((Television)elecAct).setResolucion(((Integer)value).intValue());
			break;
		case 7://Sintonizador (Televisor)
			((Television)elecAct).setSintonizador((boolean)value);
			break;
		case 8://Precio
			elecAct.setPrecioBase((double)value);
			break;
		default:
			break;
		}
		TableModelEvent evento = new TableModelEvent(this, row, row, column);
		aviso(evento);
	}

	public void aviso (TableModelEvent evento)
	{
		for (int i = 0; i < listeners.size(); i++) {
			((TableModelListener)listeners.get(i)).tableChanged(evento);
		}
	}
}

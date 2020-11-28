package com.presentation;

import javax.swing.table.AbstractTableModel;

public class ModeloActividad extends AbstractTableModel{
	
	private String[] columnNames;
	private Object[][] data;

	public ModeloActividad(String[] columnNames, Object[][] data) {
		super();
		this.columnNames = columnNames;
		this.data = data;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
	
	/*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 4) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
    	data[row][col] = value;
        fireTableCellUpdated(row, col);
    }

	public void setDatos(Object[][] data) {
		this.data = data;
	}

	public void refresh() {
		this.fireTableDataChanged();
	}

}

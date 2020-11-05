package com.presentation;

import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel {
	
	private String[] columnNames;
	private Object[][] data;

	public ModeloTabla(String[] columnNames, Object[][] data) {
		super();
		this.columnNames = columnNames;
		this.data = data;
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}
	
	public void setData(Object[][] data) {
		this.data = data;
	}
	
	public void refresh() {
		this.fireTableDataChanged();
	}
	
}

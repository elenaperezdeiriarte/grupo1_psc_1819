package LNProyecto;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import org.apache.log4j.Logger;

	public class TableSugerencias extends AbstractTableModel
	{
			private static final long serialVersionUID = 1L;
			private String[] columnNames = {"Tipo", "Nombre", "Autor"};
			Object [][] data;
			private static final Logger log = Logger.getLogger(TableSugerencias.class.getName());
			
			public TableSugerencias(ArrayList<ClsSugerencias> a){
				
		
				super();
	        	
	    		int filas = a.size();
	    		int cont;
	    		data=new Object[filas][];
	    		cont=0;
	    		
	    		
	    		
	    		for (ClsSugerencias b : a)
	    		{			
	    			Object[]c={	new String(b.getTipo()),
	    						new String(b.getNombre()),
	    						new String(b.getAutor()),
	    						};
	    			
	    			data[cont]=c;
	    			cont++;
	    		}
			}
	    		
	    		  
	       public void setData(ArrayList<ClsSugerencias> m) {
	    	   
	    	   int filas = m.size();
	    		int cont;
	    		data=new Object[filas][];
	    		cont=0;
	    		
	    		
	    		
	    		for (ClsSugerencias b : m)
	    		{			
	    			Object[]c={	new String(b.getTipo()),
	    						new String(b.getNombre()),
	    						new String(b.getAutor()),
	    						};
	    			
	    			data[cont]=c;
	    			cont++;
	    		}
	       }
	            

			
	       
			public int getRowCount() {
				
				return data.length;
			}

			
			public int getColumnCount() {
				
				return columnNames.length;
			}
			
			public String getColumnName(int col){
				
				return columnNames[col];
			}

			
			public Object getValueAt(int row, int col) {
				
				return data[row][col];
			}
			
			public boolean isCellEditable (int row, int col){
				
				return false;
			}
			
		}
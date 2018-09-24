package LNProyecto;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

	public class TableSugrencias extends AbstractTableModel
	{
			private static final long serialVersionUID = 1L;
			private String[] columnNames = {"Tipo", "Nombre", "Autor"};
			Object [][] data;
			
			public TableSugrencias(ArrayList<ClsSugerencias> a){
				
		
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
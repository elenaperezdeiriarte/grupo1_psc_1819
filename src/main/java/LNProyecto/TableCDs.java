package LNProyecto;

//Esta tabla recoge todos los cds guardados
//los usuarios son los que introducen los cs

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

	public class TableCDs extends AbstractTableModel
	{
			private static final long serialVersionUID = 1L;
			private String[] columnNames = {"Num","Nombre","Autor","Nota","Estado","Num. Pre."};
			Object [][] data;
			
			public TableCDs(ArrayList<ClsCD> a){
				
		
				super();
	        	
	    		int filas = a.size();
	    		int cont;
	    		data=new Object[filas][];
	    		cont=0;
	    		
	    		
	    		
	    		for (ClsArticulo b : a)
	    		{
	    			String estado = "";
	    			    						
	    			if(b.getEstado()==1)
	    			estado="Prestado";
	    			else
	    			estado="Disponible";
	    			
	    			DecimalFormat formateador = new DecimalFormat("##.##");
	    			String nota = formateador.format(b.getNota());
	    						
	    			Object[]c={
	    						new Integer(b.getNumero()),
	    						new String(b.getNombre()),
	    						new String(b.getAutor()),
	    						new String(nota),
	    						new String(estado),
	    						new Integer(b.getContador()),
	    						};
	    			data[cont]=c;
	    			cont++;
	    		}
			}
	    		
	    		  
	       public void setData(ArrayList<ClsArticulo> m) {
	    	   
	            	int filas = m.size();
	        		int cont;
	        		data=new Object[filas][];
	        		cont=0;
	        		
	        			
	        		
	        		for (ClsArticulo b : m)
	        		{
	        			String estado = "";
						
		    			if(b.getEstado()==1)
		    			estado="Prestado";
		    			else
		    			estado="Disponible";
		    			
		    			String tipo = "";
		    			
		    			switch(b.getTipo())
		    			{
		    			case 0: tipo = "CD";	break;
		    			case 1: tipo = "DVD";	break;
		    			case 2: tipo = "Libro";	break;
		    			}
		    						
		    			Object[]c={
		    						new Integer(b.getNumero()),
		    						new String(tipo),
		    						new String(b.getNombre()),
		    						new String(b.getAutor()),
		    						new Double(b.getNota()),
		    						new String(estado),
		    						new Integer(b.getContador()),
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
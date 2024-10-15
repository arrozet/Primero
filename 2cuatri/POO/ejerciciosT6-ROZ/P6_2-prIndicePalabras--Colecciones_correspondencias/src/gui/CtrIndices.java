package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;

import indices.*;

public class CtrIndices implements ActionListener{
	 private VistaIndices panel;
	 private Indice indice;

	    public CtrIndices(VistaIndices vIn) {
	    	panel = vIn;
	    	
	    }
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			switch (e.getActionCommand()) {
				case VistaIndices.CREAR: {
					String opcion = panel.opcion();
					String delimitadores = panel.delimitadores();
					
					if(delimitadores.length()==0) {
						delimitadores = "[ .,:;\\\\-\\\\!\\\\¡\\\\¿\\\\?]+";
					}
					
					switch(opcion) {
						case VistaIndices.INDICEC: {
							indice = new IndiceContador();
							break;
						}
						case VistaIndices.INDICEL: {
							indice = new IndiceLineas();
							break;
						}
						case VistaIndices.INDICEP: {
							indice = new IndicePosicionesEnLineas();
							break;
						}
					}
					
					
					for(String linea: panel.listaTexto()) {
						indice.agregarFrase(linea);
						
					}
					
					indice.resolver(delimitadores);
					panel.salida(presentarSalida());
				}
				
			}
		} catch (Exception e2) {
			System.err.println("ERROR" + e2.getMessage());
		}
		
	}
	
	private String presentarSalida(){
		StringWriter sw = new StringWriter();
		try(PrintWriter pw = new PrintWriter(sw)){
			indice.presentarIndice(pw);
		}
		return sw.toString();
	}
	
}

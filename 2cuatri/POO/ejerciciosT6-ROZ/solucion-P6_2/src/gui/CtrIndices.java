package gui;

import indices.Indice;
import indices.IndiceContador;
import indices.IndiceLineas;
import indices.IndicePosicionesEnLineas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.PrintWriter;
import java.io.StringWriter;

public class CtrIndices implements ActionListener {
	private static final String DEF_DELIM = "[ .,:;\\-\\!\\!\\?\\?]+";
    private VistaIndices panel;
	private Indice indice;

    public CtrIndices(VistaIndices p) {
        panel = p;
		// el indice se creara cuando se reciba el evento de crear
    }

    public void actionPerformed(ActionEvent event) {
		try {
			String comando = event.getActionCommand();
			switch (comando) {
			case VistaIndices.CREAR: crear(); break;
			default: throw new RuntimeException("Opcion ["+comando+"] no reconocida");
			}
		} catch (Exception ex) {
			//panel.error("Error: "+ex.getMessage());
			panel.salida("Error: "+ex.getMessage());
		}
    }
	private void crear() {
		String opcion = panel.opcion();
		switch (opcion) {
		case VistaIndices.INDICEC: indice = new IndiceContador(); 			break;
		case VistaIndices.INDICEL: indice = new IndiceLineas();				break;
		case VistaIndices.INDICEP: indice = new IndicePosicionesEnLineas();	break;
		default: throw new RuntimeException("Opcion ["+opcion+"] no reconocida");
		}
		agregarFrases();
		indice.resolver(delimitadores());
		panel.salida(presentarIndice());
	}
	private void agregarFrases() {
		for (String frase : panel.listaTexto()) {
			indice.agregarFrase(frase);
		}
	}
	private String delimitadores() {
		String delim = panel.delimitadores();
		if (delim.isEmpty()) {
			delim = DEF_DELIM;
		}
		return delim;
	}
	private String presentarIndice() {
		StringWriter sw = new StringWriter();
		try (PrintWriter pw = new PrintWriter(sw)) {
			indice.presentarIndice(pw);
		}
		return sw.toString();
	}
}

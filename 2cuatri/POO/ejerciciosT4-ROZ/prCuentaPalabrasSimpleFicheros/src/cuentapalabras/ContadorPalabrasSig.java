package cuentapalabras;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContadorPalabrasSig extends ContadorPalabras {
	private List<String> noSignificativas;
	
	public ContadorPalabrasSig() {
		super();
		noSignificativas = new ArrayList<>();
	}
	
	public void leeArrayNoSig(String[] palsNS) {
		noSignificativas.clear();
		for(String pal:palsNS) {
			if(pal.length()>0) { // si no está vacia
				noSignificativas.add(pal.toUpperCase());
			}
			
		}
	}
	
	private void anyadePalabrasNoSignificativas(String linea, String del) {
		String[] linea_fragmentada = linea.split(del);
		for(String pal:linea_fragmentada) {
			if(pal.length()>0) {
				noSignificativas.add(pal.toUpperCase());
			}
		}
	}
	
	public void leeFicheroNoSig(String filNoSig, String del) throws IOException{
		noSignificativas.clear();
		try (Scanner sc = new Scanner(Path.of(filNoSig))){
			while(sc.hasNextLine()) {
				anyadePalabrasNoSignificativas(sc.nextLine(), del);
			}
		} catch (IOException e) {
			System.err.println("No se ha podido encontrar el archivo " + e.getMessage());
		}
	}
	
	@Override
	protected void incluye(String p) {
		if(estaNoSig(p)==-1) {
			super.incluye(p);
		}
	}
	
	private int estaNoSig(String pal) {
		return noSignificativas.indexOf(pal.toUpperCase());
	}
	
	
}

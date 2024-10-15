package cuentapalabras;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringJoiner;

public class ContadorPalabras {
	private List<PalabraEnTexto> palabras;
	
	public ContadorPalabras() {
		palabras = new ArrayList<>();
		
	}
	
	private int esta(String pal) {
		PalabraEnTexto aux = new PalabraEnTexto(pal);
		return palabras.indexOf(aux);
	}
	
	protected void incluye(String pal) {
		int pos = esta(pal);
		if(pal.length()>0) {
			if(pos != -1) {
				palabras.get(pos).incrementa();
			}
			else{
				palabras.add(new PalabraEnTexto(pal));
			}
		}
	}
	
	private void incluyeTodas(String linea, String del) {
		String[] info = linea.split(del);
		
		for (String pal : info) {
			incluye(pal);
		}
	}
	
	public void incluyeTodas(String[] texto, String del) {
		for (String line : texto) {
			incluyeTodas(line, del);
		}
	}
	
	public void incluyeTodasFichero(String nomFich, String del) throws IOException {
		
		try (Scanner sc = new Scanner(Path.of(nomFich))){
			while(sc.hasNextLine()) {
				incluyeTodas(sc.nextLine(), del);
			}
		} catch (IOException e) {
			System.err.println("ERROR. No se puede encontrar el archivo " + e.getMessage());
		}
	}
	
	public PalabraEnTexto encuentra(String pal) {
		PalabraEnTexto aux = new PalabraEnTexto(pal);
		int pos = palabras.indexOf(aux);
		if(pos != -1) {
			aux = palabras.get(pos);
		}
		else {
			throw new NoSuchElementException("No se encuentra la palabra " + pal.toUpperCase());
		}
		return aux;
	}
	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(" - ");
		for(int i=0; i<palabras.size(); i++) {
			sj.add(palabras.get(i).toString());
		}
		
		return "[" + sj.toString() + "]";
	}
	
	public void presentaPalabras(String fichero) throws FileNotFoundException {
		try(PrintWriter pw = new PrintWriter(fichero)){
			presentaPalabras(pw);
		}
		catch (FileNotFoundException e) {
			System.err.println("ERROR. El archivo siguiente no se ha encontrado: " + fichero);
		}
	}
	
	public void presentaPalabras(PrintWriter pw) {
		try{
			for(PalabraEnTexto pal: palabras) {
				pw.println(pal);
			}
		} catch (Exception e) {
			System.err.println("ERROR. " + e.getMessage());
		}
	}
}

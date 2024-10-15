import java.util.Arrays;

import datos.*;
public class PruebaDatos {

	public static void main(String[] args) {
//		if(args.length<2) {
//			throw new RuntimeException("Error, no hay valores suficientes");
//		} 	ESTO ES LOM ISMO QUE PONER UN INDEXOUTOFBOUNDEXCEPTION
		try {
			// si se pone asi, primero se cogen min y max y si no hay suficientes valores, da el error. Si hay al menos 2, los demas se ponen a 0
			double min = Double.parseDouble(args[0]);
			double max = Double.parseDouble(args[1]);
			Datos d = new Datos(Arrays.copyOfRange(args, 2, args.length), min, max);
			System.out.println(d);

			d.setRango("0;4");
			System.out.println(d);
			d.setRango("15 25");
		} 
		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Error, no hay valores suficientes");
		}
		catch (NumberFormatException e) {
			System.err.println("Error, al convertir un valor a número real (" + e.getMessage() + ")");
		}
		catch (DatosException e) {
			System.err.println(e.getMessage());
		}
		
	}

}

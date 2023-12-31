package baseDeDatos;

import java.util.ArrayList;
import java.util.List;

import logica.Producto;

public class DataBaseEnMenoria {
	
	public static List<Producto> listaProductos = new ArrayList<Producto>();

    // Bloque de inicialización estática
    static {
		listaProductos.add( new Producto("agua",1) );
		listaProductos.add( new Producto("vino",2) );
		listaProductos.add( new Producto("gaseosa",3) );
	}
	
	public static Producto productoMedianteId(int id) {
		Producto retornar = null;
		for (Producto producto : listaProductos) {
			if (producto.getId() == id) {
				retornar = producto;
				break;
			}
		}
		return retornar;
	} 
	
	public static int agregarProducto(Producto p) {
		listaProductos.add(p);
		return p.getId();
	}
	
	public static boolean modificar(int  id, Producto p) {		
		boolean modificado = false;
		for (Producto producto : listaProductos) {
			if(producto.getId() == id) {
				producto.setId(p.getId());
				producto.setNombre(p.getNombre());
				modificado = true;
				break;
			}
		}
		return modificado;
	}
	
	
	
}

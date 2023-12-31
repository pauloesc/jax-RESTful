package logica;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import baseDeDatos.DataBaseEnMenoria;

@Path("/p")
public class WebProductos {

	//	@Produces -- Indica el tipo de respuesta que producimos 
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		//	*podria hacer return DataBaseEnMenoria.listaProductos; y funcionaria... pero,
		//	The best practice for this retrieval operation is returning HTTP status code
		//	204 No Content if no data in the response.
	    if (DataBaseEnMenoria.listaProductos.isEmpty()) {
	        return Response.noContent().build();
	    }
	    return Response.ok(DataBaseEnMenoria.listaProductos).build();
	}
	

	//	Response: Response es una clase proporcionada por el paquete javax.ws.rs.core que representa una
	//	respuesta HTTP. Esta clase se utiliza para construir y enviar respuestas desde un servicio web.
	//
	//  noContent(): noContent() es un método estático de la clase Response.
	//	Este método indica que la respuesta HTTP que se está construyendo no contendrá un cuerpo (payload)
	//	significativo. En términos simples, la respuesta indicará que la operación fue exitosa,
	//	pero no hay datos adicionales para devolver.
	//
	//  build(): build() es un método de instancia que finaliza la construcción de la respuesta y la devuelve.
	//	En este caso, build() se utiliza para completar la construcción de la respuesta Response después
	//	de llamar a noContent().
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get( @PathParam("id") int id) {
		
		Producto p_retornar = DataBaseEnMenoria.productoMedianteId(id);
		
		if(p_retornar != null) {
			return Response.ok(p_retornar, MediaType.APPLICATION_JSON).build();
		}
		else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response agregar(Producto producto) throws URISyntaxException {
	    int id_nuevo_produc = DataBaseEnMenoria.agregarProducto(producto);
	    URI uri = new URI("/p/" + id_nuevo_produc);
	    return Response.created(uri).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response update(@PathParam("id") int id, Producto producto) {

		if ( DataBaseEnMenoria.modificar(id, producto) ) {
	        return Response.ok().build();
	    } else {
	        return Response.notModified().build();
	    }
	}
	
	
	
}

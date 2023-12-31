Este proyecto tiene por objetivo aprender las bases de Jersey, un framework de codigo abierto que implementa el estandar jax-rs para restful web services

http://localhost:8080/Probando-jax-rs/url/p muestra los productos (metodo get)

http://localhost:8080/Probando-jax-rs/url/p/id muestra el producto (metodo get)


Se requierede un software tipo postman para enviar datos...

http://localhost:8080/Probando-jax-rs/url/p (metodo post) mas un json del tipo ```{ "nombre":"kesito--","id": "99" }```para cargar un producto.

http://localhost:8080/Probando-jax-rs/url/p/id (metodo put) mas un json del tipo ```{ "nombre":"kesito--", "id": "99" }``` para actualizar la informacion en el producto con identificador id (el de la url)






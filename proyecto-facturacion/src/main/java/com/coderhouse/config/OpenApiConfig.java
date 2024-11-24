package com.coderhouse.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {
	
	@Bean
	OpenAPI customOpenAPI () {
		return new OpenAPI()
				.info(new Info()
						.title("API REST Full | Java | CoderHouse")
						.version("3.0.0")
						.description("La API REST proporciona endpoints para administrar clientes y "
                        		+ "productos en un sistema de facturacion. Permite realizar operaciones "
                        		+ "CRUD (Crear, Leer, Actualizar, Eliminar) tanto para clientes como "
                        		+ "para productos y ventas. Los endpoints permiten listar, agregar, mostrar, "
                        		+ "editar y eliminar clientes,productos y ventas. La API está documentada utilizando "
                        		+ "Swagger, lo que facilita la comprensión de los endpoints y su uso.")
						.contact(new Contact()
								.name("Bruno Lezama Méndez")
								.email("brunolezamamendez18@gmail.com")
								.url("https://coderhouse.com.ar"))
						.license(new License()
								.name("Licencia")
								.url("https://github.com/brunolm18"))
						)
						.servers(List.of(new Server()
								.url("http://localhost:8080")
								.description("Servidor Local")));
				
	}

}

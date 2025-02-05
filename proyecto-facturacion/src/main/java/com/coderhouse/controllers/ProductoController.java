package com.coderhouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.models.Cliente;
import com.coderhouse.models.Producto;
import com.coderhouse.services.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	
	@Operation(summary = "Obtener la Lista de todos los Productos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de productos obtenida correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class)) }),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
	})
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Producto>> getAllProductos() {
		try {
			List<Producto> productos = productoService.getAllProductos();
			return ResponseEntity.ok(productos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	
	@Operation(summary = "Obtener la Lista de todos los Productos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de productos obtenida correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class)) }),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
	})
	@GetMapping(value = "/{id}",produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Producto> getProductoById(@PathVariable Long id) {
		try {
			Producto producto = productoService.getProductoById(id);
			return ResponseEntity.ok(producto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
		try {
			Producto createdProducto = productoService.createProducto(producto);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdProducto);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@Operation(summary = "Editar una Producto existente")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Producto editado correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class)) }),
			@ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content) })
	@PutMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Producto> updateCurso(@PathVariable Long id, @RequestBody Producto cursoDetails) {
		try {
			Producto updatedProducto = productoService.updateProducto(id, cursoDetails);
			return ResponseEntity.ok(updatedProducto);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	
	@Operation(summary = "Eliminar un producto existente")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Producto eliminado correctamente", content = @Content),
			@ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content) })
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteProducto(@PathVariable Long id) {
		try {
			productoService.deleteProducto(id);
			return ResponseEntity.noContent().build();
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}

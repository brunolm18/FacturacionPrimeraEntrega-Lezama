package com.coderhouse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.coderhouse.services.ClienteService;
import org.springframework.http.MediaType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/api/clientes")
@Tag(name = "Gestion de Clientes", description = "Endpoints para Gestionar Clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Operation(summary = "Obtener la Lista de todos los Clientes")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de clientes obtenida correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class)) }),
			@ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
	})
	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Cliente>> getAllClientes(){
		try {
			List<Cliente> clientes = clienteService.getAllClientes();
			return ResponseEntity.ok(clientes);
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	@Operation(summary = "Obtener cliente por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cliente encontrado correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class)) }),
			@ApiResponse(responseCode = "404", description = "Cliente no encontrado", content = @Content) })
	@GetMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long id){
		try {
			Cliente cliente = clienteService.findById(id);
			return ResponseEntity.ok(cliente);
		}catch(IllegalArgumentException e) {
			return ResponseEntity.notFound().build();		
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
		try {
			Cliente createdCliente = clienteService.saveCliente(cliente);
			return ResponseEntity.ok(createdCliente);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	
	
	@Operation(summary = "Editar un cliente existente")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Cliente editado correctamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Cliente.class)) }),
			@ApiResponse(responseCode = "404", description = "Cliente no encontrado", content = @Content) })
	@PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Cliente> updateClienteById(@PathVariable Long id, @RequestBody Cliente clienteDetails) {
		try {
			Cliente updatedCliente = clienteService.updateCliente(id, clienteDetails);
			return ResponseEntity.ok(updatedCliente);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	
	@Operation(summary = "Eliminar un alumno existente")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "204", description = "Alumno eliminado correctamente", content = @Content),
			@ApiResponse(responseCode = "404", description = "Alumno no encontrado", content = @Content) })
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
		try {
			clienteService.deleteCliente(id);
			return ResponseEntity.noContent().build();

		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	}

	
	


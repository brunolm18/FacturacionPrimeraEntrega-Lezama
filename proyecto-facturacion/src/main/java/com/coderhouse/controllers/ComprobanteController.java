package com.coderhouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.dtos.ComprobanteDTO;

import com.coderhouse.services.ComprobanteService;



@RestController
@RequestMapping("/api/comprobantes")
public class ComprobanteController {
	
	 @Autowired
	 private  ComprobanteService comprobanteService;

	    @PostMapping(value = "/{ventaId}",consumes = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<ComprobanteDTO> generarComprobante(@PathVariable Long ventaId) {
	        try {
	            // Llamar al servicio para generar el comprobante
	            ComprobanteDTO response = comprobanteService.generarComprobante(ventaId);
	            
	            // Retornar respuesta con código 200 OK
	            return ResponseEntity.ok(response);
	        } catch (IllegalArgumentException e) {
	            // Si ocurre algún error de validación, devolvemos un BAD_REQUEST
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                    .body(new ComprobanteDTO());
	        } catch (Exception e) {
	            // Si ocurre un error general, devolvemos un INTERNAL_SERVER_ERROR
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body(new ComprobanteDTO());
	        }
	    }
	    
}
	    
   


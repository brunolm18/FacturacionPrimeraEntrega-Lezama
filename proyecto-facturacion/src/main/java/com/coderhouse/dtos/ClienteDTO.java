package com.coderhouse.dtos;

import com.coderhouse.models.Cliente;

import io.swagger.v3.oas.annotations.media.Schema;


public class ClienteDTO {

	@Schema(description = "Cliente ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    private Long id;
	
	@Schema(description = "Nombre Cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Bruno Lezama")
    private String nombre;
	
	@Schema(description = "Direccion de Cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Fracc.Miguel Hidalgo")
    private String direccion;
	
	@Schema(description = "Telefono Cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "582425924")
    private String telefono;
	
	@Schema(description = "Email Cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "brunolezama@gmail.com")
    private String email;
    
    
    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nombre = cliente.getNombre();
        this.direccion = cliente.getDireccion();
        this.telefono = cliente.getTelefono();
        this.email = cliente.getEmail();
    }
	
	
	
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
    
    
}

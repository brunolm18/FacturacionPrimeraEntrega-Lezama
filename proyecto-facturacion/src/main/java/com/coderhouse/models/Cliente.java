package com.coderhouse.models;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Schema(description = "Modelo de Cliente")
@Entity
@Table(name = "Clientes")
public class Cliente { 
	
	
	@Schema(description = "ID del Cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Schema(description = "Nombre del Cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Bruno")
	@Column(nullable = false)
	private String nombre;
	
	@Schema(description = "Direccion del Cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "Fracc. Miguel Hidalgo")
	private String direccion;
	
	
	@Schema(description = "Telefono del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "285219853")
	@Column (unique = true,nullable = false)
	
	private String telefono;
	@Schema(description = "Email del cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "juanhernandez@gmail.com")
	private String email;
	
	@Schema(description = "Fecha de Alta del Cliente", requiredMode = Schema.RequiredMode.REQUIRED, example = "22/02/2024")
	@OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonManagedReference
	
	private List<Venta> ventas = new ArrayList<>();
	@Schema(description = "Fecha en que se creo la venta", requiredMode = Schema.RequiredMode.REQUIRED)
	private LocalDateTime createdAt = LocalDateTime.now();
	
	@Schema(description = "Lista de los productos de clientes", requiredMode = Schema.RequiredMode.REQUIRED, example = "Pan,Huevo")
	@JsonIgnore
	@ManyToMany(mappedBy = "clientes")
	private List<Producto> productos = new ArrayList<>();

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

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
	
	
	
	
}
	
	

    

package com.coderhouse.models;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Cliente { 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nombre;
	
	private String direccion;
	
	@Column (unique = true,nullable = false)
	
	private String telefono;
	
	private String email;
	
	@OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonBackReference
	private List<Venta> ventas = new ArrayList<>();
	private LocalDateTime createdAt;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "clientes")
	private List<Producto> productos = new ArrayList<>();
	
	
	public Cliente(Long id, String nombre, String direccion, String telefono, String email, List<Venta> ventas, LocalDateTime createdAt) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.ventas = ventas;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
    }

	 public Cliente() {
	       this.createdAt = LocalDateTime.now();
	 }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Venta> getVentas() { return ventas; }
    public void setVentas(List<Venta> ventas) { this.ventas = ventas; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    
    

    public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
    public String toString() {
        return "Cliente [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
                + ", email=" + email + ", createdAt=" + createdAt + "]";
    }
}

	
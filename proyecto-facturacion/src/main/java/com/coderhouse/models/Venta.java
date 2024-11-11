package com.coderhouse.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "Ventas")
public class Venta {
	
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
   
	@Column(nullable = false)
	private LocalDateTime fecha = LocalDateTime.now();

    @ManyToOne 
    @JoinColumn(name = "cliente_id") 
    @JsonManagedReference
    private Cliente cliente;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "venta_producto",
        joinColumns = @JoinColumn(name = "venta_id"),
        inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Producto> productos = new ArrayList<>();

	public Venta() {
		super();
		
	}

	public Venta(Long id, LocalDateTime fecha, Cliente cliente, List<Producto> productos) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.cliente = cliente;
		this.productos = productos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}



	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", fecha=" + fecha + ", cliente=" + cliente + ", productos=" + productos + "]";
	}
    
    
    
}
    
    

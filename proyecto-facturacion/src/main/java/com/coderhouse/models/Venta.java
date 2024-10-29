package com.coderhouse.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


@Entity
public class Venta {
	
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String fecha; 

    @ManyToOne // 
    @JoinColumn(name = "cliente_id") 
    private Cliente cliente; 

    @ManyToMany 
    @JoinTable(
        name = "venta_producto", 
        joinColumns = @JoinColumn(name = "venta_id"), 
        inverseJoinColumns = @JoinColumn(name = "producto_id") 
    )
    private List<Producto> productos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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

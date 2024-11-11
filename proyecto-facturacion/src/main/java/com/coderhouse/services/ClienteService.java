package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.dtos.TicketDTO;
import com.coderhouse.models.Cliente;
import com.coderhouse.models.Producto;
import com.coderhouse.repositories.ClienteRepository;
import com.coderhouse.repositories.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProductoRepository productoRepository;





	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}

	public Cliente findById(Long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
	}
	@Transactional
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Transactional
	public Cliente updateCliente(Long id, Cliente clienteDetails) {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

		cliente.setNombre(clienteDetails.getNombre());
		cliente.setDireccion(clienteDetails.getDireccion());
		cliente.setTelefono(clienteDetails.getTelefono());
		cliente.setCreatedAt(clienteDetails.getCreatedAt());
		cliente.setEmail(clienteDetails.getEmail());
		 
		
		return clienteRepository.save(cliente);
	} 

	public void deleteCliente(Long id) {
		if (!clienteRepository.existsById(id)) {
			throw new IllegalArgumentException("Cliente no encontrado");
		}
		clienteRepository.deleteById(id);

	}
	
	@Transactional
	public Cliente ticketClienteVentas(TicketDTO ticketDTO) {
		Cliente cliente = clienteRepository.findById(ticketDTO.getClienteId())
				.orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
		for(Long productoid: ticketDTO.getProductosIDs()) {
			Producto producto = productoRepository.findById(productoid)
					.orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
			cliente.getProductos().add(producto);
			producto.getClientes().add(cliente);
			productoRepository.save(producto);
		}
		return clienteRepository.save(cliente);
	}
	
}

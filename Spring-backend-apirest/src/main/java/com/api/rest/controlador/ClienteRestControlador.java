package com.api.rest.controlador;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.modelo.Cliente;
import com.api.rest.negocio.IClienteServicio;

@RestController
@RequestMapping("/api")
public class ClienteRestControlador {
	
	@Autowired
	private IClienteServicio iClienteServicio;
	
	//devolver todos los clientes
	@GetMapping("/clientes")
	public  List<Cliente> listar(){
		return iClienteServicio.findAll();
		
	}
	
	
	//buscar por id
	@GetMapping("/clientes/{id}")
	public Cliente buscarPoId(@PathVariable Long id) {
		return iClienteServicio.findById(id);
	}
	
	
	
	//crear
	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente crear(@RequestBody Cliente cliente) {
		cliente.setFechaCreacion(new Date());
		 iClienteServicio.save(cliente);	
		 return cliente;
		
	}
	
	
	
	//actualizar
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente actualizar(@RequestBody Cliente cliente,@PathVariable Long id) {
		Cliente objetoCliente=iClienteServicio.findById(id);
		objetoCliente.setNombre(cliente.getNombre());
		objetoCliente.setApellido(cliente.getApellido());
		objetoCliente.setMail(cliente.getMail());
		iClienteServicio.save(objetoCliente);
		
		return objetoCliente;
	}
	
	
	//eliminar
	@DeleteMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void eliminar(@PathVariable Long id) {
		Cliente objetoCliente=iClienteServicio.findById(id);
		iClienteServicio.delete(objetoCliente);
		
	}
	
	
	

}

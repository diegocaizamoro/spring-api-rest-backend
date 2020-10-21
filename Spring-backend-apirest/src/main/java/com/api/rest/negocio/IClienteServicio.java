package com.api.rest.negocio;

import java.util.List;

import com.api.rest.modelo.Cliente;

public interface IClienteServicio {
	
	public List<Cliente> findAll();
	public void save(Cliente cliente);
	public Cliente findById(Long  id);
	public void delete (Cliente cliente);


}

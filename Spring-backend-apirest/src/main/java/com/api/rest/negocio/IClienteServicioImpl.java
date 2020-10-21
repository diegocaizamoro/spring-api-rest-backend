package com.api.rest.negocio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.api.rest.dao.IClienteDao;
import com.api.rest.modelo.Cliente;

public class IClienteServicioImpl implements IClienteServicio {

	
	@Autowired
	private IClienteDao iClienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) iClienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		iClienteDao.save(cliente);

	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return iClienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Cliente cliente) {
		iClienteDao.delete(cliente);

	}

}

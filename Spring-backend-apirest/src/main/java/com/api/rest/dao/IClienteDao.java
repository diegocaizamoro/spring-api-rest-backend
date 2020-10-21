package com.api.rest.dao;

import org.springframework.data.repository.CrudRepository;
import com.api.rest.modelo.Cliente;

public interface IClienteDao  extends CrudRepository<Cliente, Long>{

}

package br.com.fiap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.domain.Peso;

@Repository
public interface PesoRepository extends CrudRepository<Peso, Integer>{

}

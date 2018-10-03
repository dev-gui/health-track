package br.com.fiap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.domain.Pressao;

@Repository
public interface PressaoRepository extends CrudRepository<Pressao, Integer>{

}

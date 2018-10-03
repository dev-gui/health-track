package br.com.fiap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.domain.Atividade;

@Repository
public interface AtividadeRepository extends CrudRepository<Atividade, Integer> {

}

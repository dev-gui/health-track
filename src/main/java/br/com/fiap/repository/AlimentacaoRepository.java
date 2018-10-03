package br.com.fiap.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.domain.Alimentacao;

@Repository
public interface AlimentacaoRepository extends CrudRepository<Alimentacao, Integer> {

}

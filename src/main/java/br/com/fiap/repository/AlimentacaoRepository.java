package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.domain.Alimentacao;

@Repository
public interface AlimentacaoRepository extends JpaRepository<Alimentacao, Long> {

}

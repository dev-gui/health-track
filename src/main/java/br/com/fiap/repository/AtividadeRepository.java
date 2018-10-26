package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.domain.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {

}

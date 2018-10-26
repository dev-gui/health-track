package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.domain.Peso;

@Repository
public interface PesoRepository extends JpaRepository<Peso, Integer>{

}

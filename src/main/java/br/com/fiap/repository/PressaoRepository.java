package br.com.fiap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.domain.Pressao;

@Repository
public interface PressaoRepository extends JpaRepository<Pressao, Integer>{

}

package com.hackaton.unifacisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackaton.unifacisa.domain.Refeicao;

@Repository
public interface RefeicaoRepository extends JpaRepository<Refeicao, Integer>{

}

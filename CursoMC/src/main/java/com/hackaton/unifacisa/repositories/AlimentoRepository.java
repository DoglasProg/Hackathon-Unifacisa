package com.hackaton.unifacisa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackaton.unifacisa.domain.Alimento;
import com.hackaton.unifacisa.domain.Usuario;

@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Integer>{

}

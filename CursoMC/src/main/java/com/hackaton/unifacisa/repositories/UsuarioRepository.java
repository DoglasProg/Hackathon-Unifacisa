package com.hackaton.unifacisa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackaton.unifacisa.domain.Refeicao;
import com.hackaton.unifacisa.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	List<Refeicao> findByRefeicoes(Integer id);

	Usuario findByEmail(String email);
}

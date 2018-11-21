package com.hackaton.unifacisa.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.hackaton.unifacisa.Services.exception.AuthorizationException;
import com.hackaton.unifacisa.Services.exception.ObjectNotFoundException;
import com.hackaton.unifacisa.domain.Refeicao;
import com.hackaton.unifacisa.domain.Usuario;
import com.hackaton.unifacisa.domain.enums.Perfil;
import com.hackaton.unifacisa.repositories.UsuarioRepository;
import com.hackaton.unifacisa.security.UserSecurity;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario find(Integer id) {
		UserSecurity user = UserService.authenticated();
		if(!user.hasRole(Perfil.ADMIN) && (user==null  || !id.equals(user.getId()))) {
			throw new AuthorizationException("Acesso negado");
		}
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id:" + id + ", Tipo:" + Usuario.class.getName()));
	}
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		obj = usuarioRepository.save(obj);
		return obj;
	}
	
	public Usuario update(Usuario obj) {
		find(obj.getId());
		return usuarioRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			
			usuarioRepository.deleteById(id); 
		
		}catch (DataIntegrityViolationException e){
			throw new DataIntegrityViolationException("Não é possivel excluir");
		}
	}

	public Usuario findUserLogin() {
		UserSecurity user = UserService.authenticated();
		return find(user.getId());
		
	}
	
	public void insertRefeicaoUser(Refeicao refeicao) {
		UserSecurity userss = UserService.authenticated();
		Usuario user = find(userss.getId());
		user.setRefeicoes(refeicao);
		update(user);
	}
	
}

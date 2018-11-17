package com.hackaton.unifacisa.Services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.hackaton.unifacisa.Services.validation.utils.BR;
import com.hackaton.unifacisa.domain.enums.TipoCliente;
import com.hackaton.unifacisa.dto.ClienteNewDTO;
import com.hackaton.unifacisa.repositories.ClienteRepository;
import com.hackaton.unifacisa.resources.exception.FieldMessage;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

	@Autowired
	ClienteRepository repo;
	
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();
		
		if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {

			list.add(new FieldMessage("cpfOuCnpj", "CPF inválido"));
		}

		if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {

			list.add(new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
		}
		
		if(repo.findByEmail(objDto.getEmail())!=null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage())
			.addPropertyNode(e.getFileName()).addConstraintViolation();
		}
		return list.isEmpty();
	}
}
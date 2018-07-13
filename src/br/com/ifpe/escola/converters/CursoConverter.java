package br.com.ifpe.escola.converters;

import org.springframework.core.convert.converter.Converter;

import br.com.ifpe.escola.model.Curso;
import br.com.ifpe.escola.model.CursoDao;

public class CursoConverter implements Converter<String, Curso> {
	
	public Curso convert(String id) {
		
		CursoDao dao = new CursoDao();
		
		return dao.buscarPorId(Integer.valueOf(id));
		
		}
}

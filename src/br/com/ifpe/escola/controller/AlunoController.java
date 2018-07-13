package br.com.ifpe.escola.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.ifpe.escola.model.Aluno;
import br.com.ifpe.escola.model.AlunoDao;
import br.com.ifpe.escola.model.Curso;
import br.com.ifpe.escola.model.CursoDao;
import br.com.ifpe.escola.util.Util;

@Controller
public class AlunoController {
	
	@RequestMapping("index")
	public String home() {

		return "index";
	}

	@RequestMapping("/aluno/add")
	public String adicionarAluno(Model model) {
		
		CursoDao dao = new CursoDao();
		List<Curso> listaCurso = dao.listar(null);
		model.addAttribute("listaCurso", listaCurso);

		return "aluno/incluirAluno";
	}
	
	@RequestMapping("/aluno/save")
    public String save(Aluno aluno, @RequestParam("file") MultipartFile imagem, Model model) {

	if (Util.fazerUploadImagem(imagem)) {
	    aluno.setImagem(Util.obterMomentoAtual() + " - " + imagem.getOriginalFilename());
	}

	AlunoDao dao = new AlunoDao();
	dao.salvar(aluno);

	model.addAttribute("mensagem", "Aluno Inclu�do com Sucesso");
	return "aluno/incluirAluno";
    }

	@RequestMapping("/aluno/list")
    public String listarAluno(Model model) {

	AlunoDao dao = new AlunoDao();
	List<Aluno> listaAluno = dao.listar(null);
	model.addAttribute("listaAluno", listaAluno);

	return "aluno/listarAluno";
    }

    @RequestMapping("/aluno/filter")
    public String filtrarProduto(Aluno aluno, Model model) {

	AlunoDao dao = new AlunoDao();
	List<Aluno> listaAluno = dao.listar(aluno);
	model.addAttribute("listaAluno", listaAluno);

	return "aluno/listarAluno";
    }
    
    @RequestMapping("/aluno/edit")
    public String edit(@RequestParam("id") Integer id, Model model) {

    AlunoDao dao = new AlunoDao();
	Aluno aluno = dao.buscarPorId(id);
	model.addAttribute("aluno", aluno);
	
	CursoDao dao2 = new CursoDao();
	List<Curso> listaCurso = dao2.listar(null);
	model.addAttribute("listaCurso", listaCurso);

	return "aluno/alterarAluno";
    }
    
    @RequestMapping("/aluno/update")
	public String update(Aluno aluno, @RequestParam("file") MultipartFile imagem ,Model model) {
		if(imagem != null) {
			if (Util.fazerUploadImagem(imagem)) {
				aluno.setImagem(Util.obterMomentoAtual() + " - " + imagem.getOriginalFilename());
			}
		}
		AlunoDao dao = new AlunoDao();
		dao.alterar(aluno);
		model.addAttribute("mensagem", "Aluno Alterado com Sucesso !");
		return "forward:list";
	}
    
    @RequestMapping("/aluno/delete")
	    public String delete(@RequestParam("id") Integer id, Model model) {
	
    	AlunoDao dao = new AlunoDao();
		dao.remover(id);
		model.addAttribute("mensagem", "Aluno Removido com Sucesso");
	
		return "forward:list";
    }
    
    
}

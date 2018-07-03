package br.com.ifpe.escola.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AlunoDao {
	
	protected static final String PERSISTENCE_UNIT = "escola";

    public void salvar(Aluno obj) {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	EntityManager manager = factory.createEntityManager();

	manager.getTransaction().begin();
	manager.persist(obj);
	manager.getTransaction().commit();

	manager.close();
	factory.close();
    }
    
    public List<Aluno> listar(Aluno aluno) {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	EntityManager manager = factory.createEntityManager();
	Query query = null;

	String nome = aluno != null ? aluno.getNome() : "";
	String turma = aluno != null ? aluno.getTurma() : "";

	if (!nome.equals("") && turma.equals("")) {
	    query = manager.createQuery("FROM Aluno WHERE nome LIKE :paramNome ORDER BY nome");
	    query.setParameter("paramNome", "%" + nome + "%");
	} else if (nome.equals("") && !turma.equals("")) {
	    query = manager.createQuery("FROM Aluno WHERE turma LIKE :paramTurma ORDER BY nome");
	    query.setParameter("paramTurma", "%" + turma + "%");
	} else if (!nome.equals("") && !turma.equals("")) {
	    query = manager.createQuery(
		    "FROM Aluno WHERE nome LIKE :paramNome AND turma LIKE :paramTurma ORDER BY nome");
	    query.setParameter("paramNome", "%" + nome + "%");
	    query.setParameter("paramTurma", "%" + turma + "%");
	} else {
	    query = manager.createQuery("FROM Aluno ORDER BY nome");
	}

	List<Aluno> lista = query.getResultList();

	manager.close();
	factory.close();

	return lista;
    }
    
    public Aluno buscarPorId(int id) {

    	Aluno obj = null;

    	EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    	EntityManager manager = factory.createEntityManager();
    	obj = manager.find(Aluno.class, id);
    	manager.close();
    	factory.close();

    	return obj;
        }
	
    public void alterar(Aluno aluno) {

    	EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    	EntityManager manager = factory.createEntityManager();

    	manager.getTransaction().begin();
    	manager.merge(aluno);
    	manager.getTransaction().commit();

    	manager.close();
    	factory.close();
        }
    
    public void remover(int id) {

    	EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    	EntityManager manager = factory.createEntityManager();
    	Aluno aluno = manager.find(Aluno.class, id);

    	manager.getTransaction().begin();
    	manager.remove(aluno);
    	manager.getTransaction().commit();

    	manager.close();
    	factory.close();
        }
}

package br.com.ifpe.escola.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CursoDao {

    private static final String PERSISTENCE_UNIT = "escola";

	public List<Curso> listar(Curso curso) {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	EntityManager manager = factory.createEntityManager();
	Query query = manager.createQuery("FROM Curso ORDER BY nome");
	
	List<Curso> lista = query.getResultList();

	manager.close();
	factory.close();

	return lista;
    }
	
    public Curso buscarPorId(int id) {

    	Curso obj = null;

    	EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
    	EntityManager manager = factory.createEntityManager();
    	obj = manager.find(Curso.class, id);
    	manager.close();
    	factory.close();

    	return obj;
        }
	
}

package br.com.javaee.fullshowcase.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.javaee.fullshowcase.model.Author;

public class AuthorDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Author> getAuthors(){
		return manager.createQuery("select a from Author a", Author.class).getResultList();
	}

}

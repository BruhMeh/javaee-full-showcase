package br.com.javaee.fullshowcase.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.javaee.fullshowcase.model.Book;

public class BookDao {
	
    @PersistenceContext
    private EntityManager manager;
    
    public void save(Book book) {
        manager.persist(book);
    }

}

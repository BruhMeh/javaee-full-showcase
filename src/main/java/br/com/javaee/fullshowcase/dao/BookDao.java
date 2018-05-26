package br.com.javaee.fullshowcase.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.javaee.fullshowcase.model.Book;

public class BookDao {
	
    @PersistenceContext
    private EntityManager manager;
    
    public void save(Book book) {
        manager.persist(book);
    }

	public List<Book> getBooksList() {
		return manager.createQuery("select distinct(b) from Book b join fetch b.authors", Book.class).getResultList();
	}

}

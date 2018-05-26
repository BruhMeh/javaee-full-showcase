package br.com.javaee.fullshowcase.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.javaee.fullshowcase.dao.BookDao;
import br.com.javaee.fullshowcase.model.Book;

@Named
@RequestScoped
public class AdminBooksBean {
	
	@Inject
	private BookDao bookDao;

	private Book book = new Book();

	@Transactional
	public void save() {
		bookDao.save(book);
		System.out.println("Book added: " + book);
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}

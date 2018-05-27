package br.com.javaee.fullshowcase.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.javaee.fullshowcase.dao.AuthorDao;
import br.com.javaee.fullshowcase.dao.BookDao;
import br.com.javaee.fullshowcase.model.Author;
import br.com.javaee.fullshowcase.model.Book;

@Named
@RequestScoped
public class AdminBooksBean {
	
	@Inject
	private BookDao bookDao;
	
	@Inject
	private AuthorDao authorDao;
	@Inject
	private FacesContext facesContext;

	private Book book = new Book();
	
	private List<Integer> authorsIds = new ArrayList<>();

	@Transactional
	public String save() {
		authorsIds.forEach(authorId -> book.getAuthors().add(new Author(authorId)));
		bookDao.save(book);
		
		
		facesContext.getExternalContext().getFlash().setKeepMessages(true);
		facesContext.addMessage(null, new FacesMessage("Book added"));
		
		return "/books/list?faces-redirect=true";
	}
	
	public List<Author> getAuthors(){
		return authorDao.getAuthors();
		
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Integer> getAuthorsIds() {
		return authorsIds;
	}

	public void setAuthorsIds(List<Integer> authorsIds) {
		this.authorsIds = authorsIds;
	}

}

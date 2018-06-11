package br.com.javaee.fullshowcase.beans;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
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
	
	private Part bookCover;
	

	@Transactional
	public String save() throws IOException {
		bookDao.save(book);
		String coverPath = "/bookstore/books" + bookCover.getSubmittedFileName();
		bookCover.write(coverPath);
		book.setCoverPath(coverPath);
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

	public Part getBookCover() {
		return bookCover;
	}

	public void setBookCover(Part bookCover) {
		this.bookCover = bookCover;
	}

}

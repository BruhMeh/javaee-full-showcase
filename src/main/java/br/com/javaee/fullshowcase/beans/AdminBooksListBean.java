package br.com.javaee.fullshowcase.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.javaee.fullshowcase.dao.BookDao;
import br.com.javaee.fullshowcase.model.Book;

@Model
public class AdminBooksListBean {
	
	@Inject
	private BookDao bookDao;
	
	private List<Book> books = new ArrayList<>();
	
	public List<Book> getBooks() {
		books = bookDao.getBooksList();
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}

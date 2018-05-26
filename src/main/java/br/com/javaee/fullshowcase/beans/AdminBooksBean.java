package br.com.javaee.fullshowcase.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.javaee.fullshowcase.model.Book;

@Named
@RequestScoped
public class AdminBooksBean {

	private Book book = new Book();

	public void save() {
		System.out.println("Book added: " + book);
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}

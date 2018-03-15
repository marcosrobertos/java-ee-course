package com.macrob.course.jee.jsf.controller;

import com.macrob.course.jee.jsf.model.Book;
import com.macrob.course.jee.jsf.model.BookEJB;
import java.util.ArrayList;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author Antonio Goncalves APress Book - Beginning Java EE 7 with Glassfish 4
 * http://www.apress.com/ http://www.antoniogoncalves.org --
 */
@ManagedBean
@SessionScoped
public class BookController {

	// ======================================
	// =             Attributes             =
	// ======================================
	@Inject
	private BookEJB bookEJB;

	private Book book = new Book();
	private Date currentDate = new Date();
	private List<Book> bookList = new ArrayList<Book>();

	// ======================================
	// =           Public Methods           =
	// ======================================
	public String doNew() {
		book = new Book();
		return "newBook.xhtml";
	}

	public String doCreateBook() {
		book = bookEJB.createBook(book);
		bookList = bookEJB.findBooks();
		return "listBooks.xhtml";
	}

	// ======================================
	// =          Getters & Setters         =
	// ======================================
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	/**
	 * @return the bookList
	 */
	public List<Book> getBookList() {
		System.out.println("getBookList");
		return bookList;
	}

	/**
	 * @param bookList the bookList to set
	 */
	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}
}

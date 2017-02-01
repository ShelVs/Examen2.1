/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.service;

import ac.cr.una.backend.dao.BookDAO;
import ac.cr.una.backend.model.Book;
import java.util.List;

/**
 *
 * @author Shel
 */
public class BookServiceImpl implements BookService
{

	private BookDAO bookDAO;

	public BookServiceImpl()
	{
	}

	public BookServiceImpl(BookDAO bookDAO)
	{
		this.bookDAO = bookDAO;
	}

	@Override
	public boolean deleteAll()
	{
		return bookDAO.deleteAll();
	}

	@Override
	public Book save(Book book)
	{
		return bookDAO.save(book);
	}

	@Override
	public List<Book> findAll()
	{
		return bookDAO.findAll();
	}

	/*@Override
	public float totalPriceAll()
	{
		return bookTypeDAO.totalPriceAll();
	}*/
	public BookDAO getBookDAO()
	{
		return bookDAO;
	}

	public void setBookDAO(BookDAO bookDAO)
	{
		this.bookDAO = bookDAO;
	}

}

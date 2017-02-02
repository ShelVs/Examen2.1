/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcional.test.ac.cr.una.backend;

import ac.cr.una.backend.dao.BookDAO;
import ac.cr.una.backend.dao.BookDAOImpl;
import ac.cr.una.backend.model.Book;
import ac.cr.una.backend.service.BookService;
import ac.cr.una.backend.service.BookServiceImpl;
import org.junit.After;

/**
 *
 * @author Shel
 */
public class BookServiceTest
{

	private BookDAO bookDAO;
	private BookService bookService;
	private Book book = null;

	@After
	public void deleteAll()
	{
		bookDAO = new BookDAOImpl();
		bookService = new BookServiceImpl(bookDAO);
	}

}

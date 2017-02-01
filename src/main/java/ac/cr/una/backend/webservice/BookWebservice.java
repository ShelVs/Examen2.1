/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.webservice;

import ac.cr.una.backend.dao.BookDAO;
import ac.cr.una.backend.dao.BookDAOImpl;
import ac.cr.una.backend.model.Book;
import ac.cr.una.backend.service.BookService;
import ac.cr.una.backend.service.BookServiceImpl;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Shel
 */
@Path("books")
public class BookWebservice
{

	private BookDAO bookDAO;
	private BookService bookService;

	@Context
	private UriInfo context;

	public BookWebservice()
	{
	}

	@DELETE
	@Path("/{idBook}")
	public boolean deleteBook(@PathParam("idBook") int idBook)
	{
		boolean result;
		bookDAO = new BookDAOImpl();
		bookService = new BookServiceImpl(bookDAO);

		result = bookService.deleteAll();

		return result;
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Book createBook(Book book)
	{

		bookDAO = new BookDAOImpl();
		bookService = new BookServiceImpl(bookDAO);

		book = bookService.save(book);

		return book;
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getAllBooks()
	{
		List<Book> bookList = null;
		bookDAO = new BookDAOImpl();
		bookService = new BookServiceImpl(bookDAO);

		bookList = bookService.findAll();

		return bookList;
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public float getTotalPrice()
	{
		float result;
		bookService = new BookServiceImpl(bookDAO);
		result = bookService.totalPriceAll();

		return result;
	}

}

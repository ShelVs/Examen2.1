/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcional.test.ac.cr.una.backend;

import ac.cr.una.backend.dao.BookTypeDAO;
import ac.cr.una.backend.dao.BookTypeDAOImpl;
import ac.cr.una.backend.model.BookType;
import ac.cr.una.backend.service.BookTypeService;
import ac.cr.una.backend.service.BookTypeServiceImpl;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 *
 * @author Shel
 */
public class BookTypeServiceTest
{

	private BookTypeDAO bookTypeDAO;
	private BookTypeService bookTypeService;
	private BookType bookType = null;

	public BookTypeServiceTest()
	{
	}

	@After
	public void deleteAll()
	{
		bookTypeDAO = new BookTypeDAOImpl();
		bookTypeService = new BookTypeServiceImpl(bookTypeDAO);
	}

	@Test
	public void testSave()
	{
		bookTypeDAO = mock(BookTypeDAOImpl.class);
		bookTypeService = new BookTypeServiceImpl(bookTypeDAO);

		BookType bookType = new BookType();
		bookType.setType("materia");

		when(bookTypeDAO.save(any(BookType.class)))
				.thenAnswer(new Answer<BookType>()
				{
					@Override
					public BookType answer(InvocationOnMock invocation) throws Throwable
					{
						BookType bookType = (BookType) invocation.getArguments()[0];
						bookType.setIdType(1);
						return bookType;
					}
				});

		assertNotNull(bookType.getIdType());

		bookType = bookTypeService.save(bookType);

		assertNotNull(bookType.getIdType());
		assertTrue(bookType.getIdType() > 0);
	}

	@Test
	public void testFindByName()
	{
		bookTypeDAO = mock(BookTypeDAOImpl.class);
		bookTypeService = new BookTypeServiceImpl(bookTypeDAO);

		BookType bookType = new BookType();
		bookType.setType("mate");

		when(bookTypeService.findByName("")).thenReturn(bookType);

		assertThat(bookType.getType(), is("mate"));
	}

}

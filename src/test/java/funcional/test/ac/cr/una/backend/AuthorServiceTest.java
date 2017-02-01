/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcional.test.ac.cr.una.backend;

import ac.cr.una.backend.dao.AuthorDAO;
import ac.cr.una.backend.dao.AuthorDAOImpl;
import ac.cr.una.backend.model.Author;
import ac.cr.una.backend.service.AuthorService;
import ac.cr.una.backend.service.AuthorServiceImpl;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Shel
 */
public class AuthorServiceTest
{

	private AuthorDAO authorDAO;
	private AuthorService authorService;
	private Author author = null;

	public AuthorServiceTest()
	{
	}

	@Test
	public void testFindByName()
	{
		authorDAO = mock(AuthorDAOImpl.class);
		authorService = new AuthorServiceImpl(authorDAO);

		Author author = new Author();
		author.setName("Mike");

		when(authorService.findByName("ala")).thenReturn(author);

		assertThat(author.getName(), is("Mike"));
	}

}

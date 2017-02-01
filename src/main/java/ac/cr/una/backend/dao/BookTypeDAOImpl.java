/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.BookType;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Shel
 */
public class BookTypeDAOImpl implements BookTypeDAO
{

	private final Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public boolean deleteAll()
	{
		BookType bookType = null;
		String stringQuery = "DELETE FROM bookType";
		Query query = session.createQuery(stringQuery);
		int result = query.executeUpdate();

		return result > 0;

	}

	@Override
	public BookType save(BookType bookType)
	{
		session.beginTransaction();
		session.save(bookType);
		session.getTransaction().commit();

		return bookType;
	}

	@Override
	public BookType findByName(String name)
	{
		BookType bookType = null;
		Query query = session.createQuery("from book where name = :name ");
		query.setParameter("name", name);

		if (query.list().size() > 0)
		{
			bookType = (BookType) query.list().get(0);
		}

		return bookType;
	}

}

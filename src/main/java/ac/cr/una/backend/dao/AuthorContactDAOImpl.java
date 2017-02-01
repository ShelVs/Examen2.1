/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.dao;

import ac.cr.una.backend.model.AuthorContact;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Shel
 */
public class AuthorContactDAOImpl implements AuthorContactDAO
{

	private final Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public boolean deleteAll()
	{
		AuthorContact authorContact = null;
		String stringQuery = "DELETE FROM author";
		Query query = session.createQuery(stringQuery);
		int result = query.executeUpdate();

		return result > 0;

	}

	@Override
	public AuthorContact save(AuthorContact authorContact)
	{
		session.beginTransaction();
		session.save(authorContact);
		session.getTransaction().commit();

		return authorContact;
	}

	@Override
	public List<AuthorContact> findAll()
	{
		List<AuthorContact> authorContactList = new ArrayList<>();

		authorContactList = session.createCriteria(AuthorContact.class).list();

		return authorContactList;
	}

}

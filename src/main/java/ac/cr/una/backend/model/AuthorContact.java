/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.backend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Shel
 */
@Entity
@Table(name = "authorContact", catalog = "progra3_exa2", uniqueConstraints =
{
	@UniqueConstraint(columnNames = "idAuthorContact")
})

public class AuthorContact
{

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idAuthorContact")
	private int idAuthorContact;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "idAuthor", nullable = false)
	private Author author;

	@Column(name = "contact", unique = false, nullable = false)
	private String contact;

	@Column(name = "type", unique = false, nullable = false)
	private String type;

	public AuthorContact()
	{
	}

	public AuthorContact(int idAuthorContact, Author author, String contact, String type)
	{
		this.idAuthorContact = idAuthorContact;
		this.author = author;
		this.contact = contact;
		this.type = type;
	}

	public int getIdAuthorContact()
	{
		return idAuthorContact;
	}

	public void setIdAuthorContact(int idAuthorContact)
	{
		this.idAuthorContact = idAuthorContact;
	}

	public Author getAuthor()
	{
		return author;
	}

	public void setAuthor(Author author)
	{
		this.author = author;
	}

	public String getContact()
	{
		return contact;
	}

	public void setContact(String contact)
	{
		this.contact = contact;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	@Override
	public int hashCode()
	{
		int hash = 7;
		hash = 71 * hash + this.idAuthorContact;
		hash = 71 * hash + (this.author != null ? this.author.hashCode() : 0);
		hash = 71 * hash + (this.contact != null ? this.contact.hashCode() : 0);
		hash = 71 * hash + (this.type != null ? this.type.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final AuthorContact other = (AuthorContact) obj;
		if (this.idAuthorContact != other.idAuthorContact)
		{
			return false;
		}
		if ((this.contact == null) ? (other.contact != null) : !this.contact.equals(other.contact))
		{
			return false;
		}
		if ((this.type == null) ? (other.type != null) : !this.type.equals(other.type))
		{
			return false;
		}
		if (this.author != other.author && (this.author == null || !this.author.equals(other.author)))
		{
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		return "AuthorContact{" + "idAuthorContact=" + idAuthorContact + ", author=" + author + ", contact=" + contact + ", type=" + type + '}';
	}

}

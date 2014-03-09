package our.company.name.loan.dao;

import java.io.Serializable;

import org.hibernate.SessionFactory;

/**
 * Any DAO (i.e. a Data Access Object) needs a Session Factory Object. So in
 * this interface, we will declare the getters and setters for the session
 * factory object. All 'DAO' interfaces in our application are supposed to
 * extend this interface first.
 */
public interface GenericDao extends Serializable {

	/** The Getter Method for Hibernate Session Factory Object */
	public SessionFactory getSessionFactory();

	/** The Setter Method for Hibernate Session Factory Object */
	public void setSessionFactory(SessionFactory sessionFactory);

}

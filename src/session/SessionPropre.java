package session;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.SessionFactory;

public class SessionPropre {
	
	private static SessionFactory sessionFactory=null;
	Transaction transaction = null;
	
	try {
		SessionFactory sessionFactory = new Configuration()
    		    .configure("DAO/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
		// start a transaction
		transaction = session.beginTransaction();
	} catch (Exception e) {
		if (transaction != null) {
			transaction.rollback();
		}
		e.printStackTrace();
	}
	
}

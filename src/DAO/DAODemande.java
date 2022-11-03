package DAO;

import java.sql.*;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.mindrot.jbcrypt.BCrypt;

import Beans.Citoyen;
import Beans.Demande;






public class DAODemande {

	
	public  static List<Demande> getAll() throws SQLException
	{
		List<Demande> demandes= null;
		Transaction transaction = null;
		
		try {
			SessionFactory sessionFactory = new Configuration()
	    		    .configure("DAO/hibernate.cfg.xml").buildSessionFactory();
	        Session session = sessionFactory.openSession();
			// start a transaction
			transaction = session.beginTransaction();
			// get an Demande object
			
			demandes = session.createQuery("from Demande").getResultList();
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return demandes;

	}
	
	public static Demande getUnique(int id) throws SQLException
	{
		Transaction transaction = null;
		Demande c = null;
		try {
			SessionFactory sessionFactory = new Configuration()
	    		    .configure("DAO/hibernate.cfg.xml").buildSessionFactory();
	        Session session = sessionFactory.openSession();
			// start a transaction
			transaction = session.beginTransaction();
			// get an Demande object
			c = session.get(Demande.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return c;
		

	}
	
	public static boolean ajouter(Demande c) throws SQLException
	 {
		Transaction transaction = null;
		try {
			SessionFactory sessionFactory = new Configuration()
	    		    .configure("DAO/hibernate.cfg.xml").buildSessionFactory();
	        Session session = sessionFactory.openSession();
			// start a transaction
			transaction = session.beginTransaction();
			// save the Demande object
			session.save(c);
			// commit transaction
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} 
		return false;
		
	 }

	 public static void modifier (Demande e1) throws SQLException
	 {	
			Transaction transaction = null;
			try {
				SessionFactory sessionFactory = new Configuration()
		    		    .configure("DAO/hibernate.cfg.xml").buildSessionFactory();
		        Session session = sessionFactory.openSession();
				// start a transaction
				transaction = session.beginTransaction();
				// save the Demande object
				session.update(e1);
				// commit transaction
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
	 }
	
	public static boolean supprimer(int id) throws SQLException {
		Transaction transaction = null;
		try  {
			SessionFactory sessionFactory = new Configuration()
	    		    .configure("DAO/hibernate.cfg.xml").buildSessionFactory();
	        Session session = sessionFactory.openSession();
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a Demande object
			Demande c = session.get(Demande.class, id);
			//System.out.println(c);
			if (c != null) {
				session.delete(c);
				System.out.println(" demande is deleted");
				return true;
			}
			else {
				System.out.println("demande n'existe pas");

			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;    
                
	}
	
	public static void main(String[] args) throws SQLException {
		
			// TODO Auto-generated method stub
		Citoyen a=new Citoyen("WA212","khalid","oussama","aimane@gmail.com","Casablanca","074323456","azerty");

			   Demande c=new Demande("declarer","qwerty","aswqd",a);
		       ajouter(c);
		/*List<Demande> demandes= new ArrayList<Demande>();
		demandes=getAll();
	   for(Demande c1:demandes)
	   	System.out.println(c1);
	     */
		
		//Demande c2=getUnique(4);
		//System.out.println(c2);
		//Scanner sc=new Scanner(System.in);
		//System.out.println("donner id du demande à supprimer");
		//int id = sc.nextInt();
		  //supprimer(id);
		       
			
		}
}
	
	
	


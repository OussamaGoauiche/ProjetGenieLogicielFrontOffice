package com.frontoffice.fontoffice;

import org.hibernate.HibernateException;
import org.hibernate.Session;    
import org.hibernate.SessionFactory;    
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.mindrot.jbcrypt.BCrypt;  
  
    
public class StoreData {    
@SuppressWarnings("deprecation")
public static void main(String[] args) {    
        
    Citoyan e1=new Citoyan();    
    e1.setId(1);    
    e1.setNom("Oussama");    
    e1.setPrenom("Chawla");  
    e1.setPhone("0616069043"); 
    e1.setCin("Q78322");
    e1.setAdress("yassmina 1 10 M ");
    e1.setEmail("OussamaGouaiche@gmail.com");
    //Hashing password 
    e1.setPassword(BCrypt.hashpw("Test", BCrypt.gensalt()));
    Transaction transaction = null;
    Citoyan e2 = e1;
    try {
    	SessionFactory sessionFactory = new Configuration()
    		    .configure("/com/frontoffice/fontoffice/hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
         transaction = session.beginTransaction();
        session.update(e2);
        //session.delete(e1);
        transaction.commit();
        session.close();

    } catch(HibernateException e) {
        if(transaction != null)
        	transaction.rollback();
    }
        
}    
}  
package com.main.EvidentApp;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class App { 
/*
	public static void main(String[] args) {
		
		DbConnectionHandler handler = new DbConnectionHandler();
		ResultSet res;
		
		
		try {
			res = handler.diplayUsers();
			while(res.next()){
				System.out.println(res.getString("fname") + " " + res.getString("lname"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		


	}
	*/
	
	
	
    private static SessionFactory sessionFactory = null;  
    private static ServiceRegistry serviceRegistry = null;  
       
    private static SessionFactory configureSessionFactory() throws HibernateException {  
        Configuration cfg = new Configuration().configure();  
         
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                cfg.getProperties()).build();
        
        sessionFactory = cfg.buildSessionFactory(serviceRegistry);  
         
        return sessionFactory;  
    }
     
    public static void main(String[] args) {
        // Configure the session factory
        configureSessionFactory();
         
        Session session = null;
        Transaction tx=null;
         
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
             
            // Creating Contact entity that will be save to the sqlite database
            ClientData client1 = new ClientData(3, "Name 3", "Surname3",100,"555444333","clientella3@email.com");
            ClientData client2 = new ClientData(44, "Name 44", "Surname44",144,"333222111","clientella44@email.com");
             
            // Saving to the database
            session.save(client1);
            session.save(client2);
             
            // Committing the change in the database.
            session.flush();
            tx.commit();
             
            // Fetching saved data
            List<ClientData> clientsLinst = session.createQuery("from ClientData").list();
             
            for (ClientData client : clientsLinst) {
                System.out.println("Id: " + client.getId() + " | Name:"  + client.getName() + " | Email:" + client.getEmail());
            }
             
        } catch (Exception ex) {
            ex.printStackTrace();
             
            // Rolling back the changes to make the data consistent in case of any failure 
            // in between multiple database write operations.
            tx.rollback();
        } finally{
            if(session != null) {
                session.close();
            }
        }
    }

}

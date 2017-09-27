package com.main.EvidentApp;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class App { 
	
    private static SessionFactory sessionFactory = null;  
    private static ServiceRegistry serviceRegistry = null;  
    private static Session session = null;
    private static Transaction tx=null;
       
    private static SessionFactory configureSessionFactory() throws HibernateException {  	
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().
            		configure("hibernate.cfg.xml").build();
            Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();
            return sessionFactory;
        } 
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
     
    private static void saveClientData(ClientData data){
    	// TODO:
    	// Do other actions before saving
    	
    	try {
    		session = sessionFactory.openSession();
    		tx = session.beginTransaction();
            // Saving to the database
            session.save(data);
            // Committing the change in the database.
            session.flush();
            tx.commit();
    		
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
    
    private static void displayAll(){
        try {
            session = sessionFactory.openSession();
             
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
    
    public static void main(String[] args) {
        // Configure the session factory
        configureSessionFactory();
           
		// Creating Contact entity that will be save to the sqlite database
		ClientData client1 = new ClientData(1, "Name 7", "Surname3",100,"555444333","sharing3@email.com");
		ClientData client2 = new ClientData(2, "Name 884", "Surname44",144,"333222111","telling44@email.com");
		 
		
		saveClientData(client1);
		saveClientData(client2);
		
		
		displayAll();
            

    }

}

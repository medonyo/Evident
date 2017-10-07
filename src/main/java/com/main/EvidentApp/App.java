package com.main.EvidentApp;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.evident.db.DbConnectionHandler;

//@WebServlet(urlPatterns = "/client_view")
public class App extends HttpServlet { 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//resp.getWriter().println("TESTING_TESTING___......");
		//resp.getWriter().println(new Date(0));
		req.setAttribute("client_name", "client_got_fro_DB");
		req.getRequestDispatcher("/WEB-INF/views/client_view.jsp").forward(req, resp);
	}
/*	
	private static DbConnectionHandler connection;
    
    public static void main(String[] args) {
        // Configure the session factory
    	connection.configureSessionFactory();
           
		// Creating Contact entity that will be save to the sqlite database
		ClientData client1 = new ClientData(1, "Name 7", "Surname3",100,"555444333","sharing3@email.com");
		ClientData client2 = new ClientData(2, "Name 884", "Surname44",144,"333222111","telling44@email.com");
		 
		
		connection.saveClientData(client1);
		connection.saveClientData(client2);
		
		
		connection.displayAll();
            

    }
*/
}

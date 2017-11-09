package com.main.EvidentApp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.evident.db.DbConnectionHandler;

//import com.evident.db.DbConnectionHandler;

public class App extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
            IOException {

        DbConnectionHandler connection = null;
        req.setAttribute("client_name", connection.getUser());

        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/WEB-INF/views/client_view.jsp");
        rd.forward(req, resp);
    }

    private static void ExecuteTransaction() {

        DbConnectionHandler connection = null;

        // Configure the session factory
        connection.configureSessionFactory();

        // Creating Contact entity that will be save to the sqlite database
        ClientData client1 = new ClientData(1, "Name 7", "Surname3", 100, "555444333",
                "sharing3@email.com");
        ClientData client2 = new ClientData(2, "Name 884", "Surname44", 144, "333222111",
                "telling44@email.com");

        connection.saveClientData(client1);
        connection.saveClientData(client2);

        connection.displayAll();
    }
}

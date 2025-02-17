package com.example.servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(urlPatterns={"/salutations"})
public class SalutationsServlet extends HttpServlet {
    public void service( HttpServletRequest request,
                         HttpServletResponse response )
            throws ServletException, IOException {
        response.setContentType( "text/html" );
        PrintWriter out = response.getWriter();
        String nom = request.getParameter( "nom" );
        String prenom = request.getParameter( "prenom" );
        out.println( "<html><body>" );
        out.println( "<h1>Bonjour " + prenom + " " + nom + "</h1>" );
        out.println( "</body></html>" );
    }
}

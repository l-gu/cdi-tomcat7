package org.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.demo.service.ReverseService;

/**
 * Reverse servlet (uses injected service)
 * 
 * @author L. Guerin
 *
 */
@WebServlet( urlPatterns = {"/reverse"} )

public class ReverseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ReverseService service ;
	
    /**
     * Default constructor. 
     */
    public ReverseServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process( request, response) ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process( request, response) ;
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter() ;
		String s = request.getParameter("name");
		if ( null == s ) {
			s = "" ;
		}
		out.println("<h3>Original name : '" + s + "' </h3>");
		out.println("<h3>Reversed name : '" + service.reverse(s) + "' </h3>");
		out.close();
	}
}

package com.natcorp.userWebForm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private DataSource dataSource;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "LogIn";
	}
	@RequestMapping(value = "LogIn", method = RequestMethod.GET)
	public String home3(Locale locale, Model model) {
		return "LogIn";
	}
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home2(Locale locale, Model model) {
		return "home";
	}
	@RequestMapping(value = "createUser", method = RequestMethod.POST)
	protected String doPost(Model m, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
			response.setContentType("text/html");
			String n1=request.getParameter("nameInput");
			String n2=request.getParameter("password");
			String n3=request.getParameter("usernameInput");
			userObject newUser = new userObject();
			newUser.setName(n1);
			newUser.setPassword(n2);
			newUser.setUsername(n3);
			
			Connection c;
			try {
				System.out.println("hey");
				c = dataSource.getConnection();
				Statement s = c.createStatement();
				String sqlString = "INSERT INTO users VALUES('"+newUser.getUsername()+"', '"+newUser.getPassword()+"', '"+newUser.getName()+"');";
				s.executeUpdate(sqlString);
				m.addAttribute("msg", n1);
				return "Done";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Fail";
			}
		
	}
	@RequestMapping(value = "doLogIn", method = RequestMethod.POST)
	protected String doPost2(Model m,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
			response.setContentType("text/html");
			String n2=request.getParameter("password");
			String n3=request.getParameter("usernameInput");
			Connection c;
			try {
				System.out.println("hey");
				c = dataSource.getConnection();
				Statement s = c.createStatement();
				String sqlString = "SELECT username, password, name FROM users WHERE username = '"+n3+"' AND password = '"+n2+"';";
				ResultSet rs = s.executeQuery(sqlString);
				if(rs.next()){
					m.addAttribute("msg", rs.getString("name"));
					return "Done";
				} else {


					return "failLog";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "failLog";
			}
		
	}
	
}

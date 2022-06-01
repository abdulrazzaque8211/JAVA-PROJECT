
package com.pro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pro.bean.UserBean;
import com.pro.dao.InsertDao;
import com.pro.daoImpl.InsertDaoImpl;

/**
 * Servlet implementation class InsertController
 */
@WebServlet("/InsertController")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int i = Integer.parseInt(request.getParameter("id"));
		UserBean userBean = new UserBean();
		userBean.setId(i);
		InsertDao daoImpl = new InsertDaoImpl();
		boolean b = true;

		if (!b == false) {
			daoImpl.delete(userBean);
		}
		response.sendRedirect("crud.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserBean userBean = new UserBean();
		InsertDao daoImpl = new InsertDaoImpl();
		int id = Integer.parseInt(request.getParameter("id")); 
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("password");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String age = request.getParameter("age");
		String button = request.getParameter("submit");
		System.out.println(id);
		userBean.setId(id);
		userBean.setUname(uname);
		userBean.setPwd(pwd);
		userBean.setEmail(email);
		userBean.setContact(contact);
		userBean.setAge(Integer.parseInt(request.getParameter("age")));
		if (button.equals("Save")) {
			daoImpl.insert(userBean);
		} else if (button.equals("update")) {
			daoImpl.update(userBean);
			System.out.println(button);
		}
		response.sendRedirect("crud.jsp");
	}

}

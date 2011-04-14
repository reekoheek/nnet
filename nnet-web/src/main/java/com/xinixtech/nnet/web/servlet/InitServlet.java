package com.xinixtech.nnet.web.servlet;

import javax.servlet.ServletException;

import com.xinixtech.nnet.web.nnet.NNet;

/**
 * Servlet implementation class for Servlet: InitServlet
 * 
 */
public class InitServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	static final long serialVersionUID = 1L;

	public void init() throws ServletException {
		super.init();
		NNet.getInstance();
	}
}
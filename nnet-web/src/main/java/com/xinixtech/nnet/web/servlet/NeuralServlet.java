package com.xinixtech.nnet.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.xinixtech.nnet.model.MqForex;
import com.xinixtech.nnet.web.nnet.NNet;

/**
 * Servlet implementation class for Servlet: NeuralServlet
 * 
 */
public class NeuralServlet extends javax.servlet.http.HttpServlet implements
		javax.servlet.Servlet {
	private static final long serialVersionUID = 1L;

	private static final Log log = LogFactory.getLog(NeuralServlet.class);

	private static NNet nnet;

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#HttpServlet()
	 */
	public NeuralServlet() {
		super();
	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/plain");

		double high = Double.parseDouble(request.getParameter("high"));
		double low = Double.parseDouble(request.getParameter("low"));
		double open = Double.parseDouble(request.getParameter("open"));
		double close = Double.parseDouble(request.getParameter("close"));
		double median = Double.parseDouble(request.getParameter("median"));
		double sma5 = Double.parseDouble(request.getParameter("sma5"));
		double sma10 = Double.parseDouble(request.getParameter("sma10"));
		double sma20 = Double.parseDouble(request.getParameter("sma20"));
		double rsi12 = Double.parseDouble(request.getParameter("rsi12"));

		try {
			MqForex node = new MqForex();
			node.setHigh(high);
			node.setLow(low);
			node.setOpen(open);
			node.setClose(close);
			node.setMedian(median);
			node.setSma5(sma5);
			node.setSma10(sma10);
			node.setSma20(sma20);
			node.setRsi12(rsi12);

			nnet = NNet.getInstance();

			double[] results = nnet.forward(new double[] { node.getSma5(),
					node.getSma10(), node.getSma20(),
					(node.getOpen() - node.getClose()),
					(node.getMedian() - node.getSma5()) });
			double result = results[0];
			log.info("================ Result:" + result);

			out.println("result=" + result);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}

	}

	/*
	 * (non-Java-doc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest request,
	 *      HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
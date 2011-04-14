package com.xinixtech.nnet.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joone.engine.NeuralNetEvent;
import org.joone.engine.NeuralNetListener;

public class CustomNNListener implements NeuralNetListener {
	private static Log log = LogFactory.getLog(CustomNNListener.class);
	
	public void cicleTerminated(NeuralNetEvent evt) {
		// TODO Auto-generated method stub
		log.info("Terminated");
		log.info(evt);
		
	}

	public void errorChanged(NeuralNetEvent evt) {
		// TODO Auto-generated method stub
		log.info("Error changed");
	}

	public void netStarted(NeuralNetEvent evt) {
		// TODO Auto-generated method stub
		log.info("Net started");
	}

	public void netStopped(NeuralNetEvent evt) {
		// TODO Auto-generated method stub
		log.info("Net stopped");
	}

	public void netStoppedError(NeuralNetEvent evt, String str) {
		// TODO Auto-generated method stub
		log.info("Net stopped error");
	}

}

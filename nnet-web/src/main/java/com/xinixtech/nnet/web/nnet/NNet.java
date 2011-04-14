package com.xinixtech.nnet.web.nnet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.joone.engine.DirectSynapse;
import org.joone.engine.Pattern;
import org.joone.helpers.factory.JooneTools;
import org.joone.net.NeuralNet;

public class NNet {
	private static final Log log = LogFactory.getLog(NNet.class);

	private NeuralNet net;

	private DirectSynapse input;

	private DirectSynapse output;

	private NNet() {
		try {
			net = JooneTools.load("D:\\Desktop\\nnet.snet").cloneNet();
			net.removeAllInputs();
			net.removeAllOutputs();
//			log.info(net);

			input = new DirectSynapse();
			output = new DirectSynapse();
			net.addInputSynapse(input);
			net.addOutputSynapse(output);
			net.go();
		} catch (Exception e) {
			log.info(e.getMessage(), e);
		}

	}

	public static NNet getInstance() {
		return NNetFactory.nnet;
	}

	private static class NNetFactory {
		private static NNet nnet = new NNet();
	}

	public double[] forward(double[] inputArray) {
		Pattern inputPattern = new Pattern(inputArray);
		input.fwdPut(inputPattern);
		Pattern outputPattern = output.fwdGet();
		return outputPattern.getArray();
	}
}

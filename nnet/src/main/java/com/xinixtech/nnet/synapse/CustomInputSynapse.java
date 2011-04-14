package com.xinixtech.nnet.synapse;

import java.io.IOException;

import org.joone.io.InputSynapse;
import org.joone.util.PlugInEvent;

public class CustomInputSynapse implements InputSynapse {
	@SuppressWarnings("unused")
	private int line = 0;
	@SuppressWarnings("unused")
	private int column;

	public char getDecimalPoint() {
		return ',';

	}

	public int getFirstCol() {
		return 0;
	}

	public int getFirstRow() {
		return 0;
	}

	public int getLastCol() {
		return 0;
	}

	public int getLastRow() {
		return 0;
	}

	public void gotoFirstLine() throws IOException {
		this.line = 0;
	}

	public void gotoLine(int line) throws IOException {
		this.line = line;
	}

	public boolean isBuffered() {
		return false;
	}

	public boolean isEOF() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isStepCounter() {
		// TODO Auto-generated method stub
		return false;
	}

	public void readAll() {
		// TODO Auto-generated method stub

	}

	public void resetInput() {
		// TODO Auto-generated method stub

	}

	public void setBuffered(boolean arg0) {

	}

	public void setDecimalPoint(char arg0) {

	}

	public void setFirstCol(int column) throws IllegalArgumentException {

	}

	public void setFirstRow(int arg0) {

	}

	public void setLastCol(int arg0) throws IllegalArgumentException {
		// TODO Auto-generated method stub

	}

	public void setLastRow(int arg0) {
		// TODO Auto-generated method stub

	}

	public void setStepCounter(boolean arg0) {
		// TODO Auto-generated method stub

	}

	public void dataChanged(PlugInEvent arg0) {
		// TODO Auto-generated method stub

	}

}

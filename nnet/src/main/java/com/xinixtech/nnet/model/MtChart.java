package com.xinixtech.nnet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mt_chart")
public class MtChart {
	@Id
	@GeneratedValue
	private int id;

	private String symbol;

	private double point;

	private double spread;

	private int timeframe;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getPoint() {
		return point;
	}

	public void setPoint(double point) {
		this.point = point;
	}

	public double getSpread() {
		return spread;
	}

	public void setSpread(double spread) {
		this.spread = spread;
	}

	public int getTimeframe() {
		return timeframe;
	}

	public void setTimeframe(int timeframe) {
		this.timeframe = timeframe;
	}

}

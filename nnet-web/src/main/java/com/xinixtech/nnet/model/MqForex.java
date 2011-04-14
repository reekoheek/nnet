package com.xinixtech.nnet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "mq_forex")
public class MqForex {
	@Id
	@GeneratedValue
	private long id;

	private String symbol;

	@Column(name = "time_seri")
	private int timeSeri;

	private long itime;

	private double high;

	private double low;

	private double open;

	private double close;

	private double median;

	private double sma5;

	private double sma10;

	private double sma20;

	private double rsi12;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public int getTimeSeri() {
		return timeSeri;
	}

	public void setTimeSeri(int timeSeri) {
		this.timeSeri = timeSeri;
	}

	public long getItime() {
		return itime;
	}

	public void setItime(long itime) {
		this.itime = itime;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public double getSma5() {
		return sma5;
	}

	public void setSma5(double sma5) {
		this.sma5 = sma5;
	}

	public double getSma10() {
		return sma10;
	}

	public void setSma10(double sma10) {
		this.sma10 = sma10;
	}

	public double getSma20() {
		return sma20;
	}

	public void setSma20(double sma20) {
		this.sma20 = sma20;
	}

	public double getMedian() {
		return median;
	}

	public void setMedian(double median) {
		this.median = median;
	}

	public double getRsi12() {
		return rsi12;
	}

	public void setRsi12(double rsi12) {
		this.rsi12 = rsi12;
	}

}
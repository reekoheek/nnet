package com.xinixtech.nnet.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class MtNode {
	@Id
	@GeneratedValue
	private long id;

	private long itime;

	@Column(name = "next_open")
	private double nextOpen;

	private double high_0;

	private double low_0;

	private double open_0;

	private double close_0;

	private double sma2_0;

	private double sma3_0;

	private double sma5_0;

	private double rsi14_0;

	private double cci12_0;

	// //////////

	private double high_1;

	private double low_1;

	private double open_1;

	private double close_1;

	private double sma2_1;

	private double sma3_1;

	private double sma5_1;

	private double rsi14_1;

	private double cci12_1;

	// //////////

	private double high_2;

	private double low_2;

	private double open_2;

	private double close_2;

	private double sma2_2;

	private double sma3_2;

	private double sma5_2;

	private double rsi14_2;

	private double cci12_2;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getItime() {
		return itime;
	}

	public void setItime(long itime) {
		this.itime = itime;
	}

	public double getNextOpen() {
		return nextOpen;
	}

	public void setNextOpen(double nextOpen) {
		this.nextOpen = nextOpen;
	}

	public double getHigh_0() {
		return high_0;
	}

	public void setHigh_0(double high_0) {
		this.high_0 = high_0;
	}

	public double getLow_0() {
		return low_0;
	}

	public void setLow_0(double low_0) {
		this.low_0 = low_0;
	}

	public double getOpen_0() {
		return open_0;
	}

	public void setOpen_0(double open_0) {
		this.open_0 = open_0;
	}

	public double getClose_0() {
		return close_0;
	}

	public void setClose_0(double close_0) {
		this.close_0 = close_0;
	}

	public double getSma2_0() {
		return sma2_0;
	}

	public void setSma2_0(double sma2_0) {
		this.sma2_0 = sma2_0;
	}

	public double getSma3_0() {
		return sma3_0;
	}

	public void setSma3_0(double sma3_0) {
		this.sma3_0 = sma3_0;
	}

	public double getSma5_0() {
		return sma5_0;
	}

	public void setSma5_0(double sma5_0) {
		this.sma5_0 = sma5_0;
	}

	public double getRsi14_0() {
		return rsi14_0;
	}

	public void setRsi14_0(double rsi14_0) {
		this.rsi14_0 = rsi14_0;
	}

	public double getCci12_0() {
		return cci12_0;
	}

	public void setCci12_0(double cci12_0) {
		this.cci12_0 = cci12_0;
	}

	public double getHigh_1() {
		return high_1;
	}

	public void setHigh_1(double high_1) {
		this.high_1 = high_1;
	}

	public double getLow_1() {
		return low_1;
	}

	public void setLow_1(double low_1) {
		this.low_1 = low_1;
	}

	public double getOpen_1() {
		return open_1;
	}

	public void setOpen_1(double open_1) {
		this.open_1 = open_1;
	}

	public double getClose_1() {
		return close_1;
	}

	public void setClose_1(double close_1) {
		this.close_1 = close_1;
	}

	public double getSma2_1() {
		return sma2_1;
	}

	public void setSma2_1(double sma2_1) {
		this.sma2_1 = sma2_1;
	}

	public double getSma3_1() {
		return sma3_1;
	}

	public void setSma3_1(double sma3_1) {
		this.sma3_1 = sma3_1;
	}

	public double getSma5_1() {
		return sma5_1;
	}

	public void setSma5_1(double sma5_1) {
		this.sma5_1 = sma5_1;
	}

	public double getRsi14_1() {
		return rsi14_1;
	}

	public void setRsi14_1(double rsi14_1) {
		this.rsi14_1 = rsi14_1;
	}

	public double getCci12_1() {
		return cci12_1;
	}

	public void setCci12_1(double cci12_1) {
		this.cci12_1 = cci12_1;
	}

	public double getHigh_2() {
		return high_2;
	}

	public void setHigh_2(double high_2) {
		this.high_2 = high_2;
	}

	public double getLow_2() {
		return low_2;
	}

	public void setLow_2(double low_2) {
		this.low_2 = low_2;
	}

	public double getOpen_2() {
		return open_2;
	}

	public void setOpen_2(double open_2) {
		this.open_2 = open_2;
	}

	public double getClose_2() {
		return close_2;
	}

	public void setClose_2(double close_2) {
		this.close_2 = close_2;
	}

	public double getSma2_2() {
		return sma2_2;
	}

	public void setSma2_2(double sma2_2) {
		this.sma2_2 = sma2_2;
	}

	public double getSma3_2() {
		return sma3_2;
	}

	public void setSma3_2(double sma3_2) {
		this.sma3_2 = sma3_2;
	}

	public double getSma5_2() {
		return sma5_2;
	}

	public void setSma5_2(double sma5_2) {
		this.sma5_2 = sma5_2;
	}

	public double getRsi14_2() {
		return rsi14_2;
	}

	public void setRsi14_2(double rsi14_2) {
		this.rsi14_2 = rsi14_2;
	}

	public double getCci12_2() {
		return cci12_2;
	}

	public void setCci12_2(double cci12_2) {
		this.cci12_2 = cci12_2;
	}

}
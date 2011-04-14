package com.xinixtech.nnet.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

@Entity()
@Table(name = "mq_train")
@org.hibernate.annotations.Table(appliesTo = "mq_train", indexes = { @Index(name = "INDEX_ITIME", columnNames = { "itime" }) })
public class MtTrain extends MtNode {
	double bid;
	
	double buy;
	
	double sell;

	public double getBuy() {
		return buy;
	}

	public void setBuy(double buy) {
		this.buy = buy;
	}

	public double getSell() {
		return sell;
	}

	public void setSell(double sell) {
		this.sell = sell;
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}
}
package com.xinixtech.nnet.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Index;

@Entity
@Table(name = "mt_forex")
@org.hibernate.annotations.Table(appliesTo = "mq_forex", indexes = { @Index(name = "INDEX_ITIME", columnNames = { "itime" }) })
public class MtForex extends MtNode {
	@ManyToOne
	@JoinColumn(name = "chart_id", nullable = false)
	private MtChart chart;

	public MtChart getChart() {
		return chart;
	}

	public void setChart(MtChart chart) {
		this.chart = chart;
	}
}
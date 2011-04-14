package com.xinixtech.nnet;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.xinixtech.nnet.dao.AbstractDao;
import com.xinixtech.nnet.model.MtForex;
import com.xinixtech.nnet.model.MtTrain;

public class Feed extends AbstractDao {
	private static final int MAX_RESULTS = 100;

	@SuppressWarnings("unused")
	private static Log log = LogFactory.getLog(Feed.class);

	private static double TP = 60.0;
	private static double SL = 30.0;

	// public static void main(String[] args) throws Exception {
	// Feed feed = Feed.getInstance();
	// feed.calculate();
	// }
	//
	// @SuppressWarnings("unchecked")
	// public void calculate() throws Exception {
	// int firstResult = 0;
	// List<MtForex> list = new ArrayList<MtForex>();
	//
	// do {
	// Transaction tx = getSession().beginTransaction();
	// Query query = getSession().createQuery(
	// "from MqForex order by itime");
	// query.setFirstResult(firstResult);
	// query.setMaxResults(MAX_RESULTS);
	// list = query.list();
	//
	// log.info("First result: " + firstResult);
	// firstResult = firstResult + MAX_RESULTS;
	//
	// for (MtForex node : list) {
	// double high = node.getHigh();
	// double low = node.getLow();
	// double points = node.getPoint();
	// double spreads = node.getSpread();
	// for (double bid = low; bid <= high; bid += points) {
	// MtTrain result = new MtTrain();
	// PropertyUtils.copyProperties(result, node);
	// result.setBid(bid);
	//
	// MtTrain targetBuy = targetBuy(node, bid + spreads, bid);
	// if (targetBuy != null) {
	// if (targetBuy.getBuy() == 1) {
	// // log.info("TP at itime: " + targetBuy.getItime()
	// // + " high: " + correctDouble(targetBuy.getHigh())
	// // + " low: "
	// // + correctDouble(targetBuy.getLow()));
	// } else {
	// // log.info("SL at itime: " + targetBuy.getItime()
	// // + " high: " + correctDouble(targetBuy.getHigh())
	// // + " low: "
	// // + correctDouble(targetBuy.getLow()));
	// }
	// result.setBuy(targetBuy.getBuy());
	// } else {
	// // log.info("Unreachable");
	// result.setBuy(0);
	// }
	//
	// MtTrain targetSell = targetSell(node, bid + spreads, bid);
	// if (targetSell != null) {
	// if (targetSell.getSell() == 1) {
	// // log.info("TP at itime: " + targetSell.getItime()
	// // + " high: " +
	// // correctDouble(targetSell.getHighAsk())
	// // + " low: " +
	// // correctDouble(targetSell.getLowAsk()));
	// } else {
	// // log.info("SL at itime: " + targetSell.getItime()
	// // + " high: " +
	// // correctDouble(targetSell.getHighAsk())
	// // + " low: " +
	// // correctDouble(targetSell.getLowAsk()));
	// }
	// result.setSell(targetSell.getSell());
	// } else {
	// // log.info("Unreachable");
	// result.setSell(0);
	// }
	//
	// // log.info("[" + result.getBuy() + ", " + result.getSell()
	// // + "]");
	//					
	// getSession().save(result);
	// }
	// }
	// tx.commit();
	// tx = null;
	// setSession(null);
	// } while (list.size() > 0);
	//
	// }
	//
	// @SuppressWarnings("unchecked")
	// public MtTrain targetBuy(MtForex node, double ask, double bid)
	// throws Exception {
	// // log.info("Buy on itime: " + node.getItime() + " ask: "
	// // + correctDouble(ask));
	// MtTrain scenarioTPBuy = scenarioTPBuy(node, ask, bid);
	// MtTrain scenarioSLBuy = scenarioSLBuy(node, ask, bid);
	// if (scenarioTPBuy == null && scenarioSLBuy == null) {
	// return null;
	// } else if (scenarioTPBuy == null) {
	// return scenarioSLBuy;
	// } else if (scenarioSLBuy == null) {
	// return scenarioTPBuy;
	// } else if (scenarioTPBuy.getItime() < scenarioSLBuy.getItime()) {
	// return scenarioTPBuy;
	// } else if (scenarioTPBuy.getItime() > scenarioSLBuy.getItime()) {
	// return scenarioSLBuy;
	// } else {
	// return null;
	// }
	// }
	//
	// @SuppressWarnings("unchecked")
	// public MtTrain targetSell(MtForex node, double ask, double bid)
	// throws Exception {
	// // log.info("Sell on itime: " + node.getItime() + " bid: "
	// // + correctDouble(bid));
	// MtTrain scenarioTPSell = scenarioTPSell(node, ask, bid);
	// MtTrain scenarioSLSell = scenarioSLSell(node, ask, bid);
	// if (scenarioTPSell == null && scenarioSLSell == null) {
	// return null;
	// } else if (scenarioTPSell == null) {
	// return scenarioSLSell;
	// } else if (scenarioSLSell == null) {
	// return scenarioTPSell;
	// } else if (scenarioTPSell.getItime() < scenarioSLSell.getItime()) {
	// return scenarioTPSell;
	// } else if (scenarioTPSell.getItime() > scenarioSLSell.getItime()) {
	// return scenarioSLSell;
	// } else {
	// return null;
	// }
	// }
	//
	// @SuppressWarnings("unchecked")
	// public MtTrain scenarioTPBuy(MtForex node, double ask, double bid)
	// throws Exception {
	// double tpRange = TP * node.getPoint();
	// double futureBid = ask + tpRange;
	//
	// // log.info("TP bid: " + correctDouble(futureBid));
	//		
	// String hql = "from MqForex where " + "high >= :futureBid and "
	// + "itime > :itime " + "order by itime";
	// Query query = getSession().createQuery(hql);
	// query.setDouble("futureBid", futureBid);
	// query.setLong("itime", node.getItime());
	// query.setMaxResults(1);
	// List<MtForex> list = query.list();
	//
	// if (list != null && list.size() > 0) {
	// MtTrain result = new MtTrain();
	// PropertyUtils.copyProperties(result, list.get(0));
	// result.setBuy(1);
	// return result;
	// }
	// return null;
	// }
	//
	// @SuppressWarnings("unchecked")
	// public MtTrain scenarioSLBuy(MtForex node, double ask, double bid)
	// throws Exception {
	// double slRange = SL * node.getPoint();
	// double futureBid = ask - slRange;
	//
	// // log.info("SL bid: " + correctDouble(futureBid));
	//		
	// String hql = "from MqForex where " + "low <= :futureBid and "
	// + "itime > :itime " + "order by itime";
	// Query query = getSession().createQuery(hql);
	// query.setDouble("futureBid", futureBid);
	// query.setLong("itime", node.getItime());
	// query.setMaxResults(1);
	// List<MtForex> list = query.list();
	//
	// if (list != null && list.size() > 0) {
	// MtTrain result = new MtTrain();
	// PropertyUtils.copyProperties(result, list.get(0));
	// result.setBuy(0);
	// return result;
	// }
	// return null;
	// }
	//
	// @SuppressWarnings("unchecked")
	// public MtTrain scenarioTPSell(MtForex node, double ask, double bid)
	// throws Exception {
	// double tpRange = TP * node.getPoint();
	// double futureAsk = bid - tpRange;
	//
	// // log.info("TP ask: " + correctDouble(futureAsk));
	//
	// String hql = "from MqForex where " + "low + spreads <= :futureAsk and "
	// + "itime > :itime " + "order by itime";
	// Query query = getSession().createQuery(hql);
	// query.setDouble("futureAsk", futureAsk);
	// query.setLong("itime", node.getItime());
	// query.setMaxResults(1);
	// List<MtForex> list = query.list();
	//
	// if (list != null && list.size() > 0) {
	// MtTrain result = new MtTrain();
	// PropertyUtils.copyProperties(result, list.get(0));
	// result.setSell(1);
	// return result;
	// }
	// return null;
	// }
	//
	// @SuppressWarnings("unchecked")
	// public MtTrain scenarioSLSell(MtForex node, double ask, double bid)
	// throws Exception {
	// double slRange = SL * node.getPoint();
	// double futureAsk = bid + slRange;
	//
	// // log.info("SL ask: " + correctDouble(futureAsk));
	//
	// String hql = "from MqForex where "
	// + "high + spreads >= :futureAsk and " + "itime > :itime "
	// + "order by itime";
	// Query query = getSession().createQuery(hql);
	// query.setDouble("futureAsk", futureAsk);
	// query.setLong("itime", node.getItime());
	// query.setMaxResults(1);
	// List<MtForex> list = query.list();
	//
	// if (list != null && list.size() > 0) {
	// MtTrain result = new MtTrain();
	// PropertyUtils.copyProperties(result, list.get(0));
	// result.setSell(0);
	// return result;
	// }
	// return null;
	// }
	//
	// private static class FeedFactory {
	// public static Feed instance = new Feed();
	// }
	//
	// public static Feed getInstance() {
	// return FeedFactory.instance;
	// }

}

package com.xinixtech.nnet;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.xinixtech.nnet.dao.AbstractDao;
import com.xinixtech.nnet.model.MtChart;
import com.xinixtech.nnet.model.MtForex;

public class ImportData extends AbstractDao {
	@SuppressWarnings("unused")
	private static Log log = LogFactory.getLog(ImportData.class);

	private static String FIELDS[] = { "itime", "nextOpen", "high_0", "low_0", "open_0", "close_0", "sma2_0", "sma3_0",
			"sma5_0", "rsi14_0", "cci12_0", "high_1", "low_1", "open_1", "close_1", "sma2_1", "sma3_1", "sma5_1",
			"rsi14_1", "cci12_1", "high_2", "low_2", "open_2", "close_2", "sma2_2", "sma3_2", "sma5_2", "rsi14_2",
			"cci12_2" };

	private static final String DIRNAME = "C:\\Program Files\\MetaTrader - Askap\\tester\\files";

	private static final String CHART_SYMBOL = "GBPUSD";

	private static final double CHART_POINT = 0.0001;

	private static final double CHART_SPREAD = 0.0005;

	private static final int CHART_TIMEFRAME = 5;

	private static final int PAGING = 10000;

	public static void main(String[] args) throws Exception {
		ImportData importData = new ImportData();
		importData.importData();
	}

	@SuppressWarnings("unchecked")
	public void importData() {
		String rows[];
		String strLine;
		Transaction tx;
		int iteration = 0;

		try {
			java.text.DecimalFormat df = new java.text.DecimalFormat("0.0000");
			
			String filename = DIRNAME + "\\" + CHART_SYMBOL + "-" + df.format(CHART_POINT) + "-" + df.format(CHART_SPREAD) + "-"
					+ CHART_TIMEFRAME + "-1.txt";
			log.info("file:" + filename);
			

			FileInputStream fstream = new FileInputStream(filename);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			tx = getSession().beginTransaction();
			
			MtChart chart;
			
			Criteria criteria = getSession().createCriteria(MtChart.class);
			criteria.add(Restrictions.eq("symbol", CHART_SYMBOL));
			criteria.add(Restrictions.eq("point", CHART_POINT));
			criteria.add(Restrictions.eq("spread", CHART_SPREAD));
			criteria.add(Restrictions.eq("timeframe", CHART_TIMEFRAME));
			List<MtChart> list = criteria.list();
			if (list != null && list.size() > 0) {
				chart = list.get(0);
			} else {
				chart = new MtChart();
				chart.setSymbol(CHART_SYMBOL);
				chart.setPoint(CHART_POINT);
				chart.setSpread(CHART_SPREAD);
				chart.setTimeframe(CHART_TIMEFRAME);
				
				getSession().save(chart);
				tx.commit();
				tx.begin();
			}

			while ((strLine = br.readLine()) != null) {
				// log.info(strLine);
				rows = strLine.split(";");
				MtForex node = new MtForex();
				for (int i = 0; i < FIELDS.length; i++) {
					try {
						if ("itime".equals(FIELDS[i])) {
							PropertyUtils.setProperty(node, FIELDS[i], Long.parseLong(rows[i]));
						} else {
							PropertyUtils.setProperty(node, FIELDS[i], Double.parseDouble(rows[i]));
						}
					} catch (Exception e) {
						log.error("Cannot set property");
					}
				}
				node.setChart(chart);
				rows = null;

				getSession().save(node);

				iteration++;
				if (iteration % PAGING == 0) {
					tx.commit();
					setSession(null);
					tx = getSession().beginTransaction();
					log.info(iteration);
					// System.gc();
				}
			}
			in.close();

			tx.commit();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}

	}
}

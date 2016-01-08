/**
 * Copyright (c) 2013, iquesters - All Rights Reserved.
 */
package org.iq.util;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.iq.valueobject.BaseVO;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

/**
 * @author Sam
 */
public abstract class CsvObject<T extends BaseVO> implements Cloneable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6560452868022528053L;

	protected List<T> recordsList = null;

	private Map<String, String> columnMapping;

	public CsvObject(String csvFileContent, Class<T> tclass) throws IOException {
		this.columnMapping = new HashMap<String, String>();

		CSVReader csvReader = new CSVReader(new StringReader(csvFileContent));

		CsvToBean<T> csvToBean = new CsvToBean<T>();

		prepareColumnMapping();

		HeaderColumnNameTranslateMappingStrategy<T> strategy = new HeaderColumnNameTranslateMappingStrategy<T>();
		strategy.setType(tclass);
		strategy.setColumnMapping(columnMapping);

		this.recordsList = csvToBean.parse(strategy, csvReader);
	}

	public List<T> getRecords() {
		return recordsList;
	}

	public T getRecord(int rowNum) {
		int recordCount = 0;
		for (; recordCount < recordsList.size() && recordCount < rowNum; recordCount++)
			;
		return recordsList.get(recordCount);
	}

	public void addColumnMapping(String csvHeading, String beanVarName) {
		columnMapping.put(csvHeading, beanVarName);
	}

	/**
	 * 
	 */
	public abstract void prepareColumnMapping();
}
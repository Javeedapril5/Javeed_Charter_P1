package com.reward.calculator.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

/**
 * Common Utilities class for the app.
 * @author atulsingh
 *
 */
@Service
public class CommonUtil {

	/**
	 * This method will return the Month String from date
	 * ex: Jan, Feb 
	 * @param date
	 * @return yyyy-MM
	 */
	public String getYearMonthFromDate(Date date) {
		SimpleDateFormat monthFormatter = new SimpleDateFormat("yyyy-MM");
		return monthFormatter.format(date);
	}
}

package com.reward.calculator.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reward.calculator.dto.RewardDetail;
import com.reward.calculator.service.RewardService;

/**
 * Rest API for the Reward Calculation
 * 
 * @author atulsingh
 *
 */
@RestController
public class RewardController {
	@Autowired
	RewardService rewardService;

	/**
	 * API for getting the reward detail for customer with date range. If date range
	 * not provided in request last 3 month reward calculated
	 * 
	 * @param customerId
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	@GetMapping("/reward/customer/{customerId}/reward-details")
	public ResponseEntity<RewardDetail> getRewardDetails(@PathVariable Long customerId,
			@RequestParam(name = "beginDate", required = false) @DateTimeFormat(iso = ISO.DATE) Date beginDate,
			@RequestParam(name = "endDate", required = false) @DateTimeFormat(iso = ISO.DATE) Date endDate) {
		if (null == beginDate || null == endDate) {
			endDate = new Date();
			beginDate = updateBeginDate(beginDate);
		}
		return new ResponseEntity<>(rewardService.getRewardDetails(customerId, beginDate, endDate), HttpStatus.OK);
	}

	/**
	 * Updating the begin date to 3 month before of null
	 * 
	 * @param beginDate
	 * @return
	 */
	private Date updateBeginDate(Date beginDate) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -3);
		return cal.getTime();
	}
}

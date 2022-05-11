package com.reward.calculator.service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reward.calculator.dto.RewardDetail;
import com.reward.calculator.model.Transaction;
import com.reward.calculator.repository.TransactionRepo;
import com.reward.calculator.util.CommonUtil;
import com.reward.calculator.util.RewardCalculator;

/**
 * Reward Service will be used to calculating and manipulating the reward
 * 
 * @author atulsingh
 *
 */
@Service
public class RewardService {
	@Autowired
	TransactionRepo transRepo;
	
	@Autowired
	RewardCalculator rewardCalculator;

	@Autowired
	CommonUtil commonUtil;

	/**
	 * Get the reward detail by customerId and date range
	 * @param customerId
	 * @param beginDate
	 * @param endDate
	 * @return RewardDetail
	 */
	public RewardDetail getRewardDetails(Long customerId, Date beginDate, Date endDate) {
		List<Transaction> transactions = transRepo.getTransactionByCustIdAndDate(customerId, beginDate, endDate);
		Map<String, Integer> monthlyRewardDetail = new TreeMap<>();
		Integer totalReward = 0;
		for (Transaction transaction : transactions) {
			int reward = rewardCalculator.calculateReward(transaction.getTransactionValue());
			monthlyRewardDetail.merge(commonUtil.getYearMonthFromDate(transaction.getTransactionDate()), reward,
					(prev, newVal) -> prev + newVal);
			totalReward = totalReward + reward;
		}
		return new RewardDetail(monthlyRewardDetail, totalReward);
	}

}

package com.reward.calculator.util;

import org.springframework.stereotype.Service;

/**
 * Reward calculation helper class
 * 
 * @author atulsingh
 *
 */
@Service
public class RewardCalculator {

	/**
	 * calculate reward on transaction value
	 * 
	 * @param transactionValue
	 * @return
	 */
	public int calculateReward(float transactionValue) {
		int hundredAbove = Math.max(0, (int) transactionValue - 100);
		int fiftyAbove = Math.max(0, ((int) transactionValue - 50) > 50 ? 50 : (int) transactionValue - 50);
		return hundredAbove * 2 + fiftyAbove * 1;
	}
}

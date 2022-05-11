package com.reward.calculator.dto;

import java.util.Map;

import lombok.Getter;
/**
 * DTO for wrapping  monthly and total rewards.
 * This POJO will be used as response object
 * @author atulsingh
 *
 */
@Getter
public class RewardDetail {

	private Map<String, Integer> monthlyRewardEarning;

	private Integer totalRewardEarning;

	public RewardDetail(Map<String, Integer> monthlyRewardEarning, Integer totalRewardEarning) {
		super();
		this.monthlyRewardEarning = monthlyRewardEarning;
		this.totalRewardEarning = totalRewardEarning;
	}

	public RewardDetail() {
	}

}

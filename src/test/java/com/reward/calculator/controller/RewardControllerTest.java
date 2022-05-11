package com.reward.calculator.controller;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.reward.calculator.dto.RewardDetail;
import com.reward.calculator.service.RewardService;
/**
 * Reward Controller Unit Test Case
 * @author atulsingh
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RewardControllerTest {
	
	@MockBean
	private RewardService rewardService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	@DisplayName("Get /reward/customer-id/{customer-id}/reward-detail Success")
	void testGetRewardDetails() throws Exception {
		RewardDetail mockReward=new RewardDetail(new HashMap<String,Integer>(),20);
		doReturn(mockReward).when(rewardService).getRewardDetails(1l, null, null);
		mockMvc.perform(get("/reward/customer/1/reward-details"))
		.andExpect(status().isOk());
	}

}

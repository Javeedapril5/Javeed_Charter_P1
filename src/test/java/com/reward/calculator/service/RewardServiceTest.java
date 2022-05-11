package com.reward.calculator.service;

import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.reward.calculator.dto.RewardDetail;
import com.reward.calculator.model.Transaction;
import com.reward.calculator.repository.TransactionRepo;

/**
 * Reward Service UT
 * @author atulsingh
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RewardServiceTest {

	@Autowired
	private RewardService rewardService;

	@MockBean
	private TransactionRepo transactionRepo;

	@Test
	@DisplayName("Test getRewardDetails Success")
	void testGetRewardDetailsSuccess() {
		
		Transaction mockTransaction1 = new Transaction(1l, 200f, new Date(), "Test Data", null);
		Transaction mockTransaction2 = new Transaction(2l, 300f, new Date(), "Test Data", null);

		doReturn(Arrays.asList(mockTransaction1, mockTransaction2)).when(transactionRepo)
				.getTransactionByCustIdAndDate(Mockito.anyLong(), Mockito.any(), Mockito.any() );
		
		RewardDetail rewardDetails = rewardService.getRewardDetails(1l, new Date(), new Date());
		
		Assertions.assertEquals(1, rewardDetails.getMonthlyRewardEarning().size());

	}
}

# reward-program-calculator
Micro service for calculating the rewards

# API exposed for the reward detail:
http://localhost:8080/reward/customer/1/reward-details?beginDate=2022-01-01&endDate=2022-05-01

If beginDate and endDate is optional.If not passed in request parameter previous 3 month detail will be provided in response.

# Below is the response format:


# In memory H2 DB is used.
# More data can be inserted through data.sql file.

{"monthlyRewardEarning":{"2022-01":115,"2022-02":650,"2022-03":950,"2022-04":1250},"totalRewardEarning":2965}


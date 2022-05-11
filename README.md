# reward-program-calculator
Micro service for calculating the rewards. Below is Logic for the reward calculation:

`A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction 
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
`

# API exposed for the reward detail:
- Sample API Request:
http://localhost:8080/reward/customer/1/reward-details?beginDate=2022-01-01&endDate=2022-05-01

- Below is the  sample response:

`{"monthlyRewardEarning":{"2022-01":115,"2022-02":650,"2022-03":950,"2022-04":1250},"totalRewardEarning":2965}`

  beginDate and endDate is optional.If not passed in request parameter previous 3 month detail will be provided in response.

# Notes:

 - In memory H2 DB is used.
 - More data can be inserted through data.sql file.
 - Spring Security is not configured.
 - Code up clean up is needed.
 - Code Coverage 87 percen. (Need to add more UT)


<img width="741" alt="Screen Shot 2022-05-11 at 1 22 13 AM" src="https://user-images.githubusercontent.com/22434540/167774725-19a5d629-1a08-489f-8d57-7c8137108d40.png">


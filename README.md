spring-social-yahoo
===================

Spring Social Yahoo is an extension based on Spring Social that provides funcationality to communicate with the Yahoo Social Rest API.


NOTES:
- the JdbcUsersConnectionRepository.sql constructs a table whose max length for the access token is 255, which is less
than the length of the token received from Yahoo (about 700 characters)

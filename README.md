spring-social-yahoo
===================

Spring Social Yahoo is an extension based on Spring Social that provides functionality to communicate with the Yahoo Social Rest API.

# Notes

- this library is still in DEVELOPMENT and is not yet usable in production
- when implementing a connection repository, note that the default JdbcUsersConnectionRepository.sql constructs a table
whose max length for the access token is 255, which is less than the length of the token received from
Yahoo (about 700 characters), so you need to copy the original JdbcUsersConnectionRepository.sql file and modify
the max length of the **accessToken** column

# What is supported

- only JSON payloads are used
- only the Contacts API is implemented
- only GET operations are implemented

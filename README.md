spring-social-yahoo
===================

Spring Social Yahoo is an extension based on Spring Social that provides functionality to communicate with the Yahoo Social Rest API.
You can find the full documentation at [Yahoo's developer website](https://developer.yahoo.com/social/rest_api_guide/ysp_api_book.html).
Note that, at the time of writing this, the website crashes from time to time and cannot be accessed.

# Notes

- this library is still in DEVELOPMENT and is not yet usable in production
- not all endpoints and functionalities will be implemented; if there are requests to implement some extras,
please leave me a message and I will oblige with a response
- when implementing a connection repository, note that the default JdbcUsersConnectionRepository.sql constructs a table
whose max length for the access token is 255, which is less than the length of the token received from
Yahoo (about 700 characters), so you need to copy the original JdbcUsersConnectionRepository.sql file and modify
the max length of the **accessToken** column
- you can give spring-social-yahoo a try by cloning the forked repo of spring-social-samples, available on my account
at https://github.com/gabrielruiu/spring-social-samples/tree/master/spring-social-quickstart

# What is supported

- only JSON payloads are used
- only the Contacts API is implemented
- only GET operations are implemented

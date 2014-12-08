spring-social-yahoo
===================

Spring Social Yahoo is an extension based on Spring Social that provides functionality to communicate with the Yahoo Social Rest API.
You can find the full documentation at
[Yahoo's developer website](https://developer.yahoo.com/social/rest_api_guide/ysp_api_book.html).


# Notes

- this library is still in DEVELOPMENT and is not yet usable in production
- not all endpoints and functionalities will be implemented; if there are requests to implement some extras,
please leave me a message and I will oblige with a response
- when implementing a connection repository, note that the default JdbcUsersConnectionRepository.sql constructs a table
whose max length for the access token is 255, which is less than the length of the token received from
Yahoo (about 700 characters), so you need to copy the original JdbcUsersConnectionRepository.sql file and modify
the max length of the **accessToken** column (you can go for 1000 max length)
- you can give spring-social-yahoo a try by cloning the forked repo of spring-social-samples, available on my account
at https://github.com/gabrielruiu/spring-social-samples/tree/master/spring-social-quickstart

## At the time of writing (December 2014)
- the [documentation website](https://developer.yahoo.com/social/rest_api_guide/ysp_api_book.html) crashes from time to time and cannot be accessed, it comes and goes
- calls to [individual field resources](https://developer.yahoo.com/social/rest_api_guide/field-resource.html) fail
  with 404 responses
- the [Yahoo Social API Explorer](http://ydndemo.com/yahoo_social_api_explorer/) is unavailable, probably lack of
maintenance; see details [here](https://developer.yahoo.com/social/rest_api_guide/api_explorer.html)

# What is supported

- only JSON payloads are used
- only the Contacts API is implemented


| Resource | Methods | Notes
| ------------- |-------------| ------ |
| [Contacts](https://developer.yahoo.com/social/rest_api_guide/contacts-resource.html) | GET | |
| [Contacts by category name](https://developer.yahoo.com/social/rest_api_guide/category-resource.html) | GET | |
| [Contact](https://developer.yahoo.com/social/rest_api_guide/contact-resource.html)   | GET | |
| [Categories](https://developer.yahoo.com/social/rest_api_guide/categories-resource.html) | GET, POST | the POST request gets a 502 Server Hangup from the API |
| [Categories by contact cid](https://developer.yahoo.com/social/rest_api_guide/categories-by-contact-id-resource.html) | GET | API returns a 404 response |

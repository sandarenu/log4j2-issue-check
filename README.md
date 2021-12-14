# Evaluate the Log4Shell: RCE 0-day  Issue

This repo contains the code to evaluate Log4j2 issue CVE-2021-44228 

## More details

* https://www.lunasec.io/docs/blog/log4j-zero-day/

## How to Test

Send GET request with query parameter as `${jndi:ldap://127.0.0.1:3089/}`. 

```
http://localhost:10000/test?userParam=%24%7Bjndi%3Aldap%3A%2F%2F127.0.0.1%3A3089%2F%7D
```

## Changes Done

* Updated log log4j2 version to `2.15.0`. 
* This is done by adding property `<log4j2.version>2.15.0</log4j2.version>` to pom. 
* Refer https://spring.io/blog/2021/12/10/log4j2-vulnerability-and-spring-boot
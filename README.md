# Evaluate the Log4Shell: RCE 0-day  Issue

This repo contains the code to evaluate Log4j2 issue CVE-2021-44228 

## More details

* https://www.lunasec.io/docs/blog/log4j-zero-day/

## How to Test

Send GET request with query parameter as `${jndi:ldap://127.0.0.1:3089/}`. 

```
http://localhost:10000/test?userParam=%24%7Bjndi%3Aldap%3A%2F%2F127.0.0.1%3A3089%2F%7D
```

When above request is sent application tries to connect to ldap url and following errror is printed since that 
is not running in my machine. 

```
2021-12-14 09:10:25,055 http-nio-10000-exec-1 WARN Error looking up JNDI resource [ldap://127.0.0.1:3089/]. javax.naming.CommunicationException: 127.0.0.1:3089 [Root exception is java.net.ConnectException: Connection refused (Connection refused)]
	at java.naming/com.sun.jndi.ldap.Connection.<init>(Connection.java:237)
	at java.naming/com.sun.jndi.ldap.LdapClient.<init>(LdapClient.java:137)
	at java.naming/com.sun.jndi.ldap.LdapClient.getInstance(LdapClient.java:1610)
	at java.naming/com.sun.jndi.ldap.LdapCtx.connect(LdapCtx.java:2752)
	at java.naming/com.sun.jndi.ldap.LdapCtx.<init>(LdapCtx.java:320)
	at java.naming/com.sun.jndi.url.ldap.ldapURLContextFactory.getUsingURLIgnoreRootDN(ldapURLContextFactory.java:60)
	at java.naming/com.sun.jndi.url.ldap.ldapURLContext.getRootURLContext(ldapURLContext.java:61)
	at java.naming/com.sun.jndi.toolkit.url.GenericURLContext.lookup(GenericURLContext.java:204)
	at java.naming/com.sun.jndi.url.ldap.ldapURLContext.lookup(ldapURLContext.java:94)
	at java.naming/javax.naming.InitialContext.lookup(InitialContext.java:409)
	at org.apache.logging.log4j.core.net.JndiManager.lookup(JndiManager.java:172)
	at org.apache.logging.log4j.core.lookup.JndiLookup.lookup(JndiLookup.java:56)
	at org.apache.logging.log4j.core.lookup.Interpolator.lookup(Interpolator.java:221)
```

## Temporary Fix

You can update the `log4j2.xml` by adding `{nolookups}` to the log pattern.

* Original `%d{yyyy-MM-dd HH:mm:ss.SSS} %-5level [%X{trxid}] %c{1} [%t] - %msg %n`
* Updated `%d{yyyy-MM-dd HH:mm:ss.SSS} %-5level [%X{trxid}] %c{1} [%t] - %msg{nolookups} %n`

## Permanent Fix

* Update the log4j version to `2.15.0`. Check the fix in branch `update-log4j-to-2.15.0`

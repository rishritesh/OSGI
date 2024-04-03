package com.ritesh;

import java.util.Base64;

import org.apache.camel.Exchange;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.Configuration;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.exceptions.TransportException;

public class RemoteCacheManagerFactory {

	// Logger logger = Logger.getLogger("org.infinispan").setLevel(Level.ALL);
	private Integer maxRetry = 1;
	private Integer socketTimeOut = 5000;
	private Integer connectionTimeOut = 5000;
	RemoteCache<Object, Object> rc = null;
	// RemoteCa
	// ConfigurationBuilder clientBuilder;
	RemoteCacheManager rcm;

	public RemoteCacheManagerFactory(String hostname, String cachename) {
		try {
//        String encodedCredentials = encodeCredentials("admin", "password");
			ConfigurationBuilder clientBuilder = new ConfigurationBuilder();

//        clientBuilder.uri("hotrod://admin:password@192.168.1.234:11222?auth_realm=default&sasl_mechanism=PLAIN");
			Configuration con = clientBuilder.addServer().host(hostname).port(11222).security().authentication()
					.saslMechanism("DIGEST-MD5").connectionTimeout(connectionTimeOut).socketTimeout(socketTimeOut)
					.maxRetries(maxRetry).build();

//       System.out.println(clientBuilder.toString() + " : " + hostname + ", " + cachename);

//       // clientBuilder.addServer().host(hostname).port(11222).security().authentication().username("admin").password("password").realm("default").saslMechanism("SCRAM-SHA-512").connectionTimeout(connectionTimeOut).socketTimeout(socketTimeOut).maxRetries(maxRetry);

			rcm = new RemoteCacheManager(con);
			System.out.println("jaiiiiiii" + cachename);
			System.out.println("jaiiiiiiiSangeeeeeeeerrrrrrrrrrrrrrrrrr" + rcm.getCache(cachename));

			rc = (RemoteCache<Object, Object>) rcm.getCache(cachename);
			System.out.println("jaiiiiiiiSangeeeeeeeerrrrrrrrrrrrrrrrrr");

			System.out.println("jaiiiiiiiSangeeeeeeeerrrrrrrrrrrrrrrrrr" + rc.size());
			// rcm.close();
		} catch (Exception e) {
			System.out.println("333333333333333333333333333333333333");
//       logger.error("Error creating RemoteCacheManager: " + e.getMessage(), e);
		}

	}

	public void xyz(Exchange exchange) {
		try {
			System.out.println("4444444444444444444444444444444444444444444444" + exchange.getIn().getHeader("key")
					+ exchange.getIn().getHeader("name"));
			rc.put(exchange.getIn().getHeader("key", String.class), exchange.getIn().getHeader("name", String.class));
			System.out.println("555555555555555555555555555555555555555555555");
			// exchange.getProperty("key_lifespan", Long.class), TimeUnit.SECONDS);
		} catch (TransportException e) {
			// logger.info("X-Correlation-Id_"+exchange.getProperty("txnid")+" |
			// aepsResponseFromCache{} Exception While Connecting Cache"+e.getMessage());
			exchange.setProperty("returnCode", "999");
		}
	}

}

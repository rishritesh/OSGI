package com.hotRod;

import java.util.Map;
import java.util.logging.Logger;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ClientIntelligence;
import org.infinispan.client.hotrod.configuration.Configuration;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;




public class HotRod implements Processor{
	
	private static final Logger L = Logger.getLogger(HotRod.class.getName());

	
	@Override
	public void process(Exchange exchange) throws Exception {

		ConfigurationBuilder clientBuilder = new ConfigurationBuilder();
		clientBuilder
		              .addServer()
		               .host("localhost")
		               .port(11222)
		               .security()
		               .authentication()
//		               .username("admin")
//		               .password("admin")	
		               .serverName("infinispan")
					    .saslMechanism("DIGEST-MD5") // DIGEST-MD5 define SASL mechanism, in this example we use DIGEST with MD5 hash
					    .callbackHandler(new Mycallback("admin", "default", "admin".toCharArray())) // define login handler, implementation defined
					    .enable()
		               .maxRetries(1)		               		              
		                 .build();
		
		
		L.info("hi i m in processor "+clientBuilder.build());

			RemoteCacheManager cacheManager = new RemoteCacheManager(clientBuilder.build());
			
			RemoteCache<String, String> cache = cacheManager.getCache("JAI");
			
			L.info("hi i m in cacheManager "+cacheManager.isStarted());
			L.info("hi i m in cacheManager "+cache.getName());
			
			
			L.info("hi i m in try catch");
			
			cache.put("1", "java");
			
			String value = cache.get("1");
			System.out.println("Retrieved value: " + value);
			exchange.getIn().setBody(value);
			
			cacheManager.stop();


	}
	
	
	
	

}

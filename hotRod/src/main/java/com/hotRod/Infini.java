package com.hotRod;

import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ClientIntelligence;
import org.infinispan.client.hotrod.configuration.Configuration;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;

public class Infini {
	public static void main(String[] args) {
		Configuration configuration = new ConfigurationBuilder()
			    .addServer()
			    
			    .host("localhost")
			    .port(11222)
			    .security()
			    .authentication()
//			    .username("admin")
//			    .password("admin")
//			    .realm("default")
			    .serverName("infinispan")
			    .saslMechanism("DIGEST-MD5") // DIGEST-MD5 define SASL mechanism, in this example we use DIGEST with MD5 hash
			    .callbackHandler(new Mycall("admin", "default", "admin".toCharArray())) // define login handler, implementation defined
			    .enable()
	
			    .maxRetries(1)
			    .build();
		System.out.println(configuration);
		
	
		
		RemoteCacheManager cacheManager = new RemoteCacheManager(configuration);
		
		RemoteCache<String, String> cache = cacheManager.getCache("JAI");
		
		cache.put("1", "java");
		String value = cache.get("1");
		System.out.println("Retrieved value: " + value);
		
		cacheManager.stop();
	}
	
	

}

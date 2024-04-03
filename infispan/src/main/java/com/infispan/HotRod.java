package com.infispan;

import org.infinispan.client.hotrod.configuration.Configuration;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.RemoteCache;

public class HotRod {
	public static void main(String[] args) {
		
		Configuration configuration = new ConfigurationBuilder()
			    .addServer()
			    .host("localhost")
			    .port(11222)
			    .security().authentication().username("admin").password("admin")// Default Hot Rod port
			    // Add any additional configuration options as needed
			    .build();
		
		RemoteCacheManager cacheManager = new RemoteCacheManager(configuration);
		
		RemoteCache<String, String> cache = cacheManager.getCache("JAI");
		
		cache.put("1", "java");
		String value = cache.get("1");
		System.out.println("Retrieved value: " + value);
		
		cacheManager.stop();

		
	}

}

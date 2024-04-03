package com.ritesh;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.infinispan.client.hotrod.RemoteCache;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.Configuration;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.configuration.Configuration;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.RemoteCache;

public class HotRod implements Processor{
	
	

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		Configuration configuration = new ConfigurationBuilder()
			    .addServer()
			    .host("localhost")
			    .port(11222)
			    .security().authentication().username("admin").password("password")// Default Hot Rod port
			    // Add any additional configuration options as needed
			    .build();
		
		RemoteCacheManager cacheManager = new RemoteCacheManager(configuration);
		
		RemoteCache<String, String> cache = cacheManager.getCache("BOYS");
		
		cache.put("1", "jai");
		String value = cache.get("1");
		System.out.println("Retrieved value: " + value);
		
		cacheManager.stop();
		
	}
	
	

}

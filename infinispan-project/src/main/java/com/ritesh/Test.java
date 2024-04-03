package com.ritesh;





import java.util.logging.Logger;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.infinispan.Cache;
import org.infinispan.configuration.cache.ConfigurationBuilder;
import org.infinispan.manager.DefaultCacheManager;




public class Test implements Processor{
	private static final Logger L = Logger.getLogger(Test.class.getName());

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		
		
		// Create a cache manager with the default configuration
        DefaultCacheManager cacheManager = new DefaultCacheManager();
        
        L.info("inside embedded1 ");
        // Retrieve or create a cache with the desired configuration
        ConfigurationBuilder configBuilder = new ConfigurationBuilder();
        configBuilder.memory().size(1000); // Example configuration
        Cache<Object, Object> cache = cacheManager.getCache("BOYS", true);
        L.info("inside embedded ");
        
        // Perform operations with the cache
        cache.put("key", "value");

        // Close the cache manager when done
        cacheManager.stop();
		
	}

}

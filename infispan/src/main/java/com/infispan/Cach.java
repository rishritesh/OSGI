//package com.infispan;
//
//
//
//import org.infinispan.Cache;
//import org.infinispan.configuration.cache.Configuration;
//import org.infinispan.configuration.cache.ConfigurationBuilder;
//import org.infinispan.manager.DefaultCacheManager;
//
//
//
//public class Cach {
//	public static void main(String[] args) {
//		
//		 // Create a default cache manager
//        DefaultCacheManager cacheManager = new DefaultCacheManager();
//        
//  
//
//
//        // Define cache configuration
////        ConfigurationBuilder builder = new ConfigurationBuilder();
////        builder.simpleCache(true); // Create a simple cache (no clustering, no persistence, etc.)
////
////        // Create a cache named "exampleCache" with the specified configuration
////        Cache<String, String> cache = cacheManager.defineConfiguration("exampleCache", builder.build()).get();
//        
//        
//        
//     // Define cache configuration using ConfigurationBuilder
//        ConfigurationBuilder builder = new ConfigurationBuilder();
//        builder.simpleCache(true); // Create a simple cache (no clustering, no persistence, etc.)
//        Configuration configuration = builder.build();
//
//        // Define a cache named "exampleCache" with the specified configuration
////        Cache<String, String> cache = (Cache<String, String>) cacheManager.defineConfiguration("exampleCache", configuration);
//        
//        // Define a cache configuration named "exampleCache" with the specified configuration
//        cacheManager.defineConfiguration("exampleCache", configuration);
//
//        // Retrieve the cache named "exampleCache" from the cache manager
//        Cache<String, String> cache = cacheManager.getCache("exampleCache");
//
//
//        // Put data into the cache
//        cache.put("key1", "value1");
//        cache.put("key2", "value2");
//        cache.put("key3", "value3");
//
//        // Retrieve data from the cache
//        String value1 = cache.get("key1");
//        String value2 = cache.get("key2");
//        String value3 = cache.get("key3");
//
//        // Display retrieved values
//        System.out.println("Value for key1: " + value1);
//        System.out.println("Value for key2: " + value2);
//        System.out.println("Value for key3: " + value3);
//
//        // Close the cache manager
//        cacheManager.stop();
//		
//	}
//
//}

//package com.infispan;
//
//
//import org.infinispan.Cache;
//import org.infinispan.configuration.cache.*;
//import org.infinispan.configuration.cache.ConfigurationBuilder;
//import org.infinispan.manager.DefaultCacheManager;
//
///**
// * Hello world!
// *
// */
//public class App 
//{
//    public static void main( String[] args )
//    {
//        System.out.println( "Hello World!" );
//        
//     // Create a default cache manager
//        DefaultCacheManager cacheManager = new DefaultCacheManager();
//
//        // Define cache configuration
//        ConfigurationBuilder builder = new ConfigurationBuilder();
//        builder.simpleCache(true); // Create a simple cache (no clustering, no persistence, etc.)
//        Configuration configuration = builder.build();
//      
//
//        
//       
//
//        // Create a cache named "exampleCache" with the specified configuration
////        Cache<String, String> cache = cacheManager.defineConfiguration("exampleCache", builder.build()).get();
////        Cache<String, String> cache = cacheManager.getCache("Mychache");
//        Cache<String, String> cache = cacheManager.defineConfiguration("exampleCache", builder.build()).get();
//
//       
//        
//        
//        
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
//    }
//    
//    
//}

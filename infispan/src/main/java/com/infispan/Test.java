//package com.infispan;
//
//import java.lang.module.Configuration;
//import java.util.concurrent.TimeUnit;
//
//import org.infinispan.Cache;
//import org.infinispan.configuration.cache.CacheMode;
//import org.infinispan.configuration.cache.ConfigurationBuilder;
//import org.infinispan.configuration.global.GlobalConfiguration;
//import org.infinispan.configuration.global.GlobalConfigurationBuilder;
//import org.infinispan.eviction.EvictionType;
//import org.infinispan.manager.DefaultCacheManager;
//
//public class Test {
//	public static void main(String[] args) {
//		GlobalConfigurationBuilder globalConfig = new GlobalConfigurationBuilder();
//		globalConfig.transport().defaultTransport()
//		    .clusterName("my-cluster")
//		    .addProperty("configurationFile", "jgroups-udp.xml");
//		globalConfig.globalJmxStatistics().allowDuplicateDomains(true);
//		GlobalConfiguration global = globalConfig.build();
//		
//		ConfigurationBuilder config = new ConfigurationBuilder();
//		config.clustering().cacheMode(CacheMode.DIST_SYNC);
//		config.expiration().lifespan(5, TimeUnit.MINUTES);
//		config.memory().size(1000).evictionType(EvictionType.COUNT);
//		Configuration cacheConfig = config.build();
//		
//		CacheManager cacheManager = new DefaultCacheManager(global, cacheConfig);
//		
//		Cache<String, String> cache = cacheManager.getCache("my-cache");
//		cache.put("key", "value");
//		String value = cache.get("key");
//
//
//
//		
//	}
//
//}

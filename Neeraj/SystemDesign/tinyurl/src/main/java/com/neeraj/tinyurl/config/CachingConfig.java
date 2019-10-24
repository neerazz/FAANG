package com.neeraj.tinyurl.config;

import lombok.extern.slf4j.Slf4j;

//@Configuration
@Slf4j
public class CachingConfig {

//    https://www.baeldung.com/spring-data-redis-tutorial
//    https://stackoverflow.com/questions/58364427/redis-cache-in-service-class-seems-not-working
//    @Bean
//    JedisConnectionFactory jedisConnectionFactory() {
//        return new JedisConnectionFactory();
//    }
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate() {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(jedisConnectionFactory());
//        return template;
//    }
//
//    private static RedisCacheConfiguration createCacheConfiguration(long timeoutInSeconds, RedisSerializationContext.SerializationPair<?> serializationPair) {
//        log.info("Creating CacheConfiguration with timeout of {} seconds", timeoutInSeconds);
//        return RedisCacheConfiguration.defaultCacheConfig()
//                .serializeValuesWith(serializationPair)
//                .entryTtl(Duration.ofSeconds(timeoutInSeconds));
//    }
//
//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
//        Map<String, RedisCacheConfiguration> cacheConfigurations = new HashMap<>();
////        Creating Caching configuration for different caches.
//        cacheConfigurations.put("userdetail",
//                createCacheConfiguration(-1,RedisSerializationContext.SerializationPair.fromSerializer(new JdkSerializationRedisSerializer())));
//
//        return RedisCacheManager
//                .builder(connectionFactory)
//                .cacheDefaults(createCacheConfiguration(-1,RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer())))
//                .withInitialCacheConfigurations(cacheConfigurations)
//                .build();
//    }
}

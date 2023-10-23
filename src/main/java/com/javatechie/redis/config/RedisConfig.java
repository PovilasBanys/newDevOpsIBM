package com.javatechie.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
public class RedisConfig {

//    @Bean
//    public JedisConnectionFactory connectionFactory() {
//        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
//        configuration.setHostName("localhost");
//        configuration.setPort(6379);
//        return new JedisConnectionFactory(configuration);
//    }






        @Bean
        public JedisConnectionFactory connectionFactory() {
            RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
            configuration.setHostName("newDevOpsIBM.redis.cache.windows.net");
            configuration.setPort(6380);
            configuration.setPassword("9I9ceDkCA5M4Wl5bxbs2G6ZiVIlsK9F0MAzCaKrHYzc=");
            configuration.setDatabase(0);
            return new JedisConnectionFactory(configuration);
    }


    @Bean
    public RedisTemplate<String, Object> template() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new JdkSerializationRedisSerializer());
        template.setValueSerializer(new JdkSerializationRedisSerializer());
        template.setEnableTransactionSupport(true);
        template.afterPropertiesSet();
        return template;
    }



//    @Bean
//    public RedisTemplate<String, Object> redisTemplate() {
//        final RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
//        template.setConnectionFactory(connectionFactory());
//        template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
//        return template;
//    }

}

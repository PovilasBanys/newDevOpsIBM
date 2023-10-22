package com.javatechie.redis;

import com.javatechie.redis.entity.Product;
import com.javatechie.redis.respository.ProductDao;
import com.javatechie.redis.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
//import redis.clients.jedis.DefaultJedisClientConfig;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/admin")
public class SpringDataRedisExampleApplication {
    @Autowired
    private ProductDao dao;

    @Autowired
    private RequestService requestService;
    @PostMapping
    public Product save(@RequestBody Product product, HttpServletRequest request) {
        return dao.save(product, request);
    }

	@GetMapping("/all")
	public List<Product> getAllProducts() {
		return dao.findAll();
	}

    @GetMapping("/{id}")
    public Product findProduct(@PathVariable int id) {
        return dao.findProductById(id);
    }
    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id)   {
        return dao.deleteProduct(id);
    }

    @GetMapping
    public String count(){
        return dao.countIp();
    }

    public ModelAndView index(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("index");
        String clientIp = requestService.getClientIp(request);
        model.addObject("clientIp", clientIp);
        return model;
    }

    public static void main(String[] args) {



//		boolean useSsl = true;
//		JedisShardInfo shardInfo = new JedisShardInfo("dbibmdevopsapp-cache.redis.cache.windows.net", 6380, useSsl);
//		shardInfo.setPassword("SB0ihmWJOzBxr0VPkEPfRvVW2pBJWHAIxAzCaCDQM6k="); /* Use your access key. */
//		Jedis jedis = new Jedis(shardInfo);
//		jedis.set("foo", "bar");




//		boolean useSsl = true;
//		/* In this line, replace <name> with your cache name: */
//		JedisShardInfo shardInfo = new JedisShardInfo("dbibmdevopsapp-cache.redis.cache.windows.net", 6380, useSsl);
//		shardInfo.setPassword("SB0ihmWJOzBxr0VPkEPfRvVW2pBJWHAIxAzCaCDQM6k="); /* Use your access key. */
//		shardInfo.setConnectionTimeout(9999999);
//		shardInfo.setSoTimeout(9999999);
//		Jedis jedis = new Jedis(shardInfo);
//		jedis.set("foo", "baaar");
//		String value = jedis.get("foo");
//        System.out.println(value);





//		boolean useSsl = true;
//		String cacheHostname = System.getenv("dbibmdevopsapp-cache.redis.cache.windows.net");
//		String cachekey = System.getenv("SB0ihmWJOzBxr0VPkEPfRvVW2pBJWHAIxAzCaCDQM6k=");
//
//		// Connect to the Azure Cache for Redis over the TLS/SSL port using the key.
//		Jedis jedis = new Jedis(cacheHostname, 6380, DefaultJedisClientConfig.builder()
//				.password(cachekey)
//				.ssl(useSsl)
//				.build());
//
//		// Perform cache operations using the cache connection object...
//
//		// Simple PING command
//		System.out.println( "\nCache Command  : Ping" );
//		System.out.println( "Cache Response : " + jedis.ping());
//
//		// Simple get and put of integral data types into the cache
//		System.out.println( "\nCache Command  : GET Message" );
//		System.out.println( "Cache Response : " + jedis.get("Message"));
//
//		System.out.println( "\nCache Command  : SET Message" );
//		System.out.println( "Cache Response : " + jedis.set("Message", "Hello! The cache is working from Java!"));
//
//		// Demonstrate "SET Message" executed as expected...
//		System.out.println( "\nCache Command  : GET Message" );
//		System.out.println( "Cache Response : " + jedis.get("Message"));
//
//		// Get the client list, useful to see if connection list is growing...
//		System.out.println( "\nCache Command  : CLIENT LIST" );
//		System.out.println( "Cache Response : " + jedis.clientList());
//
//		jedis.close();



        SpringApplication.run(SpringDataRedisExampleApplication.class, args);
    }

}

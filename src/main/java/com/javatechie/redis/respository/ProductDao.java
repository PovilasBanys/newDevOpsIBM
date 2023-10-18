package com.javatechie.redis.respository;

import com.javatechie.redis.entity.Product;
import com.javatechie.redis.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//@Repository
//public class ProductDao {
//
//    public static final String HASH_KEY = "Product";
//    @Autowired
//    private RedisTemplate template;
//
//    public Product save(Product product){
//        template.opsForHash().put(HASH_KEY,product.getId(),product);
//        return product;
//    }
//
//    public List<Product> findAll(){
//        return template.opsForHash().values(HASH_KEY);
//    }
//
//    public Product findProductById(int id){
//        return (Product) template.opsForHash().get(HASH_KEY,id);
//    }
//
//
//    public String deleteProduct(int id){
//         template.opsForHash().delete(HASH_KEY,id);
//        return "product removed !!";
//    }
//}

@Repository
public class ProductDao {

    @Autowired
    private RequestService requestService;

    public static final String HASH_KEY = "Product";

    @Autowired
    private RedisTemplate template;


    public Product save(Product product, HttpServletRequest request){
        template.opsForHash().put(HASH_KEY,product.getId(),product);
        String clientIp = requestService.getClientIp(request);
        template.opsForHash().put(HASH_KEY,product.setNamee(clientIp), product);
        return product;
    }


    public List<Product> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Product findProductById(int id){
        return (Product) template.opsForHash().get(HASH_KEY,id);
    }


    public String deleteProduct(int id){
        template.opsForHash().delete(HASH_KEY,id);
        return "product removed !!";
    }

    public String countIp(){
        Long count = template.opsForHash().size(HASH_KEY);
        return count.toString();
    }
}

package com.javatechie.redis;

import com.javatechie.redis.entity.Product;
import com.javatechie.redis.respository.ProductDao;
import com.javatechie.redis.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/product")
public class SpringDataRedisExampleApplication {
//    @Autowired
//    private ProductDao dao;
//
//    @PostMapping
//    public Product save(@RequestBody Product product, HttpServletRequest request) {
//        return dao.save(product, request);
//    }
//
//    @GetMapping
//    public List<Product> getAllProducts() {
//        return dao.findAll();
//    }
//
//    @GetMapping("/{id}")
//    public Product findProduct(@PathVariable int id) {
//        return dao.findProductById(id);
//    }
//    @DeleteMapping("/{id}")
//    public String remove(@PathVariable int id)   {
//    	return dao.deleteProduct(id);
//	}



    @Autowired
    private ProductDao dao;

    @Autowired
    private RequestService requestService;
    @PostMapping
    public Product save(@RequestBody Product product, HttpServletRequest request) {
        return dao.save(product, request);
    }

//	@GetMapping
//	public List<Product> getAllProducts() {
//		return dao.findAll();
//	}

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

    public ModelAndView index() {
        ModelAndView model = new ModelAndView("index");
        String addressCount = dao.countIp();
        model.addObject("addressCount", addressCount);
        return model;
    }

    public ModelAndView index(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("index");
        String clientIp = requestService.getClientIp(request);
        model.addObject("clientIp", clientIp);
        return model;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRedisExampleApplication.class, args);
    }

}

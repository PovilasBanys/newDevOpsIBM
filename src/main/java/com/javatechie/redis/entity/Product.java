package com.javatechie.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Product")
public class Product implements Serializable {
    @Id
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public Product setNamee(String getClientIp) {
        this.name = getClientIp;
        return new Product(id, name);
    }
}

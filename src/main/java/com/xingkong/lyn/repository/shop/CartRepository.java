package com.xingkong.lyn.repository.shop;

import com.xingkong.lyn.model.shop.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lyn on 2017/6/5.
 */
public interface CartRepository extends JpaRepository<Cart,Long>{
}

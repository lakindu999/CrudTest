package com.springbootacademy.project1.repo;

import com.springbootacademy.project1.entity.Checkout;
import com.springbootacademy.project1.entity.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface CheckoutRepo extends JpaRepository<Checkout,Integer> {
}

package com.facu.restfacu.Repository;

import com.facu.restfacu.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Product, Long> {
}

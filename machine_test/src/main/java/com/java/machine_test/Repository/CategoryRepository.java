package com.java.machine_test.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.java.machine_test.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
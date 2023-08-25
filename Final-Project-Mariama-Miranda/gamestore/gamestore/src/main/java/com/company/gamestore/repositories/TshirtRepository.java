package com.company.gamestore.repositories;

import com.company.gamestore.models.Tshirt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TshirtRepository extends JpaRepository<Tshirt, Integer> {
    Optional<Tshirt> findByColor(String color);
    Optional<Tshirt> findBySize(String size);


}
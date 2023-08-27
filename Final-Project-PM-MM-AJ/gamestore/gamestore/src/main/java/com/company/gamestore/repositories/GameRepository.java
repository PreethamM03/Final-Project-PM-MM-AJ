package com.company.gamestore.repositories;

import com.company.gamestore.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    List<Game> findGameByStudio(String studio);
    List<Game> findGameByEsrbRating(String esrbRating);
    Optional<Game> findGameByTitle(String title);
}

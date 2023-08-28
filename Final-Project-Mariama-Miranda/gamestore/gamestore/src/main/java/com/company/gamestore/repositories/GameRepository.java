package com.company.gamestore.repositories;

import com.company.gamestore.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
    List<Game> findGameByStudio(String studio);
    List<Game> findGameByEsrbRating(String esrbRating);
    Optional<Game> findGameByTitle(String title);
}

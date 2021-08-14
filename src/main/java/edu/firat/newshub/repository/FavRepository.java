package edu.firat.newshub.repository;

import edu.firat.newshub.model.Favourites;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface FavRepository extends JpaRepository<Favourites, Integer> {
}

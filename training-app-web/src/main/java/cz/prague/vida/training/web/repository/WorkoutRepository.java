package cz.prague.vida.training.web.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.prague.vida.training.entity.Workout;

@Repository
@Transactional
public interface WorkoutRepository extends JpaRepository<Workout, Integer>{

}

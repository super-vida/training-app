package cz.prague.vida.training.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import cz.prague.vida.training.web.entity.Check;


public interface CheckRepository extends JpaRepository<Check, Integer>{

}

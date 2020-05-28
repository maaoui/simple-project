package tn.sesame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.sesame.domain.*;

public interface IManager extends JpaRepository<Manager, Integer> {

}

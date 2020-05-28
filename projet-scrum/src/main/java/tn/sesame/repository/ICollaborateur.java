package tn.sesame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.sesame.domain.*;

public interface ICollaborateur extends JpaRepository<Collaborateur, Integer> {

}

package tn.sesame.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import tn.sesame.domain.*;

public interface IAdmin extends JpaRepository<Admin, Integer> {

}

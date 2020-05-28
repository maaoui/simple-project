package tn.sesame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.sesame.domain.Client;

public interface IClient extends JpaRepository<Client, Integer>{

}

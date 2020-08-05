package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

//public interface UserRepository extends CrudRepository<User, Integer> {
public interface UserRepository extends PagingAndSortingRepository<User, Integer> {
}


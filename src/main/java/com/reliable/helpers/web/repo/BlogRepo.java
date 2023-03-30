package com.reliable.helpers.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reliable.helpers.web.model.Blog;

@Repository
public interface BlogRepo extends JpaRepository<Blog,Integer>{

}

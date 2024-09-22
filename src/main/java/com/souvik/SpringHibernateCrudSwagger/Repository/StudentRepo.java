package com.souvik.SpringHibernateCrudSwagger.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.souvik.SpringHibernateCrudSwagger.Model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{


}

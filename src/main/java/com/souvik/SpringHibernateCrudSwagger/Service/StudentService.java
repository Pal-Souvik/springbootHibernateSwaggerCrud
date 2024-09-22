package com.souvik.SpringHibernateCrudSwagger.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.souvik.SpringHibernateCrudSwagger.Model.Student;

@Service
public interface StudentService {

	public List<Student>  findallStud();

	public Optional<Student>  findbyID(Long id);

	public Student saveStud(Student student);

	public Student updateStud(Student student);

	public void deleteStud(Student student);


}

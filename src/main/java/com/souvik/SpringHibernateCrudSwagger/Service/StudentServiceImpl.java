package com.souvik.SpringHibernateCrudSwagger.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souvik.SpringHibernateCrudSwagger.Exception.BuisnessExeption;
import com.souvik.SpringHibernateCrudSwagger.Model.Student;
import com.souvik.SpringHibernateCrudSwagger.Repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepo studentRepo;
	@Override
	public List<Student> findallStud() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}
	@Override
	public Optional<Student> findbyID(Long id) {
		// TODO Auto-generated method stub
System.out.println("Hello");
		return studentRepo.findById(id);
	}
	@Override
	public Student saveStud(Student student) {
		// TODO Auto-generated method stub
		
		if(student.getSage()==null ) {
			throw new BuisnessExeption("601","Age of Student is null");
		}
		if(student.getSage() <=0  ) 
			throw new BuisnessExeption("602","Age cannot be nagative");
		try {
		Student stud = studentRepo.save(student);
		System.out.println(stud);
		return stud;
		}catch(IllegalArgumentException e) {
			throw e;
		}
		catch(Exception ex) {
		throw ex;
		}
	}
	@Override
	public Student updateStud(Student student) {
		// TODO Auto-generated method stub
			if(student.getSage()==null)
				throw new BuisnessExeption("601","Age of Student is null");
			if(student.getSage() <=0 ) 
				throw new BuisnessExeption("602","Age cannot be negative");
		try {
		Student stud = studentRepo.save(student);
		System.out.println(stud.toString());
		return stud;
		}catch(IllegalArgumentException iex) {
			throw iex;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	@Override
	public void deleteStud(Student student) {
		studentRepo.delete(student);
	}

}

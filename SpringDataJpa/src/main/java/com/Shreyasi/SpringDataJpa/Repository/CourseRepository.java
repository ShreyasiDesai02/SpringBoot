package com.Shreyasi.SpringDataJpa.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Shreyasi.SpringDataJpa.Model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

	 Page<Course> findByTitleContaining(
	            String title,
	            Pageable pageable);
	
	
}

package com.student.rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.student.rest.model.student;
import com.student.rest.response.basicresponsemsg;
import com.student.rest.response.studentrequestvo;

import jakarta.transaction.Transactional;

public interface studentdao extends JpaRepository<student, Integer> {
    @Query("SELECT s FROM student s WHERE s.age > ?1")
    List<student> findByAgeGreaterThan(Integer age);
    
    @Transactional
    @Modifying
    @Query("DELETE FROM student s WHERE s.id = ?1")
    void deleteByIdCustom(Integer id);
}

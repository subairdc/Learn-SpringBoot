package com.subairdc.springboot.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.subairdc.springboot.entity.Course;
import com.subairdc.springboot.entity.Teacher;


@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course courseSpring = Course.builder()
                .title("Spring")
                .credit(9)
                .build();

        Course courseSpringBoot = Course.builder()
                .title("SpringBoot")
                .credit(10)
                .build();

        Teacher teacher =
                Teacher.builder()
                        .firstName("Steve")
                        .lastName("Jobs")
//                        .courses(List.of(courseSpring,courseSpringBoot))
                        .build();

        teacherRepository.save(teacher);
    }
}

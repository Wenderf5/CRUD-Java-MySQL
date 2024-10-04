package com.app.escola.modules.student_module.services.getAllStudent;

import com.app.escola.data_base.entitys.student_entity.Student;
import com.app.escola.data_base.entitys.student_entity.StudentRepository;
import com.app.escola.data_base.entitys.coursestudent_entity.Coursestudent;
import com.app.escola.data_base.entitys.coursestudent_entity.CoursestudentRepository;
import com.app.escola.data_base.entitys.course_entity.Course;
import com.app.escola.data_base.entitys.course_entity.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllStudentService {
    private StudentRepository studentRepository;
    private CourseRepository courseRepository;
    private CoursestudentRepository course_studentRepository;

    @Autowired
    public GetAllStudentService(
            StudentRepository studentRepository,
            CourseRepository courseRepository,
            CoursestudentRepository course_studentRepository
    ) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.course_studentRepository = course_studentRepository;
    }

    public ResponseEntity<?> getAllStudent() {
        try {
            List<Student> students = studentRepository.findAll();
            List<Course> courses = courseRepository.findAll();
            List<Coursestudent> coursesStudents = course_studentRepository.findAll();

            List<Students> listStudent = new ArrayList<Students>();

            for (Student student : students) {
                listStudent.add(new Students(student.getId(), student.getCpf(), student.getName()));
            }

            for (Students student : listStudent) {
                for (Coursestudent courseStudent : coursesStudents) {
                    if (courseStudent.getId_student() == student.id) {
                        for (Course course : courses) {
                            if (course.getId() == courseStudent.getId_course()) {
                                student.setCourses(new Courses(courseStudent.getId(), course.getId(), course.getName()));
                            }
                        }
                    }
                }
            }
            return new ResponseEntity<List<Students>>(listStudent, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao buscar alunos!", HttpStatus.BAD_REQUEST);
        }
    }

    public class Students {
        private Long id;
        private String cpf;
        private String name;
        private List<Courses> courses = new ArrayList<Courses>();

        public Students(Long id, String cpf, String name) {
            this.id = id;
            this.cpf = cpf;
            this.name = name;
        }

        //Geters
        public Long getId() {
            return id;
        }

        public String getCpf() {
            return cpf;
        }

        public String getName() {
            return name;
        }

        public List<Courses> getCourses() {
            return courses;
        }

        //Seters
        public void setCourses(Courses course) {
            this.courses.add(course);
        }
    }

    public class Courses {
        private Long id;
        private Long idCourse;
        private String name;

        public Courses(Long id, Long idCourse, String name) {
            this.id = id;
            this.idCourse = idCourse;
            this.name = name;
        }

        //Geters
        public Long getId() {
            return id;
        }

        public Long getIdCourse() {
            return idCourse;
        }

        public String getName() {
            return name;
        }
    }
}

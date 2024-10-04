package com.app.escola.modules.student_module.services.getStudent;

import com.app.escola.data_base.entitys.course_entity.Course;
import com.app.escola.data_base.entitys.course_entity.CourseRepository;
import com.app.escola.data_base.entitys.coursestudent_entity.Coursestudent;
import com.app.escola.data_base.entitys.coursestudent_entity.CoursestudentRepository;
import com.app.escola.data_base.entitys.student_entity.Student;
import com.app.escola.data_base.entitys.student_entity.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GetStudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final CoursestudentRepository course_studentRepository;

    @Autowired
    public GetStudentService(
            StudentRepository studentRepository,
            CourseRepository courseRepository,
            CoursestudentRepository course_studentRepository
    ) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.course_studentRepository = course_studentRepository;
    }

    public ResponseEntity<?> getStudent(Long id) {
        try {
            Optional<Student> studentOpt = studentRepository.findById(id);
            if (studentOpt.isEmpty()) {
                return new ResponseEntity<>("Aluno não encontrado!", HttpStatus.NOT_FOUND);
            }

            Student student = studentOpt.get();
            List<Course> courses = courseRepository.findAll();
            List<Coursestudent> coursesStudents = course_studentRepository.findAllByIdstudent(student.getId());

            StudentDTO studentDTO = new StudentDTO(student.getId(), student.getCpf(), student.getName());

            for (Coursestudent courseStudent : coursesStudents) {
                Long id_course = courseStudent.getId_course();
                for (Course course : courses) {
                    if (course.getId().equals(id_course)) {
                        studentDTO.addCourse(new CourseDTO(courseStudent.getId(), course.getId(), course.getName()));
                    }
                }
            }

            return new ResponseEntity<>(studentDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao buscar aluno!", HttpStatus.BAD_REQUEST);
        }
    }

    public static class StudentDTO {
        private final Long id;
        private final String cpf;
        private final String name;
        private final List<CourseDTO> courses = new ArrayList<>();

        public StudentDTO(Long id, String cpf, String name) {
            this.id = id;
            this.cpf = cpf;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public String getCpf() {
            return cpf;
        }

        public String getName() {
            return name;
        }

        public List<CourseDTO> getCourses() {
            return courses;
        }

        public void addCourse(CourseDTO course) {
            courses.add(course);
        }
    }

    public static class CourseDTO {
        private final Long id;
        private final Long idCourse;
        private final String name;

        public CourseDTO(Long id, Long idCourse, String name) {
            this.id = id;
            this.idCourse = idCourse;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public Long getId_course() {
            return idCourse;
        }

        public String getName() {
            return name;
        }
    }
}
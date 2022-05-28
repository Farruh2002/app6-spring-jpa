package uz.pdp.app6springjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.app6springjpa.entity.Student;
import uz.pdp.app6springjpa.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    /*
    * C R U D
    * */

    @Autowired
    StudentRepository studentRepository;

    //Read
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public List<Student> getStudents(){
        //select * from student
        List<Student> students = studentRepository.findAll(); //hamma studentlarni olib keladi.
        return students;
    }

    //Read Id orqali
    @RequestMapping(value = "/student/{id}", method = RequestMethod.GET)
    public Student getStudent(@PathVariable Integer id){
        //select * from student where id = 3
        Optional<Student> optionalStudent = studentRepository.findById(id);

        if (optionalStudent.isEmpty())
            return new Student();

        Student student = optionalStudent.get();
        return student;
    }

    //Create
    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String addStudent(@RequestBody Student student){

        List<Student> students = studentRepository.findAll();

        for (Student item : students) {
            if (item.getPhoneNumber().equals(student.getPhoneNumber())){
                return "student allaqachon mavjud!";
            }
        }

        studentRepository.save(student);
        return "student saqlandi";
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public String deleteStudent(@PathVariable Integer id){
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()){
//            studentRepository.delete(optionalStudent.get());
            studentRepository.deleteById(id);
            return "student o'chirildi";
        }
        return "student topilmadi";
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
    public String editStudent(@PathVariable Integer id, @RequestBody Student student){

        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isEmpty())
            return "student topilmadi.";

        Student editingStudent = optionalStudent.get();
        editingStudent.setFirstName(student.getFirstName());
        editingStudent.setLastName(student.getLastName());
        editingStudent.setPhoneNumber(student.getPhoneNumber());
        editingStudent.setAge(student.getAge());

        studentRepository.save(editingStudent);
        return "student tahrirlandi!";
    }

}

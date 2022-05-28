package uz.pdp.app6springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.app6springjpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}

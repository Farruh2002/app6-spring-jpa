package uz.pdp.app6springjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id //primary key qiladi
    @GeneratedValue(strategy = GenerationType.IDENTITY) //toifasini serial qiladi
    private Integer id;

    @Column(nullable = false) //null bo'lishi mumkin emas (not null)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private Integer age;
}

package org.example;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Entity
@Table(name = "student_table")
public class Student {
    //     @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name = "id", nullable = false)
//    private int id;
    @Embedded
    private StudentName name;
    private String gender;
    @Column(unique = true)
    @Id
    private int rollNo;
    private int age;
//    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "student")
    private List<LAPTOP> laptopList = new ArrayList<>();


    @Override
    public String toString() {
        return "Student{" +
                "name=" + name +
                ", gender='" + gender + '\'' +
                ", rollNo=" + rollNo +
                ", age=" + age +
                ", laptopList=" + laptopList +
                '}';
    }
}

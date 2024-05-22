package org.example.Hql;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name = "newStudent")
public class Student {
    private String name;
    @Id
    private int rollNo;
    private int age;
    private int marks;

}

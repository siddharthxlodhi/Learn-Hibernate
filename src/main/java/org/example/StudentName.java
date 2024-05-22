package org.example;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class StudentName {
    private String Fname;
    private String Mname;
    private String Lname;


    @Override
    public String toString() {
        return "StudentName{" +
                "Fname='" + Fname + '\'' +
                ", Mname='" + Mname + '\'' +
                ", Lname='" + Lname + '\'' +
                '}';
    }
}

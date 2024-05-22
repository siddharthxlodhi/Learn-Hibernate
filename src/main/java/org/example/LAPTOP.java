package org.example;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class LAPTOP {
    @Id
    private int lid;
    private String lapName;
    //    @ManyToOne

    @ManyToOne
    @JoinColumn(name = "student_roll_no")
    private Student student;

    public LAPTOP(int lid, String lapName) {
        this.lid = lid;
        this.lapName = lapName;
    }

    @Override
    public String toString() {
        return "LAPTOP{" +
                "lid=" + lid +
                ", lapName='" + lapName + '\'' +
                '}';
    }
}

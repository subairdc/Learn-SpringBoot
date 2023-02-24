package com.subairdc.springboot.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course") //its an another entity
public class CourseMaterial implements Serializable{

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;
    //Cascade allows to DB action(two different table action at a time sequence manner)
    //LAZY type get data from DB only specific queries
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
//            optional = false
    ) //optional false means can't add courseMaterial alone (without course)
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    ) //add courseId column in course material table
    private Course course;
}
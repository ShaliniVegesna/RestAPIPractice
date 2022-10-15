package com.UserDemo.model;
import lombok.*;

import javax.persistence.*;

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Table(name = "RESOURCES")
    public class Resource {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name ="id")
        private Long id;
        @Column(name = "name")
        private String name;
        @Column(name = "year_of_creation")
        private int year_of_creation;
        @Column(name = "color")
        private String color;
        @Column(name = "pantone_value")
        private String pantone_value;
}

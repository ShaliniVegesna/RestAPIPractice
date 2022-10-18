package com.UserAndResource.model;
import lombok.*;

import javax.persistence.*;
import java.time.Year;

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
        @Column(name ="year_of_creation")
        private String year;
        @Column(name = "color")
        private String color;
        @Column(name = "pantone_value")
        private String pantone_value;
}

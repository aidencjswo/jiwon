package com.jiwon.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WeatherLocations {

    @Id
    @Column(length = 100)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wno;

    @Column(length = 100)
    private String dept1;

    @Column(length = 100)
    private String dept2;

    @Column(length = 100)
    private String dept3;

    @Column(length = 100)
    @MapKeyColumn(name = "nx")
    private String nx;

    @Column(length = 100)
    @MapKeyColumn(name = "ny")
    private String ny;
}

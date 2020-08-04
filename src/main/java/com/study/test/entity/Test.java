package com.study.test.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.List;

@Getter
@Table("Test")
@NoArgsConstructor
@AllArgsConstructor
public class Test implements Serializable {

    @Id
    private Long id;

    private String title;

    @With
    @Transient
    private List<Sub> subs;

    public Test(String title) {
        this.title =title;
    }
}

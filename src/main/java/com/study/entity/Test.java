package com.study.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("Test")
public class Test {

    @Id
    private Long no;

    private String title;
}

package com.study.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Builder
@AllArgsConstructor
@Getter
@Table("Sub")
@NoArgsConstructor
public class Sub {

    @Id
    private Long id;

    private Long testId;

    private String name;

    public Sub(Long testId, String name) {
        this.testId = testId;
        this.name = name;
    }
}

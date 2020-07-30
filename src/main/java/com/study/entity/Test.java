package com.study.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Getter
@Table("Test")
@NoArgsConstructor
public class Test {

    @Id
    private Long id;

    private String title;

    @MappedCollection(idColumn = "id")
    @Transient
    private List<Sub> subs;

    public Test(String title) {
        this.title =title;
    }
}

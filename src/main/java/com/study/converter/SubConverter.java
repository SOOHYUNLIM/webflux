package com.study.converter;

import com.study.entity.Sub;
import io.r2dbc.spi.Row;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

@ReadingConverter
public class SubConverter implements Converter<Row, Sub> {

    @Override
    public Sub convert(Row source) {
        Sub sub = Sub.builder().id(source.get("id", Long.class))
                .testId(source.get("test_id", Long.class))
                .name(source.get("name", String.class))
                .build();
        return sub;
    }
}

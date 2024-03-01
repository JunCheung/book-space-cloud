package com.bookspace.cloud.book.config;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class JacksonConfiguration {

    @Value("${spring.jackson.date-time-format:yyyy-MM-dd HH:mm:ss}")
    private String dateTimePattern;
    @Value("${spring.jackson.date-format:yyyy-MM-dd}")
    private String datePattern;

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
        return builder -> {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateTimePattern);
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(datePattern);

            builder.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(dateTimeFormatter));
            builder.deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(dateTimeFormatter));

            builder.serializerByType(LocalDate.class, new LocalDateSerializer(dateFormatter));
            builder.deserializerByType(LocalDate.class, new LocalDateDeserializer(dateFormatter));
        };
    }

}

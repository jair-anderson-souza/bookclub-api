package io.github.jass2125.beer.api.infraestrutura.configuracao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

/**
 *
 * @author <a href="https://victorhsr.github.io" target="_blank">Victor Hugo</a>
 * Created on 7 de jun de 2018
 * @project bids-api
 *
 *
 */
@Configuration
public class JacksonConfiguracao {

    public static final String PADRAO_LOCAL_DATE = "dd/MM/yyyy";
    public static final String PADRAO_DATE_TIME = "dd/MM/yyyy:HH:mm";

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer(JacksonProperties jacksonProperties) {
        return jacksonObjectMapperBuilder -> {
            DateTimeFormatter formatterLocalDate = DateTimeFormatter.ofPattern(PADRAO_LOCAL_DATE);
            DateTimeFormatter formatterLocalDateTime = DateTimeFormatter.ofPattern(PADRAO_DATE_TIME);

            jacksonObjectMapperBuilder.modules(
                    new JavaTimeModule()
                    .addSerializer(LocalDate.class, new LocalDateSerializer(formatterLocalDate))
                    .addSerializer(LocalTime.class, new LocalTimeSerializer(formatterLocalDateTime))
                    .addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(formatterLocalDateTime))
                    .addDeserializer(LocalDate.class, new LocalDateDeserializer(formatterLocalDate))
                    .addDeserializer(LocalTime.class, new LocalTimeDeserializer(formatterLocalDateTime))
                    .addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(formatterLocalDateTime))
            );
        };
    }

}

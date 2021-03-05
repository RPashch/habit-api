package com.lyceum.habitapi.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Habit {

    @Getter
    @Id
    private long id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String description;

//    @Getter
//    @Setter
//    private Category category;

    @Getter
    @Setter
    private Long categoryId;

    @Getter
    private Instant createdAt;


}

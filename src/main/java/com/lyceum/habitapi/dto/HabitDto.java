package com.lyceum.habitapi.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class HabitDto {

    @Getter
    @Id
    private long id;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private Long categoryId;

    @Getter
    @Setter
    private Instant createdAt;


}

package com.lyceum.habitapi.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class CategoryDto {

    private long id;
    private String title;
    private String description;
    private boolean isDefault;
    private Instant createdAt;

}

package com.lyceum.habitapi.dto;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class UserDto {

    @Getter
    @Id
    private long id;

    @Getter
    @Setter
    private String userName;
    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String lastName;

    @Getter
    @Setter
    private LocalDate birthDate;

    public List<HabitDto> habitDtos;

    @Getter
    @Setter
    private Instant createdAt;

}

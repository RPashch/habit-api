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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class User {

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

    @Getter
    @Setter
    private Instant createdAt;

    @Getter
    @Setter
    private List<Habit> habits = new ArrayList<>();

    @Getter
    @Setter
    private List<Category> categories = new ArrayList<>();

    public void addHabit(Habit habit) {
        habits.add(habit);
    }

}

package com.lyceum.habitapi;

import com.lyceum.habitapi.dao.CategoryRepository;
import com.lyceum.habitapi.dao.UserRepository;
import com.lyceum.habitapi.models.Category;
import com.lyceum.habitapi.models.Habit;
import com.lyceum.habitapi.models.User;
import com.lyceum.habitapi.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HabitApiApplication {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private HabitService habitService;

    public static void main(String[] args) {
        SpringApplication.run(HabitApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

//			String[] beanNames = ctx.getBeanDefinitionNames();
//			Arrays.sort(beanNames);
//			for (String beanName : beanNames) {
//				System.out.println(beanName);
//			}

            User user = User.builder()
                    .userName("keksik")
                    .firstName("Vitalik")
                    .lastName("Fontanskiy")
                    .build();

            Category category = Category.builder()
                    .description("some desc")
                    .title("title")
                    .build();

//            Long catId = categoryRepository.save(category)
//                    .getId();

            Category categoryPersisted = categoryRepository.save(category);

            Habit habit = Habit.builder()
                    .title("title")
                    .categoryId(categoryPersisted.getId())
                    .build();

            User persistedUser = userRepository.save(user);

//			User userFromDb = userRepository.findByUserName("test");


        };
    }

}

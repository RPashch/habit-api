package com.lyceum.habitapi;

import com.lyceum.habitapi.dao.CategoryRepository;
import com.lyceum.habitapi.dao.UserRepository;
import com.lyceum.habitapi.models.Category;
import com.lyceum.habitapi.models.Habit;
import com.lyceum.habitapi.models.User;
import com.lyceum.habitapi.service.HabitService;
import com.lyceum.habitapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HabitApiApplication {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private HabitService habitService;

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(HabitApiApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
//
////			String[] beanNames = ctx.getBeanDefinitionNames();
////			Arrays.sort(beanNames);
////			for (String beanName : beanNames) {
////				System.out.println(beanName);
////			}
//
//            User user = User.builder()
//                    .userName("keksik new")
//                    .firstName("Vitalik")
//                    .lastName("Fontanskiy")
//                    .build();

//             Category category = Category.builder()
//                   .description("description new category")
//                   .title("sport")
//                   .isDefault(false)
//                   .build();

//             categoryRepository.save(category);

////            Long catId = categoryRepository.save(category)
////                    .getId();
//
//            categoryRepository.save(category);
//
//            Habit habit = Habit.builder()
//                    .title("title")
//                    .categoryId(1L)
//                    .build();
////
//            User persistedUser = userRepository.save(user);
////
//            habitService.addHabit(habit, "1");

//            User userFromDb = userRepository.findByUserName("keksik new").get(0);
//            Habit habit1 = habitService.getHabit(1L);

//            System.out.println(habit1);


//            ERROR: column habit.user_key does not exist
//
////			User userFromDb = userRepository.findByUserName("test");
//
//

            List<User> users = userService.getUsersByName("keksik new");

            System.out.println(users);
        };
    }

}

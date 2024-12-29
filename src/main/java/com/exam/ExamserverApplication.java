package com.exam;

import com.exam.helper.UserFoundException;
import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.QuizRepository;
import com.exam.service.UserService;
//import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

//@EnableEncryptableProperties
@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {
    private static final Logger logger = LogManager.getLogger(ExamserverApplication.class);

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public QuizRepository quizRepository;

    public static void main(String[] args) {
        logger.info("Inside ExamserverApplication.main()");
        SpringApplication.run(ExamserverApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            System.out.println("starting code");
            User user = new User();
            user.setFirstName("Rajat");
            user.setLastName("Sharma");
            user.setUsername("imrrrsharma");
            user.setPassword(this.bCryptPasswordEncoder.encode("root"));
            user.setEmail("rajat@gmail.com");
            user.setProfile("default.png");

            Role role1 = new Role();
            role1.setRoleId(7L);
            role1.setRoleName("ADMIN");

            Set<UserRole> userRoleSet = new HashSet<>();
            UserRole userRole = new UserRole();

            userRole.setRole(role1);
            userRole.setUser(user);
            userRoleSet.add(userRole);

            User user1 = this.userService.createUser(user, userRoleSet);
            System.out.println(user1.getUsername());
        } catch (UserFoundException e) {
            e.printStackTrace();
        }
    }
}

package com.web.pinealgland;

import com.web.pinealgland.model.User;
import com.web.pinealgland.model.UserRepository;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication

public class PinealglandApplication {

	public static void main(String[] args) {
		SpringApplication.run(PinealglandApplication.class, args);
	}

	@Bean
    CommandLineRunner init(UserRepository userRepository) {
        
        return args -> {            
            Stream.of("L-Tryptophan", "5-hydroxytryptophan", "Serotonin", "N-acetylserotonin",
             "Melatonin","Beta-Carboline(Pinoline)",
             "1,2,3,4,-tetra-hydro-beta-carboline & 1-(3.5-dimethyl-oxypheny)-2-propyl-1,2,3,4-tetra-hydro-beta-carboline",
             "5-methoxylated indoleamine","N,N-dimethyl-5-methoxytryptamine","Benzodiazepine","5-methoxytryptamine").forEach(name -> {
                User user = new User(name, "");
                userRepository.save(user);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }

}

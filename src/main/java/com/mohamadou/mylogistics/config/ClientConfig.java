package com.mohamadou.mylogistics.config;

import com.mohamadou.mylogistics.entity.Client;
import com.mohamadou.mylogistics.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClientConfig {

    @Bean
    CommandLineRunner commandLineRunner (ClientRepository clientRepository) {
        return args -> {
           Client mohamadou = new Client(
                    "Mohamadou",
                    "Ndiaye",
                    "99000000",
                    "mohamadou@gmail.com"
            );
            Client aissatou = new Client(
                    "Aissatou",
                    "Diop",
                    "77777777",
                    "aissatou@gmail.com"
            );
            Client john = new Client(
                    "John",
                    "Doe",
                    "88898282",
                    "john@gmail.com"
            );

            clientRepository.saveAll(
                    List.of(mohamadou,aissatou,john)
            );
        };
    }
}

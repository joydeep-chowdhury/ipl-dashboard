package com.joydeep.ipldashboard;

import com.joydeep.ipldashboard.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@RestController
public class IplDashboardApplication {
    @Autowired
    private MatchRepository matchRepository;

    public static void main(String[] args) {
        SpringApplication.run(IplDashboardApplication.class, args);
    }

}

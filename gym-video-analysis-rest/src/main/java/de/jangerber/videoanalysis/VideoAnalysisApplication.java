package de.jangerber.videoanalysis;


import lombok.extern.slf4j.Slf4j;
import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TimeZone;

@SpringBootApplication
@Slf4j
public class VideoAnalysisApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoAnalysisApplication.class, args);
    }


    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        log.info("Start TCP H2 Server");
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Berlin"));
        log.info("Time Zone: set time zone to Europe/Berlin");
        log.debug("Current Time and Date: " + LocalTime.now() + " " + LocalDate.now());
    }
}
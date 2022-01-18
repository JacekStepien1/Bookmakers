package buk;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import buk.Services.bukTeams.TeamGenerator;
import buk.data.DataService;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@EnableScheduling
@SpringBootApplication
public class StartApp {

    @Autowired
    private ThreadStart thread;
    @Autowired
    private TeamGenerator teamGenerator;
    @Autowired
    DataService dataService;
    @Autowired
    StartApp startApp;

    public static void main(String[] args) {
        SpringApplication.run(StartApp.class, args);
    }

    @PostConstruct
    public void init() throws Exception {
//        teamGenerator.teamsGenerator();
        dataService.createLinks();
//		thread.threadStart1();
    }

    @Scheduled(cron = "01 40 9 * * *")
    public void startThread() throws Exception {
        thread.threadStart1();
    }

    @Scheduled(cron = "02 50 12 * * *")
    public void startThread2() throws Exception {
        thread.threadStart1();
    }

    @Scheduled(cron = "02 12 15 * * *")
    public void startThread3() throws Exception {
        thread.threadStart1();
    }

    @Scheduled(cron = "02 15 17 * * *")
    public void startThread4() throws Exception {
        thread.threadStart1();
    }

    @Scheduled(cron = "02 40 18 * * *")
    public void startThread5() throws Exception {
        thread.threadStart1();
    }

    @Scheduled(cron = "02 05 20 * * *")
    public void startThread6() throws Exception {
        thread.threadStart1();
    }

    @Scheduled(cron = "02 45 22 * * *")
    public void startThread7() throws Exception {
        thread.threadStart1();
    }

    //	@Scheduled(cron =  "02 30 2 * * *")
//	public void startThread8 () throws Exception {
//		thread.threadStart1();
//	}
    @Scheduled(cron = "02 10 7 * * *")
    public void startThread9() throws Exception {
        thread.threadStart1();
    }


    //sec, min, hour, day, month, year
    @Scheduled(cron = "01 01 1 * * *")
    public void startThreadScorer() throws Exception {
        thread.threadStart2();
    }

	// 30000 = 30sec
//	@Scheduled(fixedDelay = 3300000, initialDelay = 9000)

}

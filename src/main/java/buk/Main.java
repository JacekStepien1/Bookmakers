package buk;

import buk.Services.*;
import buk.Services.bukTeams.TeamGenerator;
import buk.data.DataService;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@EnableScheduling
public class Main {

    @Autowired
    private WebReaderSTS webReaderSts;
    @Autowired
    private WebReaderFortuna webReaderFortuna;
    @Autowired
    private WebReaderIForBet webReaderIForBet;
    @Autowired
    private WebReaderBetClic webReaderBetClic;
    @Autowired
    private WebReaderLvBet webReaderLvBet;
    @Autowired
    private WebReaderEwinner webReaderEwinner;
    @Autowired
    private WebReaderSuperbet webReaderSuperbet;
    @Autowired
    private WebReaderTotalBet webReaderTotalBet;
    @Autowired
    private WebReaderTotolotek webReaderTotolotek;
    @Autowired
    private WebReaderPzBuk webReaderPzBuk;
    @Autowired
    private WebReaderNobleBet webReaderNobleBet;
    @Autowired
    private WebReaderEtoto webReaderEtoto;
    @Autowired
    private WebReaderBetfan webReaderBetfan;
    @Autowired
    private WebReaderBetX webReaderBetX;
    @Autowired
    private MainService mainService;
    @Autowired
    DataService dataService;
    @Autowired
    ScoresReader scoresReader;
    @Autowired
    Test test;


    WebDriver driver;
    WebDriver driver2;
    Random r = new Random();
    int n;

    public void start1() throws Exception {

        // thread 01
        n = (r.nextInt(1200)) * 1000;
        Thread.sleep(n);
        driver = mainService.driver();
        webReaderSts.matchesReader();
        webReaderBetClic.matchesReader();
        webReaderIForBet.matchesReader();
        webReaderFortuna.matchesReader(driver);
        webReaderLvBet.matchesReader(driver);
        webReaderEwinner.matchesReader(driver);
        webReaderSuperbet.matchesReader(driver);
        webReaderTotalBet.matchesReader(driver);
        webReaderBetfan.matchesReader(driver);
        webReaderNobleBet.matchesReader(driver);
        webReaderPzBuk.matchesReader(driver);
        webReaderEtoto.matchesReader(driver);
        webReaderBetX.matchesReader(driver);
        driver.close();
    }


    public void start4() throws Exception {
        // thread 04
        driver2 = mainService.driver();
        scoresReader.matchesReader(driver2);
        driver2.close();
    }

}

package scs.mair.statisticsserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scs.mair.statisticsserver.model.Demographic;
import scs.mair.statisticsserver.model.TopDemographic;
import scs.mair.statisticsserver.persistence.Repository;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/data")
public class Controller {
    private final Repository repository = new Repository();

    public Controller() throws IOException {
    }

    @GetMapping("/year={year}")
    public HashMap<String, List<Demographic>> getYearDemographics(@PathVariable String year) {
        System.out.println("Request received "+ LocalDateTime.now());
        return repository.getYear(year);
    }

    @GetMapping("/top/year={year}")
    public List<TopDemographic> getTopDemographics(@PathVariable String year) {
        System.out.println("Request received "+ LocalDateTime.now());
        return repository.getTop(year);
    }
}

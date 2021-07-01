package scs.mair.statisticsserver.persistence;

import scs.mair.statisticsserver.model.Demographic;
import scs.mair.statisticsserver.model.TopDemographic;
import scs.mair.statisticsserver.utils.DataParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    private final HashMap<String, HashMap<String, List<Demographic>>> yearData;
    private final HashMap<String, List<TopDemographic>> topData;

    public Repository() throws IOException {
        this.yearData = DataParser.getYear();
        this.topData = DataParser.getTop();
    }

    public HashMap<String, List<Demographic>> getYear(String searchYear) {
        return yearData.get(searchYear);
    }

    public List<TopDemographic> getTop(String searchYear) {
        return topData.get(searchYear);
    }
}

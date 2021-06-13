package scs.mair.statisticsserver.persistence;

import scs.mair.statisticsserver.model.Demographic;
import scs.mair.statisticsserver.utils.DataParser;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@org.springframework.stereotype.Repository
public class Repository {
    private final HashMap<String, HashMap<String, List<Demographic>>> data;

    public Repository() throws IOException {
        this.data = DataParser.getData();
    }

    public HashMap<String, List<Demographic>> getYear(String searchYear) {
        return data.get(searchYear);
    }
}

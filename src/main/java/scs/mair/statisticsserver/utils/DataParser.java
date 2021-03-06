package scs.mair.statisticsserver.utils;

import scs.mair.statisticsserver.model.Demographic;
import scs.mair.statisticsserver.model.TopDemographic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DataParser {
    private final static List<String> years = Arrays.asList("2006", "2013", "2018");
    private final static List<String> regions = Arrays.asList("01", "02", "03", "04", "05", "06", "07", "08", "09", "12", "13", "14", "15", "16", "17", "18", "99");

    private static Demographic getDemographic(String line) {
        String[] words = line.split(" ");
        String ethnicity = words[0].split(":")[1];
        String age = words[1].split(":")[1];
        String gender = words[2].split(":")[1].replace("\t", " ").split(" ")[0];
        String number = words[2].split(":")[1].replace("\t", " ").split(" ")[1];
        return new Demographic(Integer.parseInt(number), gender, ethnicity, age);
    }

    public static HashMap<String, HashMap<String, List<Demographic>>> getYear() throws IOException {
        String basePath = "/Users/andrei/AplicatieLicenta/censusOutput/";
        StringBuilder path;

        File file;
        BufferedReader bufferedReader;

        HashMap<String, HashMap<String, List<Demographic>>> yearData = new HashMap<>();
        HashMap<String, List<Demographic>> regionData;

        for (String year : years) {
            regionData = new HashMap<>();
            for (String region : regions) {
                List<Demographic> demographics = new LinkedList<>();
                path = new StringBuilder();
                path.append(basePath).append(year).append("/").append(region).append("/result");
                file = new File(path.toString());
                bufferedReader = new BufferedReader(new FileReader(file));

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    demographics.add(getDemographic(line));
                }
                regionData.put(region, demographics);
            }
            yearData.put(year, regionData);
        }

        return yearData;
    }

    public static HashMap<String, List<TopDemographic>> getTop() throws IOException {
        String basePath = "/Users/andrei/AplicatieLicenta/censusOutput/topTen/";
        StringBuilder path;

        File file;
        BufferedReader bufferedReader;

        HashMap<String, List<TopDemographic>> topData = new HashMap<>();

        for (String year : years) {
            List<TopDemographic> demographics = new LinkedList<>();
            path = new StringBuilder();
            path.append(basePath).append(year).append("/result");

            file = new File(path.toString());
            bufferedReader = new BufferedReader(new FileReader(file));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split(",");
                demographics.add(new TopDemographic(Integer.parseInt(words[5]), words[4]));
            }
            topData.put(year, demographics);
        }

        return topData;
    }

}

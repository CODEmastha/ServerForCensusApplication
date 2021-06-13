package scs.mair.statisticsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import scs.mair.statisticsserver.utils.DataParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@SpringBootApplication
public class StatisticsServerApplication {
    private static String loadStream(InputStream s) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(s));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null)
            sb.append(line).append("\n");
        return sb.toString();
    }

    private static void executeShell() throws Exception {
        String cmd = "/Users/andrei/AplicatieLicenta/run.sh";
        Process process = Runtime.getRuntime().exec(cmd);

        String output = loadStream(process.getInputStream());
        String error = loadStream(process.getErrorStream());
        int rc = process.waitFor();
        System.out.println(rc);
        System.out.println(output);
        System.out.println(error);
    }

    public static void main(String[] args) throws Exception {
        executeShell();
        SpringApplication.run(StatisticsServerApplication.class, args);
    }

}

package exercise;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static String getForwardedVariables(String content) {
        String noQuotesContent = content.replaceAll("\"", "");
        String mappedEnvVarsStr = noQuotesContent.lines()
                .filter(line -> line.startsWith("environment"))
                .map(str -> str.replace("environment=", "")
                        .split(","))
                .map(strArr -> Arrays.stream(strArr)
                        .filter(el -> el.contains("X_FORWARDED"))
                        .map(s -> s.replace("X_FORWARDED_", ""))
                        .collect(Collectors.toList()))
                .flatMap(seq -> seq.stream())
                .collect(Collectors.joining(","));
        return mappedEnvVarsStr;
    }
}
//END

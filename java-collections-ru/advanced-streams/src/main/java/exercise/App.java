package exercise;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static String getForwardedVariables(String content) {
        String noQuotesContent = content.replaceAll("\"", "");
        List<String> mappedEnvVars = noQuotesContent.lines()
                .filter(line -> line.startsWith("environment"))
                .map(str -> {
                    List<String> strArr = Arrays.stream(str.replace("environment=", "")
                                                  .split(","))
                                       .filter(el -> el.contains("X_FORWARDED"))
                                       .map(s -> s.replace("X_FORWARDED_", ""))
                                       .collect(Collectors.toList());
                    return strArr;
                })
                .flatMap(seq -> seq.stream())
                .collect(Collectors.toList());
        return specifiedListToString(mappedEnvVars);
    }
    private static String specifiedListToString(List<String> envVars) {
        String outputStr = "";
        if (envVars.size() == 0) {
            return outputStr;
        }
        Iterator<String> listIterator = envVars.iterator();
        String firstElem = listIterator.next();
        outputStr = outputStr.concat(firstElem);
        while (listIterator.hasNext()) {
            outputStr =  outputStr.concat(",")
                                  .concat(listIterator.next());
        }
        return outputStr;
    }
}
//END

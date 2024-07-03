package exercise;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.nio.file.Paths;
import java.nio.file.Files;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String source1, String source2, String destination) {
        return CompletableFuture.supplyAsync(() -> getString(source1))
                .thenCombine(CompletableFuture.supplyAsync(() -> getString(source2)), (text1, text2) -> {
                    var output = text1 + text2;
                    try {
                        Files.writeString(Paths.get(destination).toAbsolutePath().normalize(), output);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    return output;
                })
                .exceptionally(ex -> {
                    System.out.println(ex.getMessage());
                    return null;
                });
    }

    private static String getString(String source2) {
        try {
            return Files.readString(Paths.get(source2).toAbsolutePath().normalize());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        var dir = "src/main/resources/";
        unionFiles(dir + "file1.txt", dir + "file2.txt", dir + "result.txt");
        // END
    }


}


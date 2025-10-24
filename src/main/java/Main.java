import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException {

        //Task #1
        Invoker invoker = new Invoker();
        invoker.start();

        //Task #2
        Path dir = Paths.get("Procvetova");
        Files.createDirectories(dir);

        Path file = dir.resolve("Veronica.txt");
        Files.createFile(file);

        Path dir123 = dir.resolve("dir1/dir2/dir3");
        Files.createDirectories(dir123);

        Files.copy(file, Paths.get("Procvetova/dir1/dir2/dir3/Veronica.txt"),StandardCopyOption.REPLACE_EXISTING);

        Path dir1 = Paths.get("Procvetova/dir1");
        Path file1 = dir1.resolve("file1.txt");
        Files.createFile(file1);

        Path file2 = Paths.get("Procvetova/dir1/dir2").resolve("file2.txt");
        Files.createFile(file2);

        try (Stream<Path> stream = Files.walk(dir)){
            stream.forEach(p -> System.out.println((Files.isDirectory(p) ? "D: " : "F: ") + p.getFileName()));
        }

        try (Stream<Path> stream = Files.walk(dir1)) {

            stream.sorted(Comparator.reverseOrder())
                    .forEach(p -> {
                        try {
                            Files.delete(p);

                        } catch (Exception e) {

                            //e.printStackTrace();
                        }
                    });
        }
    }
}
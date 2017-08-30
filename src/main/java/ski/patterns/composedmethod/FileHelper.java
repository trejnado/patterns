package ski.patterns.composedmethod;

import java.io.File;
import java.util.Arrays;
import java.util.regex.Pattern;

public class FileHelper {

    private void print(String... args) {
        File current = (args == null || args.length == 0) ? new File(".") : new File(args[0]);

        String[] loaded;
        if (args != null && args.length > 1) {
            loaded = current.list((file1, name) -> Pattern.compile(args[1]).matcher(name).matches());
        } else {
            loaded = current.list();
        }

        // For better readability
        Arrays.sort(loaded);

        String[] names = loaded;

        System.out.println("Files and directories in " + current.getAbsolutePath());
        for (String file : names) {
            System.out.println(file);
        }
    }

    public static void main(final String[] args) {
        FileHelper exec = new FileHelper();
        exec.print();

        exec.print("/var/log", "system.*");
    }
}

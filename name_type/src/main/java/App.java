import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) throws IOException {

        Path workingDirectory = Paths.get(".");
        System.out.println("Program uruchomiono w pliku" + workingDirectory.toAbsolutePath());

        ObjectMapper mapper = new ObjectMapper();

        //ladny zapis w pliku
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        //towrzenie nowego pliku
        File plik = new File("index.json");

        //tworzenie listy plikow w folderze
        File folder = new File(workingDirectory.toString());
        File[] listOfFiles = folder.listFiles();
        List<Type> tb = new ArrayList<Type>();

        //pętla po wszytkich plikach
        for (File file : listOfFiles) {
            if (file.isFile() || file.isDirectory()) {
                Type t = new Type();
                t.setName(file.getName());
                t.setType(Files.probeContentType(file.toPath()));
                tb.add(t);
            }
        }

        //tutaj zapisuje do plku
        mapper.writeValue(plik, tb);

    }
}

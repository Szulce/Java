import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.assertj.core.util.Arrays;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

public class TypeTest {
    private File ccc;
    private List<Type> ListType;

    @Before
    public void start() throws IOException {
        //tworze plik do zapisu
        ccc = new File("testJson.json");
        //tworze nowy folder na pliki
        Path workSpace = Paths.get(".");
        File f = new File(workSpace.toAbsolutePath().toString() + "/ToTest");
        f.mkdir();
        //tworze testowe pliki i jeden atalog
        File f1 = new File(f, "testTxt.txt");
        f1.createNewFile();
        File f2 = new File(f, "testXml.xml");
        f2.createNewFile();
        File f3 = new File(f, "testRar.rar");
        f3.createNewFile();
        File f4 = new File(f, "testJs.js");
        f4.createNewFile();
        File f5 = new File(f, "testDirectory");
        f5.mkdir();

        ObjectMapper mapper = new ObjectMapper();
        //ladny zapis w pliku json
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        //tworzenie listy plikow w folderze
        File[] listOfFiles = f.listFiles();
        ListType = new ArrayList<Type>();

        //pętla po wszytkich plikach
        for (File file : listOfFiles) {
            if (file.isFile() || file.isDirectory()) {
                Type t = new Type();
                t.setName(file.getName());
                t.setType(Files.probeContentType(file.toPath()));
                ListType.add(t);
            }
        }

        //tutaj zapisuje do plku
        mapper.writeValue(ccc, ListType);

    }

    @Test
    public void JsonTest() throws IOException {

        //teraz sprawdzam odczyt
        //  ObjectMapper mapper = new ObjectMapper();
        //InputStream is = Type.class.getResourceAsStream(f.getName());
        //Type typeTEST = mapper.readValue(is, Type.class);
        /* lopatologicznie
        Type typeTest = mapper.readValue(ccc,Type.class);
        assertThat(typeTest.getName()).isEqualTo("testTxt.txt");
        assertThat(typeTest.getType()).isEqualTo("plain/text");

        typeTest = mapper.readValue(ccc,Type.class);
        assertThat(typeTest.getName()).isEqualTo("testXml.xml");
        assertThat(typeTest.getType()).isEqualTo("application/xml");

        typeTest = mapper.readValue(ccc,Type.class);
        assertThat(typeTest.getName()).isEqualTo("testDoc.doc");
        assertThat(typeTest.getType()).isEqualTo("doc");

        typeTest = mapper.readValue(ccc,Type.class);
        assertThat(typeTest.getName()).isEqualTo("testJs.js");
        assertThat(typeTest.getType()).isEqualTo("js");

        typeTest = mapper.readValue(ccc,Type.class);
        assertThat(typeTest.getName()).isEqualTo("testplik");
        assertThat(typeTest.getType()).isEqualTo("inode/directory");
        */
        //po kolei odczytuje obiekty
        ObjectMapper objectMapper = new ObjectMapper();
        Type[] asArray = objectMapper.readValue(ccc, Type[].class);
       // List<Type> asList = objectMapper.readerFor(Type.class).readValue(ccc);
        assertThat(asArray[3].getName()).isEqualTo("testDirectory");
        assertThat(asArray[3].getType()).isEqualTo("inode/directory");

        assertThat(asArray[0].getName()).isEqualTo("testJs.js");
        assertThat(asArray[0].getType()).isEqualTo("text/plain");

        assertThat(asArray[1].getName()).isEqualTo("testRar.rar");
        assertThat(asArray[1].getType()).isEqualTo("text/plain");

        assertThat(asArray[4].getName()).isEqualTo("testTxt.txt");
        assertThat(asArray[4].getType()).isEqualTo("text/plain");

        assertThat(asArray[2].getName()).isEqualTo("testXml.xml");
        assertThat(asArray[2].getType()).isEqualTo("text/plain");




    }


}

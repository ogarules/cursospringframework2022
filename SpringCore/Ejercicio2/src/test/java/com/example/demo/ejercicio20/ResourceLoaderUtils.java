package com.example.demo.ejercicio20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResourceLoaderUtils {
    
    private static IInputStreamReader isrr = (InputStream ir) -> {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(ir));
        return buffer.lines().collect(Collectors.joining("\n"));
    };

    private static IInputStreamReader isrre = new IInputStreamReader() {

        @Override
        public String read(InputStream input) throws Exception {
            try (BufferedReader buffer = new BufferedReader(new InputStreamReader(input))) {
                return buffer.lines().collect(Collectors.joining("\n"));
            }
        }
    };

    public static void loadTextFileTest(Resource resource) throws Exception {
        String expectedText = "Lorem ipsum dolor sit amet, \n"
                + "consectetur adipiscing elit, \n"
                + "sed eiusmod tempor incidunt ut labore et dolore magna aliqua. \n\n"
                + "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquid ex ea commodi consequat. Quis aute iure reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint obcaecat cupiditat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

        String readText = isrr.read(resource.getInputStream());
        Assert.assertEquals(expectedText, readText);

        log.info(readText);
    }
    
    public static void loadPropertiesTest(Resource resource) throws Exception {
        String expectedTest = "certificatic.curso=Spring Framework 5\n" +
                "certificatic.description=My fantastict and fabolouse Spring  Course\n" +
                "certificatic.instructor=oga";

        String redText = isrr.read(resource.getInputStream());

        Assert.assertEquals(expectedTest, redText);

        log.info(redText);

        Properties properties = new Properties();
        properties.load(resource.getInputStream());

        Assert.assertEquals("oga", properties.getProperty("certificatic.instructor"));

    }
    
    public static void urlResourceLoadTest(Resource resource) throws Exception {
        String expecString = "Spring | Home";

        String readText = isrr.read(resource.getInputStream());
        log.info(readText);

        Document doc = Jsoup.parse(readText);

        Assert.assertEquals(expecString, doc.title());
    }

    public static void imageResourceCopyTest(Resource resource, String path) throws Exception {
        String expString = "logo.png";

        FileCopyUtils.copy(resource.getInputStream(), new FileOutputStream(new File(path, resource.getFilename())));

        Path copiedpath = Paths.get(path + resource.getFilename());

        Assert.assertTrue(Files.exists(copiedpath, LinkOption.NOFOLLOW_LINKS));
        Assert.assertEquals(expString, copiedpath.getFileName());
    }

}

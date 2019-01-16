package tai.demo.demo;
import jdk.internal.org.xml.sax.InputSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import tai.demo.demo.Book;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

@RestController
public class RESController {

    @GetMapping("/customer")
    public Book[] getBook() throws ParserConfigurationException, IOException, SAXException {
        String xml = ""; //Populated XML String....

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("../xml/test.xml"));
        Element rootElement = document.getDocumentElement();
        Book[] books = new Book[2];
        books[0] = new Book(" ","Peter", "Smith", 1874,70.0);
        books[1] = new Book(" ","Everyday Italian","Yusuf Altıparmak",1937,30.0);
        return books;
    }

    @PostMapping("/customer")
    public String postCustomer(@RequestBody Book customer){
        System.out.println(customer);
        return "Done";
    }

    @GetMapping("/hello-world")
    @ResponseBody
    public Book sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return new Book(" ","Everyday Italian","Yusuf Altıparmak",1937,30.0);
    }
}

// CORS REMOVE BLOCKADE FOR LOCALHOST ACCESS
@Configuration
class MyConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
            }
        };
    }
}
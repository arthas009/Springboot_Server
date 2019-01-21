package tai.demo.demo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import org.xml.sax.SAXException;


import javax.xml.bind.annotation.XmlRootElement;

import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;





@RestController
public class RESController {

    @GetMapping("/customer")
    @ResponseBody
    public Bookcase<String,Bookcasearraylist<Book>> getBooks(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) throws ParserConfigurationException, IOException, SAXException {
     /*   String xml = ""; //Populated XML String....

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("C:/Users/misafir/Desktop/Yusuf Altıparmak -  stajyer/Yusuf Altıparmak -  stajyer/Yusuf Altıparmak -  stajyer/website/xml/test.xml"));
        Element rootElement = document.getDocumentElement();
        Book[] books = new Book[2];
        books[0] = new Book(" ","Peter", "Smith", 1874,70.0);
        books[1] = new Book(" ","Everyday Italian","Yusuf Altıparmak",1937,30.0);
        */
        Bookcasearraylist bookcase = new Bookcasearraylist();
        bookcase.add(new Book("","Peterrr","Smithh",1874,70.0));
        bookcase.add(new Book("","Yusuf","Altıparmak",1874,70.0));
        bookcase.add(new Book("","Yusuf","6parmak",1874,70.0));

        Bookcase<String,Bookcasearraylist<Book>> returnmap = new Bookcase<>();
        returnmap.put("Book", bookcase);
        return returnmap;
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
@Configuration
class MyConfiguration {

    @Bean
    public ObjectMapper mapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
        return mapper;
    }
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
@XmlRootElement(name = "bookcase")
class Bookcasearraylist<Book> extends ArrayList {
}

class Bookcase<String,Bookcasearraylist> extends HashMap
{

}
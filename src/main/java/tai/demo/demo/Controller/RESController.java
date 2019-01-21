package tai.demo.demo.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tai.demo.demo.Bookcase.Book;
import tai.demo.demo.Bookcase.Bookcase;

import java.util.LinkedList;
import java.util.List;


@RestController
public class RESController {

    @GetMapping("/")
    @ResponseBody
    public Bookcase<String, List<Book>> getBooks(){
        List<Book> bookcase = new LinkedList<Book>();
        bookcase.add(new Book("","Peterrr","Smithh",1874,70.0));
        bookcase.add(new Book("","Yusuf","Altıparmak",1874,70.0));
        bookcase.add(new Book("","Everyday Italian","Yusuf 6parmak",1874,70.0));
        bookcase.add(new Book("","Everyday Romanian","Yusuf Sixfinger",1874,70.0));
        Bookcase<String,List<Book>> returnmap = new Bookcase<>();
        returnmap.put("Books", bookcase);
        return returnmap;
    }

    @PostMapping("/hello-world")
    @ResponseBody
    public Book sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return new Book(" ","Everyday Italian","Yusuf Altıparmak",1937,30.0);
    }

    @GetMapping("/test/{first}/{second}")
    @ResponseBody
    public ResponseEntity<String> multiplication(@PathVariable("first") Integer first, @PathVariable("second") Integer second){
        return new ResponseEntity<String>(Integer.toString(first*second), HttpStatus.OK);
    }

}


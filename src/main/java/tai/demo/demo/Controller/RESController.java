package tai.demo.demo.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tai.demo.demo.Bookcase.New;
import tai.demo.demo.Bookcase.News;
import tai.demo.demo.Bookcase.ParameterObject;
import tai.demo.demo.Bookcase.Parameters;

import java.lang.reflect.Parameter;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;


@RestController
public class RESController {

    @GetMapping("/")
    @ResponseBody
    public News<String, List<New>> getNews(){

        Random rnd = new Random();
        List<New> news = new LinkedList<New>();


        int totalelements = rnd.nextInt(25)+5;
        System.out.println(totalelements);
        for(int i = 0;i<totalelements;i++)
        {
            String haberAdi = "Haber 1";
            String haberIcerigi = "Yarışmada ilk 3'e giren sporcularımız";
            String haberTarihi = "Ağustos 2020";

            /*
            int[] timestamps = new int[7];
            timestamps[0] = rnd.nextInt(101)+5;
            timestamps[1] = rnd.nextInt(100)+5;
            timestamps[2] = rnd.nextInt(100)+5;
            timestamps[3] = rnd.nextInt(100)+5;
            timestamps[4] = rnd.nextInt(100)+5;
            timestamps[5] = rnd.nextInt(100)+5;
            timestamps[6] = rnd.nextInt(100)+5;
            //
            */

            news.add(new New(haberAdi,haberIcerigi,haberTarihi));
        }




        News<String,List<New>> returnmap = new News<>();
        returnmap.put("New", news);
        return returnmap;
    }

    @GetMapping("/news")
    @ResponseBody
    public News<String, List<New>> haberleriVer(){

        Random rnd = new Random();
        List<New> news = new LinkedList<New>();


        int totalelements = rnd.nextInt(25)+5;
        System.out.println(totalelements);
        for(int i = 0;i<totalelements;i++)
        {
            String haberAdi = "Haber "+(i+1);
            String haberIcerigi = "Yarışmada ilk "+i+"'e giren sporcularımız arışmada ilk \"+i+\"'e giren sporcularımız arışmada ilk \"+i+\"'e giren sporcularımız arışmada ilk \"+i+\"'e giren sporcularımız arışmada ilk \"+i+\"'e giren sporcularımız arışmada ilk \"+i+\"'e giren sporcularımız";
            String haberTarihi = "Ağustos 2020";

            /*
            int[] timestamps = new int[7];
            timestamps[0] = rnd.nextInt(101)+5;
            timestamps[1] = rnd.nextInt(100)+5;
            timestamps[2] = rnd.nextInt(100)+5;
            timestamps[3] = rnd.nextInt(100)+5;
            timestamps[4] = rnd.nextInt(100)+5;
            timestamps[5] = rnd.nextInt(100)+5;
            timestamps[6] = rnd.nextInt(100)+5;
            //
            */

            news.add(new New(haberAdi,haberIcerigi,haberTarihi));
        }




        News<String,List<New>> returnmap = new News<>();
        returnmap.put("New", news);
        return returnmap;
    }



/*
    @PostMapping("/hello-world")
    @ResponseBody
    public ParameterObject sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return new ParameterObject(" ","Everyday Italian","Yusuf Altıparmak",1937,30.0);
    }
*/
    @GetMapping("/test/{first}/{second}")
    @ResponseBody
    public ResponseEntity<String> multiplication(@PathVariable("first") Integer first, @PathVariable("second") Integer second){
        return new ResponseEntity<String>(Integer.toString(first*second), HttpStatus.OK);
    }

 // 65-122
 public static String generateString() {
     String uuid = UUID.randomUUID().toString();
     return "uuid = " + uuid;
 }

}


package tai.demo.demo.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Parameters<String, List<ParameterObject>> getBooks(){

        Random rnd = new Random();
        List<ParameterObject> parameters = new LinkedList<ParameterObject>();



        int totalelements = rnd.nextInt(25)+5;

        for(int i = 0;i<totalelements;i++)
        {
            int[] timestamps = new int[7];
            timestamps[0] = rnd.nextInt(101)+5;
            timestamps[1] = rnd.nextInt(100)+5;
            timestamps[2] = rnd.nextInt(100)+5;
            timestamps[3] = rnd.nextInt(100)+5;
            timestamps[4] = rnd.nextInt(100)+5;
            timestamps[5] = rnd.nextInt(100)+5;
            timestamps[6] = rnd.nextInt(100)+5;
            //
            parameters.add(new ParameterObject("",generateString(),generateString(),
                    rnd.nextInt()%200+1800,rnd.nextDouble()%200+1800,generateString(),
                    rnd.nextInt()%200+1800,rnd.nextInt()%2000+1800,timestamps));
        }
        System.out.println("Sending: "+parameters);
        Parameters<String,List<ParameterObject>> returnmap = new Parameters<>();
        returnmap.put("Parameter", parameters);
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


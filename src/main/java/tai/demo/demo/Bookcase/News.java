package tai.demo.demo.Bookcase;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;

@XmlRootElement(name = "News")
@JsonRootName(value = "News")
public class News<Strign,News> extends HashMap
{

}
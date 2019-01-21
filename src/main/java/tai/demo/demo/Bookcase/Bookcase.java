package tai.demo.demo.Bookcase;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;

@XmlRootElement(name = "Bookcase")
@JsonRootName(value = "Bookcase")
public class Bookcase<Strign,Bookcasearraylist> extends HashMap
{

}
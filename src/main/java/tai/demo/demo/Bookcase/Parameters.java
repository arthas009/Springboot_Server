package tai.demo.demo.Bookcase;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;

@XmlRootElement(name = "Parameters")
@JsonRootName(value = "Parameters")
public class Parameters<Strign,ParameterObject> extends HashMap
{

}
package tai.demo.demo.Bookcase;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "ParameterObject")
@JsonRootName(value = "ParameterObject")
public class ParameterObject {
    private String parameter1;
    private String parameter2;
    private int parameter3;
    private double parameter4;
    private String definition;
    private int minvalue;
    private int maxvalue;

    @XmlElement(name = "ParameterObject")
    private int[] timestamps;

    public ParameterObject(){}

    public ParameterObject(String irrelevelant, String parameter1, String parameter2, int parameter3,double parameter4,String definition,int minvalue,int maxvalue,int[] timestamps){
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
        this.parameter3 = parameter3;
        this.parameter4 = parameter4;
        this.definition = definition;
        this.minvalue = minvalue;
        this.maxvalue = maxvalue;


        this.timestamps = timestamps;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void setMaxvalue(int maxvalue) {
        this.maxvalue = maxvalue;
    }

    public void setMinvalue(int minvalue) {
        this.minvalue = minvalue;
    }

    public void setParameter1(String parameter1) {
        this.parameter1 = parameter1;
    }

    public void setParameter2(String parameter2) {
        this.parameter2 = parameter2;
    }

    public void setParameter3(int parameter3) {
        this.parameter3 = parameter3;
    }

    public void setParameter4(double parameter4) {
        this.parameter4 = parameter4;
    }

    public String getDefinition() {
        return definition;
    }

    public double getParameter4() {
        return parameter4;
    }

    public int getMaxvalue() {
        return maxvalue;
    }

    public int getMinvalue() {
        return minvalue;
    }

    public int getParameter3() {
        return parameter3;
    }

    public String getParameter1() {
        return parameter1;
    }

    public String getParameter2() {
        return parameter2;
    }

    public int[] getTimestamp()
    {
        return timestamps;
    }
    public void setTimestamp(int[] timestamps)
    {
        this.timestamps=timestamps;
    }
    @Override
    public String toString() {
        return  ""+parameter1+ parameter2+parameter3+parameter4+ definition+ minvalue+ maxvalue+timestamps;

    }
}
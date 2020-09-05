package tai.demo.demo.Bookcase;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "ParameterObject")
@JsonRootName(value = "ParameterObject")
public class New {

    private String haberBasligi;
    private String haberIcerigi;
    private String haberTarihi;


    public New(){}

    public New(String haberBasligi, String haberIcerigi,String haberTarihi)
    {   this.haberBasligi = haberBasligi;
        this.haberIcerigi = haberIcerigi;
        this.haberTarihi = haberTarihi;
    }
    public void setHaberBasligi(String haberBasligi) {
        this.haberBasligi = haberBasligi;
    }
    public String getHaberBasligi() {
    return this.haberBasligi;
    }
    public void setHaberIcerigi(String haberIcerigi) {
        this.haberIcerigi = haberIcerigi;
    }
    public String getHaberIcerigi() {
        return this.haberIcerigi;
    }
    public void setHaberTarihi(String haberTarihi) {this.haberTarihi = haberTarihi;}
    public String getHaberTarihi() { return this.haberTarihi;}

    @Override
    public String toString() {
        return  ""+haberBasligi+ haberIcerigi;

    }
}
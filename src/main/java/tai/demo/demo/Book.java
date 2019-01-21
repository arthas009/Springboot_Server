package tai.demo.demo;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "Book")
@JsonRootName(value = "Book")
public class Book {
    private String title;
    private String author;
    private int year;
    private double price;

    public Book(){}

    public Book(String irrelevelant, String title, String author, int year,double price){
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getAuthor(){
        return this.author;
    }

    public void setYear(int year){
        this.year = year;
    }

    public int getYear(){
        return this.year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String info = String.format("Book Info: Title = %s, Author = %s, year = %d, price = %f",
                title, author, year,price);
        return info;
    }

}
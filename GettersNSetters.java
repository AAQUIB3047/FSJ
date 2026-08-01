class Book {
    private String title;
    private String author;
    private double price;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    
}

public class GettersNSetters {
    public static void main(String[] args) {
        Book b1 = new Book();
        b1.setTitle("Java");
        b1.setAuthor("AAquib");
        b1.setPrice(500);
        System.out.println("Title is " + b1.getTitle());
        System.out.println("Author is " + b1.getAuthor());
        System.out.println("Price is " + b1.getPrice());
    }
}

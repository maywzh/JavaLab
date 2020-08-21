import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

interface Observer {
    public void update(Object obj);
}

abstract class Observable {
    private Vector<Observer> obVector = new Vector<>();

    public void addObserver(Observer observer) {
        this.obVector.add(observer);
    }

    public void delObserver(Observer observer) {
        this.obVector.remove(observer);
    }

    public void notifyObservers(Book book) {
        for (var observer : obVector) {
            observer.update(book);
        }
    }
}

/**
 * InnerOBMain
 */
class Book {
    public String bookName;
    public String author;

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book[bookName=" + bookName + ",author=" + author + "]";
    }
}

class Library extends Observable {
    private List<Book> bookList;

    Library() {
        this.bookList = new ArrayList<>();
        Book android = new Book("Android", "李江东");
        Book Hong = new Book("红楼梦", "曹雪芹");
        this.bookList.add(android);
        this.bookList.add(Hong);
    }

    public void addBook(Book book) {
        this.bookList.add(book);
        super.notifyObservers(book);
    }

    public void delBook(Book book) {
        this.bookList.remove(book);
    }
}

class ReaderA implements Observer {

    public ReaderA() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void update(Object object) {
        // TODO Auto-generated method stub
        System.out.println("我是读者A,收到了新书:" + object.toString());
    }

}

class ReaderB implements Observer {

    public ReaderB() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void update(Object object) {
        // TODO Auto-generated method stub
        System.out.println("我是读者B,收到了新书:" + object.toString());
    }
}

public class OBMain {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Library library = new Library();
        Observer readerAObserver = new ReaderA();
        Observer readerBObserver = new ReaderB();
        // 添加读者A
        library.addObserver(readerAObserver);
        // 添加读者B
        library.addObserver(readerBObserver);
        // 添加一本新书
        Book book = new Book("朝花夕拾", "鲁迅");
        library.addBook(book);
    }

}
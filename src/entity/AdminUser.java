package entity;

import com.kqb.dao.AddBook;
import com.kqb.dao.RemoveBook;
import com.kqb.dao.UpdateBook;

import java.util.Arrays;

public class AdminUser extends User implements RemoveBook, UpdateBook, AddBook {
    public AdminUser() {
    }

    public AdminUser(String userName, String password) {
        super(userName, password);
    }
//
    @Override
    public Book[] insetBook(Book book, Book[] bs) {
        boolean boo=true;
        for (int i = 0; i < bs.length; i++) {
            if (book.getBookName().equals(bs[i].getBookName())){
                System.out.println("本馆已收藏此书无法再次添加！");
                boo=false;
                break;
            }
        }
        if (boo){
          bs=Arrays.copyOf(bs,bs.length+1);
            bs[bs.length-1]=book;
            System.out.println("添加成功");
        }
        return bs;

    }


    @Override
    public Book[] deleteBooksByName(String bookName, Book[] bs) {
        boolean boo=false;
        for (int i = 0; i < bs.length; i++) {
            if (bookName.equals(bs[i].getBookName())){
                boo=true;
                break;
            }
        }
        if (boo){
            Book[] newdebs=new Book[bs.length-1];
            int j=0;
            for (int i = 0; i < bs.length; i++) {
                if (!bs[i].getBookName().equals(bookName)){
                    newdebs[j]=bs[i];
                    j++;
                }
            }
            bs=newdebs;
        }
        return bs;
    }

    @Override
    public void setBooksByName(String bookName, Book[] bs, Book newBook) {
        boolean boo=false;
        for (int i = 0; i < bs.length; i++) {
            if (bookName.equals(bs[i].getBookName())){
                boo=true;
                break;
            }
        }
        if (boo){
            for (int i = 0; i < bs.length; i++) {
                if (bookName.equals(bs[i].getBookName())){
                    bs[i]=newBook;
                }
            }
        }else {
            System.out.println("本馆未收藏此书无法修改");
        }

    }

}

package entity;

import com.kqb.dao.QueryBook;

public abstract class User implements QueryBook {
    private String userName;//用户名
    private String password;//密码

    public User() {
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //查询所有图书
    @Override
    public void selectBook(Book[] bs) {
        for (int i = 0; i < bs.length; i++) {
            System.out.println("图书名："+bs[i].getBookName()+",作者："+bs[i].getAuthorName()+",售价："+bs[i].getPrice()+",库存："+bs[i].getInventory());
        }
    }
    //查询指定图书
    @Override
    public void selectByBookName(String bookName, Book[] bs) {
        boolean boo=false;
        for (int i = 0; i < bs.length; i++) {
            if (bookName.equals(bs[i].getBookName())){
                System.out.println("图书名："+bs[i].getBookName()+",作者："+bs[i].getAuthorName()+",售价："+bs[i].getPrice()+",库存："+bs[i].getInventory());
                boo=true;
                break;
            }
        }
        if (!boo){
            System.out.println("本馆暂未收藏此书！");
        }

    }

}

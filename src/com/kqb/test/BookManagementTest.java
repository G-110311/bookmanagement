package com.kqb.test;

import com.kqb.dao.RemoveBook;
import entity.AdminUser;
import entity.Book;
import entity.NormalUser;
import entity.User;

import java.util.Scanner;

public class BookManagementTest {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        Book[] books={new Book("三国演义","罗贯中",100.0,50),
                new Book("水浒传","施耐庵",150.0,50),
                new Book("西游记","吴承恩",100.0,50),
                new Book("红楼梦","曹雪芹",100.0,50)};
        User[] users={ new AdminUser("匡其斌","123456"),
                new NormalUser("小明","123456"),
                new NormalUser("小红","123456"),
                new NormalUser("小郭","123456")};
        User user=null;
        int number=5;
        while (true){
            System.out.println("欢迎使用图书管理系统，请先登录(你还有"+number+"次登录机会)：");
            System.out.println("请输入您的账户名：");
            String name=sc.next();
            System.out.println("请输入您的密码：");
            String password=sc.next();
            number--;
            int j=-1;
            for (int i = 0; i < users.length; i++) {
               if (users[i].getUserName().equals(name)&&users[i].getPassword().equals(password)){
                   j=i;
                   break;
            }
            }
            if (j!=-1){
               user=users[j];
                System.out.println("登录成功");
            }else {
                System.out.println("您的账号或密码错误，请重新输入");

            }
            if (user!=null){
                boolean boo=false;
                    while (true){
                        System.out.println("=====欢迎进入图书管理系统=====");
                        System.out.println("请选择你的操作: 1.查看所有图书信息 2.查看指定图书信息 3.添加图书信息 4.删除图书信息 5.修改图书信息 6. 退出到登录界面 7.退出图书管理系统");
                        int n= sc.nextInt();
                        if (n==6){
                            System.out.println("退出到管理界面");
                            break;
                        }
                        if (n==7){
                           boo=true;
                           break;
                        }
                        switch (n){
                            case 1-> user.selectBook(books);
                            case 2 -> {
                                System.out.println("请输入你要查看书籍名：");
                                user.selectByBookName(sc.next(),books);
                            }
                            case 3->{
                                if (user instanceof RemoveBook){
                                    Book newBook=new Book();
                                    System.out.println("请输入你要添加书籍的名称：");
                                    newBook.setBookName(sc.next());
                                    System.out.println("请输入你要添加书籍的作者姓名：");
                                    newBook.setAuthorName(sc.next());
                                    System.out.println("请输入你要添加书籍的售价：");
                                    newBook.setPrice(sc.nextDouble());
                                    System.out.println("请输入你要添加书籍的库存：");
                                    newBook.setInventory(sc.nextInt());
                                    books=((AdminUser)user).insetBook(newBook,books);
                                    user.selectBook(books);
                                }else {
                                    System.out.println("操作失败！");
                                    System.out.println("你无权添加图书信息");
                                }
                            }
                            case 4->{
                                if (user instanceof RemoveBook){
                                    System.out.println("请输入你要删除书籍的名称：");
                                   books=((AdminUser)user).deleteBooksByName(sc.next(),books);
                                    user.selectBook(books);
                                }else {
                                    System.out.println("操作失败！");
                                    System.out.println("你无权删除图书信息");
                                }
                            }
                            case 5->{
                                if (user instanceof RemoveBook){
                                    Book newBook=new Book();
                                    System.out.println("请输入你要修改书籍的名称：");
                                    newBook.setBookName(sc.next());
                                    System.out.println("图书作者修改为：");
                                    newBook.setAuthorName(sc.next());
                                    System.out.println("价格修改为：");
                                    newBook.setPrice(sc.nextDouble());
                                    System.out.println("库存修改为：");
                                    newBook.setInventory(sc.nextInt());
                                    ((AdminUser)user).setBooksByName(newBook.getBookName(),books,newBook);
                                    user.selectBook(books);
                                }else {
                                    System.out.println("操作失败！");
                                    System.out.println("你无权修改图书信息");
                                }
                            }
                            default -> System.out.println("参数错误，请输入正确的操作");
                        }
                    }
                    if (boo){
                        System.out.println("退出图书管理系统，谢谢使用!");
                        break;
                    }
                }
            if (number==0){
                System.out.println("账号锁定，请联系管理员:3282703798@qq.com");
                break;
            }
            }

        }
    }



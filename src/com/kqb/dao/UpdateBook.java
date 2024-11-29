package com.kqb.dao;

import entity.Book;

/**
 * 修改图书信息接口
 */
public interface UpdateBook {
    /**
     * 根据图书名修改图书信息
     * @param bookName 被修改的图书名
     * @param bs 存放所有图书的数组
     * @param newBook 存放了新图书的对象
     */
     public abstract  void  setBooksByName(String bookName, Book[] bs,Book newBook);
}

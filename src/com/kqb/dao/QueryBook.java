package com.kqb.dao;

import entity.Book;

/**
 * 查询图书功能接口
 */
public interface QueryBook {
    /**
     * 查看所有的图书信息
     * @param bs 被操作的图书数组
     */
    public abstract  void  selectBook(Book[] bs);

    /**
     * 根据图书名查询单个图书信息
     * @param bookName
     * @param bs 被操作的图书数组
     */
    public abstract void selectByBookName(String bookName,Book[] bs);

}

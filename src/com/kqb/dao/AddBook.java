package com.kqb.dao;

import entity.Book;

/**
 * 添加图书接口
 */
public interface AddBook {
    /**
     * 在原图书数组中末尾添加一个图书信息
     * @param book 被添加的图书对象
     * @param bs  原图书数组
     * @return 添加后新数组地址
     */
    public abstract Book[] insetBook(Book book,Book[] bs);
}

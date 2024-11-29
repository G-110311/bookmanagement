package com.kqb.dao;

import entity.Book;

/**
 * 删除图书信息
 */
public interface RemoveBook {
    /**
     * 删除指定的图书对象
     * @param bookName 被删除的图书名
     * @param bs 存放所有图书信息的数组
     * @return 删除后新数组的地址
     */
        public abstract  Book[] deleteBooksByName(String bookName,Book[] bs);
}

package com.example.crazyandroid.activities;

import com.example.crazyandroid.R;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

/**
 * Created by yinlijun on 16-11-16.
 */

public class BookContent {
    public static class Book {
        public Integer id;
        public String title;
        public String desc;
        public Book(Integer id, String title, String desc) {
            this.id = id;
            this.title = title;
            this.desc = desc;
        }

        public String toString() {
            return title;
        }
    }
    public static List<Book> ITEMS = new ArrayList<Book>();
    public static Map<Integer, Book> ITEM_MAP = new HashMap<Integer, Book>();
    static {
        addItem(new Book(1, "aaa", "a aaa"));
        addItem(new Book(2, "bbb", "a bbb"));
        addItem(new Book(3, "ccc", "a ccc"));
    }
    private static void addItem(Book book) {
        ITEMS.add(book);
        ITEM_MAP.put(book.id, book);
    }
}

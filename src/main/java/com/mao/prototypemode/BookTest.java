package com.mao.prototypemode;

/**
 * @author mao
 * @date 2021-06-27
 */
public class BookTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Book book1 = new Book();
        book1.setTitle("图书1");
        book1.addImage("图片1");
        book1.showBook();

        Book book2 = (Book) book1.clone();
        book2.setTitle("图书2");
        book2.addImage("图片2");
        book2.showBook();

        book1.showBook();
    }
}

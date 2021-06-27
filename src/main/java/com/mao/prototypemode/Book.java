package com.mao.prototypemode;

import java.util.ArrayList;

/**
 * @author mao
 * @date 2021-06-27
 */
public class Book implements Cloneable{
    /**
     * 标题
     */
    private String title;
    /**
     * 图片列表
     */
    private ArrayList<String> image = new ArrayList<>();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Book book = (Book) super.clone();
        // 深复制
        book.setImage((ArrayList<String>) image.clone());
        return book;
    }

    public void addImage(String img) {
        image.add(img);
    }

    /**
     * 打印内容
     */
    public void showBook() {
        System.out.println("-------start--------");
        System.out.println("title:" + this.title);
        for (String img : image) {
            System.out.println("image name:" + img);
        }
        System.out.println("-------end--------");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getImage() {
        return image;
    }

    public void setImage(ArrayList<String> image) {
        this.image = image;
    }
}

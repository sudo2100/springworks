package com.springboot.boardweb;

public class BookTest {

    public static void main(String[] args) {
        ClassBook cbook = new ClassBook();
        cbook.setTitle("리액트 배우기");
        cbook.setPrice(32000);

        System.out.println("제목: " + cbook.getTitle());
        System.out.println("가격: " + cbook.getPrice());
        System.out.println(cbook); //com.springboot.boardweb.ClassBook@4f47d241

        System.out.println("==================");

        RecordBook rbook = new RecordBook("스프링부트", 40000);
        System.out.println("제목: " + rbook.title());
        System.out.println("가격: " + rbook.price());
        System.out.println(rbook);  // RecordBook[title=스프링부트, price=40000]
    }


}

package org.example.exceptionprac;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try{
            // 문제상황이 발생했다고 가정하자.
            // if (스페셜어택이 불가능하면)
            // : 하지만 이 경우는 내가 에러를 알고 있어서 if ~ else로 하는게 나음
            if (true){
                // 런타임에러를 만들었음
                throw new RuntimeException("error message");
            }
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("runtime error!");
        }

//        try {
//            Files.readString(Paths.get("src/main/resource"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try {
            func();
        } catch (RuntimeException e) {
            System.out.println("error in func");
        }

    }

    public static void func() throws RuntimeException{
        System.out.println("func");

        throw new RuntimeException("func error");
    }

}


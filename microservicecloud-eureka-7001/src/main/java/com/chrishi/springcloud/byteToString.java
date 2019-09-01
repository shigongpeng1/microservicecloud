package com.chrishi.springcloud;

import java.io.UnsupportedEncodingException;

public class byteToString {

    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] b = {1,2,3,4,5,6,99,82};
        for(byte y:b){
            System.out.print(y);
        }
        System.out.println("");
        String str = new String(b,"UTF-8");
        System.out.println(str);

        byte[] c = str.getBytes("UTF-8");
        for(byte d:c){
            System.out.print(d);
        }
    }
}

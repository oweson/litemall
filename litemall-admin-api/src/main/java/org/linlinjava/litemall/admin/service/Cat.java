package org.linlinjava.litemall.admin.service;


import java.util.ArrayList;
import java.util.List;

/**
 * @author oweson
 * @date 2020/10/22 22:47
 */


public class Cat extends AdminGoodsService {
    public static void listSth(List list){
        if(list instanceof ArrayList){
            ArrayList arrayList = (ArrayList) list;
            System.out.println(arrayList);

        }
    }
    public static void main(String[] args) {


    }
}

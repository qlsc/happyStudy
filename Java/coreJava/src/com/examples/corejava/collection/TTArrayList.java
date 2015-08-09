package com.examples.corejava.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:  TTArrayList
 * 自己实现 ArrayList
 * @auther: qlsc
 * @date: 15/8/8
 */
public class TTArrayList {

    private Object[] elementData;

    private int size;

    public TTArrayList(){
        this(10);
    }

    public TTArrayList(int initialCapacity){
        if(initialCapacity<0){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        elementData = new Object[initialCapacity];
    }

    public void add(Object obj){
        ensureCapacity();

        elementData[size] = obj;
        size++;
    }

    public void ensureCapacity() {
        //判断数组扩容和数据拷贝
        if(size>=elementData.length){
            Object[] newArray = new Object[size*2+1];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData = newArray;
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public Object get(int index){
        rangeCheck(index);
        return elementData[index];
    }

    public void remove(int index){
        rangeCheck(index);
        //删除指定位置的对象
        int numMoved = size - index -1;
        if (numMoved>0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
    }

    public void remove(Object obj){
        for (int i = 0; i < size; i++) {
            if(get(i).equals(obj)){
                remove(i);
            }
        }
    }

    public Object set(int index,Object obj){
        rangeCheck(index);
        Object oldValue = elementData[index];
        elementData[index] = obj;
        return oldValue;
    }

    public void add(int index,Object obj){
        rangeCheck(index);
        ensureCapacity();
        System.arraycopy(elementData,index,elementData,index+1,size-index);
        elementData[index] = obj;
        size++;
    }

    public void rangeCheck(int index) {
        if (index<0||index>=size){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        TTArrayList list = new TTArrayList(3);
        list.add("123");
        list.add("456");
        list.add("789");
        list.add("aa");
        list.add("bb");
        list.add("cc");
        System.out.println(list.get(2));
        list.remove(2);
        System.out.println(list.get(2));
        System.out.println(list.size());
        System.out.println("=============test======");
        List list1 = new ArrayList();
        list1.add("123");
        list1.add("456");
        list1.add("789");
        list1.add("aa");
        list1.add("bb");
        list1.add("cc");
        System.out.println(list1.get(2));
        list1.remove(2);
        System.out.println(list1.get(2));
        System.out.println(list1.size());

    }
}

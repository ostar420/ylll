/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ylll.core.model;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
public class Test {
    static abstract class TypeReference<T> implements Comparable<TypeReference<T>> {
        final Type _type;

        protected TypeReference() {
            Type superClass = getClass().getGenericSuperclass();
            if (superClass instanceof Class<?>) { // sanity check, should never happen
                throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
            }
            /* 22-Dec-2008, tatu: Not sure if this case is safe -- I suspect
             *   it is possible to make it fail?
             *   But let's deal with specifc
             *   case when we know an actual use case, and thereby suitable
             *   work arounds for valid case(s) and/or error to throw
             *   on invalid one(s).
             */
            _type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
        }

        public Type getType() { return _type; }

        /**
         * The only reason we define this method (and require implementation
         * of <code>Comparable</code>) is to prevent constructing a
         * reference without type information.
         */
        @Override
        public int compareTo(TypeReference<T> o) {
            // just need an implementation, not a good one... hence:
            return 0;
        } 
    }
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Throwable {
        TypeReference<?> tr = null;
        String className = "java.util.ArrayList<java.lang.String>"; //假设是这样的泛型参数
        //String className = "java.lang.String";
        List<String> cnList = new ArrayList<String>(); //解析泛型参数结果集
        if (className.matches("[^<>]*?<.*?>")) { //如果包含多个泛型参数，则解析每一层参数
            cnList.add(className.substring(0, className.indexOf("<")));
            String sub = className.substring(className.indexOf("<")+1, className.lastIndexOf(">"));
            while (sub.contains("<")) {
                cnList.add(sub.substring(0, sub.indexOf("<")));
                sub = sub.substring(sub.indexOf("<")+1, sub.lastIndexOf(">"));
            }
            cnList.add(sub);
        } else {
            cnList.add(className);
        }

        if (cnList.size() == 1) {//如果只有1层泛型参数
            Class<?> c = Class.forName(cnList.get(0));
            if (c == String.class) { //判断是什么类型的参数，生成相应的子类对象
                tr = new TypeReference<String>(){};
            } else if (c == Integer.class) { //so on
                tr = new TypeReference<Integer>(){};
            } else { 
                tr = new TypeReference<Object>(){};
            }
        } else if (cnList.size() == 2) { //有2层泛型参数
            Class<?> c1 = Class.forName(cnList.get(0));
            Class<?> c2 = Class.forName(cnList.get(1));
            if (List.class.isAssignableFrom(c1)) { //先判断第1层泛型参数
                if (c2 == String.class) { //再判断第2层泛型参数
                    tr = new TypeReference<List<String>>(){}; //生成相应的子类实例
                } else if (c2 == Integer.class) {
                    tr = new TypeReference<List<Integer>>(){};
                } else {
                    tr = new TypeReference<List<Object>>(){};
                }
            } else if (Set.class.isAssignableFrom(c1)) { //so on
                if (c2 == String.class) {
                    tr = new TypeReference<Set<String>>(){};
                } else if (c2 == Integer.class) {
                    tr = new TypeReference<Set<Integer>>(){};
                } else {
                    tr = new TypeReference<Set<Object>>(){};
                }
            } else {
                tr = new TypeReference<Object>(){};
            }
        } else {//泛型参数太多，直接简化为用Object
            tr = new TypeReference<Object>(){};
        }

        System.out.println(tr.getType());
        Class<?> c = tr.getClass(); //取得子类对象的Class对象
        //use reflect to create instance //接下来就可以用c通过反射来生成实例了
         TypeReference<?> o = (TypeReference<?>)c.newInstance();
        System.out.println(o.getType()); 
    }
    
     
}
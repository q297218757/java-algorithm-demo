package com.java.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个列表，该列表中的每个要素要么是个列表，要么是整数。将其变成一个只包含整数的简单列表
 * 样例  1:
 * 	输入: [[1,1],2,[1,1]]
 * 	输出:[1,1,2,1,1]
 *
 * 	样例解释:
 * 	将其变成一个只包含整数的简单列表。
 *
 *
 * 样例 2:
 * 	输入: [1,2,[1,2]]
 * 	输出:[1,2,1,2]
 *
 * 	样例解释:
 * 	将其变成一个只包含整数的简单列表。
 *
 * 样例 3:
 * 	输入:[4,[3,[2,[1]]]]
 * 	输出:[4,3,2,1]
 *
 * 	样例解释:
 * 	将其变成一个只包含整数的简单列表。
 */
public class Flatten {
    public List <Integer> s(List<NestedInteger> nestedList) {
       List list = new ArrayList();
        return list;
    }

    public interface NestedInteger {

              // @return true if this NestedInteger holds a single integer,
              // rather than a nested list.
              public boolean isInteger();

              // @return the single integer that this NestedInteger holds,
              // if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();

              // @return the nested list that this NestedInteger holds,
              // if it holds a nested list
             // Return null if this NestedInteger holds a single integer
             public List<NestedInteger> getList();
  }
}

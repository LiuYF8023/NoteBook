# LeetCode 热题 HOT 100

[TOC]

# 2、两数之和

## 2.1 我的思路和代码

### 2.1.1 思路

1、链表的的值都取出来放入ArrayList中

2、然后做补齐的操作（填0）。

3、然后反转一下链表。

4、从最后一位开始按位求和，求和过程中，进行链表重构

### 2.1.2 代码

```java
class Solution {
   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      // 都取出来 重新构建
      List<Integer> l1List = new ArrayList<>();
      List<Integer> l2List = new ArrayList<>();
      while (l1 != null) {
         l1List.add(l1.val);
         l1 = l1.next;
      }
      while (l2 != null) {
         l2List.add(l2.val);
         l2 = l2.next;
      }
      if (l1List.size() > l2List.size()) {
         int tempSize = l2List.size();
         for (int i = 0; i < l1List.size() - tempSize; i++) {
            l2List.add(0);
         }
      } else {
         int tempSize = l1List.size();
         for (int i = 0; i < l2List.size() - tempSize; i++) {
            l1List.add(0);
         }
      }
      Collections.reverse(l1List);
      Collections.reverse(l2List);
      ListNode res = new ListNode();
      ListNode pre = new ListNode();
      pre = res;
      // before 表示进位 now 表示当前位
      int before = 0;
      int now = 0;
      for (int i = l1List.size() - 1; i >= 0; i--) {
         // 获取当前值
         int val1 = l1List.get(i);
         int val2 = l2List.get(i);
         // 进行加操作
         if (val1 + val2 + before > 9) {
            // 需要进位
            now = val1 + val2 - 10 + before;
            before = 1;
         } else {
            now = val1 + val2 + before;
            before = 0;
         }

         pre.next = new ListNode(now);
         pre = pre.next;
      }
      if (before > 0) {
         pre.next = new ListNode(before);
         pre = pre.next;
      }
      return res.next;
   }
}
//leetcode submit region end(Prohibit modification and deletion)
```

## 2.2 递归思路

![image-20230224101653615](pictures/image-20230224101653615.png)



### 2.2.1 思路

这个题感觉可以用递归的思想，先计算2+5，然后再计算后面的。

如果有短的链表的话，后面的值只保存长链表部分与进位的和就行了。

> 传入helper的链表节点如果为空，不能直接写p.next，会报错的，因为p有可能是空的，需要判断一下

### 2.2.2 代码

```java
ListNode res = new ListNode();
ListNode pre = new ListNode();
int before = 0;
int now = 0;

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
   pre = res;
   helper(l1, l2);
   if (before > 0) {
      pre.next = new ListNode(before);
      pre = pre.next;
   }
   return res.next;
}

public void helper(ListNode l1, ListNode l2) {
   if (l1 == null && l2 == null) {
      return;
   }
   int l1Val = (l1 != null ? l1.val : 0);
   int l2Val = (l2 != null ? l2.val : 0);

   // 进行加操作
   if (l1Val + l2Val + before > 9) {
      // 需要进位
      now = l1Val + l2Val - 10 + before;
      before = 1;
   } else {
      now = l1Val + l2Val + before;
      before = 0;
   }

   pre.next = new ListNode(now);
   pre = pre.next;
   helper(l1 != null ? l1.next : null, l2 != null ? l2.next : null);
}
```

# 48、图像旋转

## 48.1 思路


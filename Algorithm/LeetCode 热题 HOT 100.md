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

# 3、无重复字符的最长子串

## 3.1 我的思路和代码

### 3.1.1 思路

给定一个子串，我们从头开始进行遍历，以abcabcbb为例，我们可以申请一个哈希表，用于存储已经出现过的字母，每次遍历到一个字符都与哈希表中对应位置进行比较，如果出现过，那么记录下当前子串的长度，然后清空哈希表继续进行后面的遍历。

空格ASCII  32

数字 48～57

还是败了。常规方法解不出来。比如dvdk，d处重复，应该考虑的是从v重新开始找，而如果按照我的想法，他就是从d开始找了，结果就是2（dk），而实际上结果应该是3（vdk）



## 3.2 滑动窗口解决方案

### 3.2.1 思路

设定两个指针，left和right，二者之间的是一个滑动窗口。

我们每次先记录下right所在位置字符，将其加入到哈希表中，然后right进行右移的操作。

紧接着，我们需要进行一个判断，就是当前滑动窗口内的内容是否有重复的情况，也就是hashStr[(int)s.charAt(right)] != 0 是否不等于0，不等于0说明之前是出现过这个字符的。所以我们需要收缩窗口。

收缩之前先记录下当前的长度（与res）取最大

然后需要把left字符在哈希表中做移除操作，然后left向右移动，相当于更新了滑动窗口。

最终返回Math.max(res,right - left)，因为有可能最大字符串在上一次更新res之后是不重复的，所以会导致res不会更新，在返回结果的时候，我们需要进行一次更新。

### 3.2.2 代码

```java
int left = 0;
int right = 0;
int res = 0;
int[] hashStr = new int[128];
while(right < s.length()){
   // 记录出现的字符
   hashStr[(int)s.charAt(right)]++;
   right++;

   while(right < s.length() && hashStr[(int)s.charAt(right)] != 0){// 说明之前出现过这个字符了，需要收缩窗口
      // 先记录下最大长度
      res = Math.max(res,right - left);
      // 把这个字符移除哈希表
      hashStr[(int)s.charAt(left)]--;
      // 指针向右移动
      left++;
   }
}
return Math.max(res,right - left);
```

# 4、寻找两个正序数组的中位数

## 4.1 不保证时间复杂度的情况

```java
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
   int[] res = new int[nums1.length + nums2.length];
   int index = 0;
   for (int i = 0; i < nums1.length; i++) {
      res[index++] = nums1[i];
   }
   for (int i = 0; i < nums2.length; i++) {
      res[index++] = nums2[i];
   }
   Arrays.sort(res);
   double result = 0;
   // 中位数如果是单数 那么就在 length / 2的位置
   // 如果是双数 那么就在 length / 2 和 length / 2 - 1的位置
   if (res.length % 2 != 0) {
      result = res[res.length / 2];
   } else {
      result = (res[res.length / 2] + res[res.length / 2 - 1]) * 1.0 / 2;
   }
   return result;
}
```

能过，但是复杂度比较高，应该是m+n+ (m+n)*log(m+n)

题目要求log(m+n)

## 4.2 分治思想



# 5、最长回文子串

## 5.1 暴力求解

超时了

```java
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
   public String longestPalindrome(String s) {
      if (s.length() == 1) {
          return s;
      }
      Map<Integer, String> map = new HashMap<>();
      for (int i = 0; i < s.length(); i++) {
         for (int j = i + 1; j <= s.length(); j++) {
            if (judge(s.substring(i, j))) {
               map.put(s.substring(i, j).length(), s.substring(i, j));
            }
         }
      }
      // 找到最大的key
      int max = 0;
      for (Integer i : map.keySet()) {
         if (i > max) {
            max = i;
         }
      }
      return map.get(max);
//        System.out.println(judge("bb"));
   }

   public boolean judge(String str) {
      String leftStr = new StringBuffer(str.substring(0, str.length() / 2)).toString();
      String rightStr = null;
      if (str.length() % 2 == 0) {
         rightStr = new StringBuffer(str.substring(str.length() / 2, str.length())).reverse().toString();
      } else {
         rightStr = new StringBuffer(str.substring(str.length() / 2 + 1, str.length())).reverse().toString();
      }
      return leftStr.equals(rightStr);
   }
}
//leetcode submit region end(Prohibit modification and deletion)
```

## 5.2 双指针方式

我们首先外部的大循环是遍历字符串的每一个位置，同时，只要我们选定了一个位置，那么我们使用双指针向该位置的两边进行扩散，然后一直判断当前左右指针指向的值是不是一样的，不一样则退出，记录下长度。注意最长回文奇数长度和偶数长度的我们要分开进行判断

```java
class Solution {

   public String longestPalindrome(String s) {
      String res = "";
      for (int i = 0; i < s.length(); i++) {
         String s1 = helper(s,i,i);
         String s2 = helper(s,i,i+1);
         res = s1.length() > res.length() ? s1 : res;
         res = s2.length() > res.length() ? s2 : res;
      }
      return res;
   }

   public String helper(String str,int left,int right){
      while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
         // 向两边扩散
         left--;
         right++;
      }
      // 最终返回的是当前的最长回文子串
      // left + 1的原因是，当我们上一个对称字符判断成功，left会左移
      // 如果此时不成功，那么应该从left的右边第一个字符开始切割，右边界正好切不到，所以是right
      return str.substring(left + 1,right);
   }

}
//leetcode submit region end(Prohibit modification and deletion)
```

我们来分析一下两种方法的时间复杂度，首先之前那种暴力解法，时间复杂度应该是O(n方)，使用双指针的方式，外层循环是O(n)，内层循环最大是（所有元素都比较了一次）应该是O(n/2)，所以最终相当于节省了一半的时间。因为字符串的长度是1000，也就是说之前方法的大概是在一百万级别，修改之后是在50万级别。

# 11、盛水最多的容器

## 11.1 思路及代码

### 11.1.1 贪心

把所有的情况能够盛的水都计算一遍就行了

```java
class Solution {
   public int maxArea(int[] height) {
      int max = 0;
      for (int i = 0; i < height.length; i++) {
         for (int j = i + 1; j < height.length; j++) {
            // 计算长度
            int x = j - i;
            int y = Math.min(height[i], height[j]);
            if (x * y > max) {
               max = x * y;
            }
         }
      }
      return max;
   }
}
//leetcode submit region end(Prohibit modification and deletion)
```

果然，超时了

### 11.1.2 双指针 移动较低的一边

```java
public int maxArea(int[] height) {
      int left = 0;
      int right = height.length - 1;
      int area = 0;
      while(left < right){
         // 计算当前的面积
         int areaTemp = (right - left) * Math.min(height[left],height[right]);
         if(areaTemp > area){
            area = areaTemp;
         }else {
            // 移动指针 移动较小的那个，因为面积取决于较小的高度
            if(height[left] < height[right]){
               left++;
            }else {
               right--;
            }
         }
      }
      return area;
   }
```



# 15、三数之和

## 15.1 思路与代码

### 15.1.1 思路

我们需要先对数组进行排序。

我们循环遍历整个数字，取出当前位置作为基准，然后在后面的去找两个值，使其保证和为0

left = i + 1 

right = len - 1

如果找到了三个值，他们的和为0，那么我们先把他们加入到res中。之前我们需要判断i所在位置是不是重复的，比如

-4 -1 -1 0 1 2 这种，两个-1 找出的结果是一样的，没有必要重复添加

然后我们需要判断的是，例如-2 0 0 2 2 这种，如果nums[left] == nums[left + 1]是一样的，那么没必要继续加入结果集，同理nums[right] == nums[right - 1] 这种的也不需要加入结果集，我们直接移动左右指针进行跳过。

然后我们继续收缩左右指针即可。

### 15.1.2 代码

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
   public List<List<Integer>> threeSum(int[] nums) {
      // 特殊情况
      // 如果排序之后，最小值都是0 那么一定数组全是0
      List<List<Integer>> res = new ArrayList<>();
      Arrays.sort(nums);

      for (int i = 0; i < nums.length; i++) {
         if (nums[i] > 0) { // 如果当前的数字大于0，那么通过之后的一定组合不成三数之和等于0
            break;
         }
         if (i > 0 && nums[i] == nums[i - 1]) { // 相当于重复的
            continue;
         }
         int left = i + 1;
         int right = nums.length - 1;
         while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum == 0) {
               res.add(Arrays.asList(nums[i], nums[left], nums[right]));
               while (left < right && nums[left] == nums[left + 1]) {
                  left++;
               }
               while (left < right && nums[right] == nums[right - 1]) {
                  right--;
               }
               left++;
               right--;
            } else if (sum < 0) {
               left++;
            } else if (sum > 0) {
               right--;
            }
         }
      }
      return res;
   }
}
//leetcode submit region end(Prohibit modification and deletion)
```



# 20、有效的括号

## 20.1 思路及代码

### 20.1.1 思路

使用一个栈进行匹配处理，匹配上的就出栈，最终看栈是否为空，不为空说明有的没正确匹配。

### 20.1.2 代码

```java
class Solution {
    public boolean isValid(String s) {
        // 先处理一下字符串
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(!stack.empty()){
                if(stack.peek().equals('(') && s.charAt(i) == ')' ||
                        stack.peek().equals('[') && s.charAt(i) == ']' ||
                        stack.peek().equals('{') && s.charAt(i) == '}'
                  ){
                    stack.pop();
                }else {
                    stack.push(s.charAt(i));
                }
            }else {
                stack.push(s.charAt(i));
            }
        }

        return stack.empty();
    }
}
```



# 24、两两交换链表中的节点

## 24.1 常规思路及代码

### 24.1.1 思路

对于只给首节点的，我们最好给他加上一个头结点

编程的细节上还要注意，如果我们new ListNode()，那么这个时候是创建了一个节点，如果我们只是进行赋值，比如ListNode temp  = pre; 那么这个temp表示的是指向这个节点的指针。

### 24.1.2 代码

```java
class Solution {
	public ListNode swapPairs(ListNode head) {
		// 定义头结点
		ListNode pre = new ListNode(0);
		pre.next = head;

		ListNode temp = pre;
		// 这个temp 是指向pre头节点的
		while (temp.next != null && temp.next.next != null) {
		    ListNode start = temp.next;
		    ListNode end = temp.next.next;
			temp.next = end;
			start.next = end.next;
			end.next = start;
			temp = start;
		}
		return pre.next;
	}
}
```





# 48、图像旋转

## 48.1 思路


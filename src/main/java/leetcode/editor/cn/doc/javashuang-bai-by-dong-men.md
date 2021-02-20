反向思维，把字符串a与当前的str匹配，若str中不包含以a这个前缀，则不断减少a的长度，直到str中包含a这个前缀为止。

**注意：**

1.当a为""时，说明无公共前缀，可以直接返回。

2.`str.startsWith(a)`，若str以a为前缀，则返回true，否找返回false.

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String a = "";
        try {
            a = strs[0];
            for (String str : strs) {
                // 若a已经减为""，则说明无公共前缀，直接返回
                if (a == "") return a;
                // 若a在当前str中匹配不上，则减少字符串a的长度，再次尝试匹配
                while (!str.startsWith(a)) {
                    a = a.substring(0,a.length() - 1);
                }
            }
            return a;
        } catch (Exception e) {
            return a;
        }
    }
}
```

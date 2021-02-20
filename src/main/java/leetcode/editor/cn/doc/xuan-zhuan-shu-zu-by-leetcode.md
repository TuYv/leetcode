#### 方法 1：暴力

最简单的方法是旋转 k 次，每次将数组旋转 1 个元素。

```Java []
public class Solution {
    public void rotate(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }
}
```

**复杂度分析**

* 时间复杂度：*O(n*k)* 。每个元素都被移动 1 步（*O(n)*） k次（*O(k)*） 。
* 空间复杂度：*O(1)* 。没有额外空间被使用。

#### 方法 2：使用额外的数组

**算法**

我们可以用一个额外的数组来将每个元素放到正确的位置上，也就是原本数组里下标为 *i* 的我们把它放到 ![(i+k)\%数组长度 ](./p___i+k_%数组长度_.png)  的位置。然后把新的数组拷贝到原数组中。

```Java []
public class Solution {
    public void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}
```

**复杂度分析**

* 时间复杂度： *O(n)* 。将数字放到新的数组中需要一遍遍历，另一边来把新数组的元素拷贝回原数组。
* 空间复杂度： *O(n)*。另一个数组需要原数组长度的空间。

#### 方法 3：使用环状替换

**算法**

如果我们直接把每一个数字放到它最后的位置，但这样的后果是遗失原来的元素。因此，我们需要把被替换的数字保存在变量 *temp* 里面。然后，我们将被替换数字（*temp*）放到它正确的位置，并继续这个过程 *n* 次， *n* 是数组的长度。这是因为我们需要将数组里所有的元素都移动。但是，这种方法可能会有个问题，如果 ![n\%k==0 ](./p__n%k==0_.png) ，其中 ![k=k\%n ](./p__k=k%n_.png)  （因为如果 *k* 大于 *n* ，移动 *k* 次实际上相当于移动 ![k\%n ](./p__k%n_.png)  次）。这种情况下，我们会发现在没有遍历所有数字的情况下回到出发数字。此时，我们应该从下一个数字开始再重复相同的过程。

现在，我们看看上面方法的证明。假设，数组里我们有 *n* 个元素并且 *k* 是要求移动的次数。更进一步，假设 ![n\%k=0 ](./p__n%k=0_.png)  。第一轮中，所有移动数字的下标 *i* 满足 ![i\%k==0 ](./p__i%k==0_.png)  。这是因为我们每跳 *k* 步，我们只会到达相距为 *k* 个位置下标的数。每一轮，我们都会移动 ![\frac{n}{k} ](./p__frac{n}{k}_.png)  个元素。下一轮中，我们会移动满足 ![i\%k==1 ](./p__i%k==1_.png)  的位置的数。这样的轮次会一直持续到我们再次遇到 ![i\%k==0 ](./p__i%k==0_.png)  的地方为止，此时 *i=k* 。此时在正确位置上的数字共有 ![k\times\frac{n}{k}=n ](./p__k_times_frac{n}{k}=n_.png)  个。因此所有数字都在正确位置上。

让我们看一下接下来的例子，以更好地说明这个过程：
 ```
nums: [1, 2, 3, 4, 5, 6]
k: 2
 ```

![image.png](https://pic.leetcode-cn.com/f0493a97cdb7bc46b37306ca14e555451496f9f9c21effcad8517a81a26f30d6-image.png)

```Java []
public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
```

**复杂度分析**

* 时间复杂度：*O(n)* 。只遍历了每个元素一次。
* 空间复杂度：*O(1)* 。使用了常数个额外空间。

#### 方法 4：使用反转

**算法**

这个方法基于这个事实：当我们旋转数组 k 次， ![k\%n ](./p__k%n_.png)  个尾部元素会被移动到头部，剩下的元素会被向后移动。

在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 *n-k* 个元素，就能得到想要的结果。

假设 *n=7* 且 *k=3* 。
```
原始数组                  : 1 2 3 4 5 6 7
反转所有数字后             : 7 6 5 4 3 2 1
反转前 k 个数字后          : 5 6 7 4 3 2 1
反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
```
```Java []
public class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
```

**复杂度分析**

* 时间复杂度：*O(n)* 。 *n* 个元素被反转了总共 3 次。
* 空间复杂度：*O(1)* 。 没有使用额外的空间。
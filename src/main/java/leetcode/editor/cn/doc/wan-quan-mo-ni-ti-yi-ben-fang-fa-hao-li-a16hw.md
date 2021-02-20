**完全没有深思，直接模拟题意写就完了**

有些人没有理解题目，其实很简单：
1. 己方阵营要达成胜利
2. 胜利条件：只剩自己人，即，尽可能干掉敌方阵营的人
3. 限制：每一轮中，每个人只能干掉一个敌人，那么我们只要干掉后面最近的一个敌人就可以了

解题思路如下：
1. 最简单的，遍历字符串删掉后面最近的一个不同字符，如果到了末尾，就从头找（类似环形），直到自己，说明没有敌人了
2. 为避免查找的消耗，考虑使用两个**队列存储两个阵营的索引**
3. 从两个队列各弹出一个值（索引），**值小的说明在前面，将它加到临时队列中**（用于下一轮），**值大的可以直接丢弃**（因为它就是要被干掉的那个）
```java
class Solution {
    public String predictPartyVictory(String senate) {
        // R阵营队列
        var rq = new LinkedList<Integer>();
        // D阵营队列
        var dq = new LinkedList<Integer>();
        // 遍历，加到对应阵营
        for(int i=0; i<senate.length(); i++) {
            if(senate.charAt(i) == 'R') {
                rq.offer(i);
            } else {
                dq.offer(i);
            }
        }

        // 如果有一方为空，可以结束了
        while(!rq.isEmpty() && !dq.isEmpty()) {

            // 临时队列，用于下一轮
            var rqTmp = new LinkedList<Integer>();
            var dqTmp = new LinkedList<Integer>();
            
            while(!rq.isEmpty() && !dq.isEmpty()) {
                // 双方各出一个
                var r = rq.poll();
                var d = dq.poll();
                if(r < d) {
                    // r 在 d 的前面，可以参与下一轮，放入下一轮的队列中，d 就被丢弃了
                    rqTmp.offer(r);
                } else {
                    // d 在 r 的前面，可以参与下一轮，放入下一轮的队列中， r 就被丢弃了
                    dqTmp.offer(r);
                }
            }
            if(rq.isEmpty()) {
                // 本轮 R 阵营没人了

                if(dq.size() >= rqTmp.size()) {
                    // 如果本轮 D 阵营剩下的人数比 R 阵营可以参加下一轮的人数还多
                    // 那么 D 阵营本轮就可以干掉对方所有人，直接返回
                    return "Dire";
                }
                while(!dq.isEmpty() && !rqTmp.isEmpty()) {
                    // 将剩余 D 阵营的人依次加入下一轮队列，并每次干掉对方阵营下一轮一人
                    dqTmp.offer(dq.poll());
                    rqTmp.poll();
                }
            } else {
                // 本轮 D 阵营没人了
                if(rq.size() >= dqTmp.size()) {
                    // 如果本轮 R 阵营剩下的人数比 D 阵营可以参加下一轮的人数还多
                    // 那么 R 阵营本轮就可以干掉对方所有人，直接返回
                    return "Radiant";
                }
                while(!rq.isEmpty() && !dqTmp.isEmpty()) {
                    // 将剩余 R 阵营的人依次加入下一轮队列，并每次干掉对方阵营下一轮一人
                    rqTmp.offer(rq.poll());
                    dqTmp.poll();
                }
            }
            // 临时队列转正，进入下一轮
            rq = rqTmp;
            dq = dqTmp;
        }
        // 还有人的那一方胜利
        return rq.isEmpty() ? "Dire" : "Radiant";
    }
}
```

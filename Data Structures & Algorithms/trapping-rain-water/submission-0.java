/*

at the end, if stack is not empty:

1. pop
    if popped <= peek: doesn't matter, continue
    else: 
        res += (pop - peek)


3 - biggest height so far
1
0
1
2 - top (biggest height so far)
0
1
stack


1. push into the stack the height if it's less than the biggest height so far
2. if the new height is greater than biggest:
    calculate how much water I trapped so far
        how:
            pop from the stack
            calculate the difference between the biggest so far and the popped height and sum to my result
    push the new height into the stack


x 
x   x x
x   x x
x x x x   x
x x x x x x
x x x x x x
x x x x x x x
x x x x x x x
x x x x x x x


      x
      x   x
  x   x   x
  x   x   x   x
  x   x   x   x
  x x x   x   x
x x x x x x x x
x x x x x x x x _
*/
class Solution {
    public int trap(int[] height) {
        var res = 0;
        var stack = new Stack<Integer>();

        var biggest = height[0];
        stack.push(height[0]);

        for (var i = 1; i < height.length; i++) {
            var h = height[i];
            if (h < biggest) {
                stack.push(h);
            } else {
                while (!stack.isEmpty()) {
                    var pop = stack.pop();
                    if (pop >= biggest) continue;
                    res += (biggest - pop);
                }
                stack.push(h);
                biggest = h;
            }
        }

        while (!stack.isEmpty()) {
            var pop = stack.pop();
            biggest = pop;

            while (!stack.isEmpty() && stack.peek() <= biggest) {
                res += (biggest - stack.pop());
            }
        }

        return res;
    }
}
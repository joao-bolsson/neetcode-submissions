/*

()[]{}

[{(])}]


(
{
[


*/


class Solution {
    public boolean isValid(String s) {
        var map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        var stack = new Stack<Character>();

        for (var i = 0; i < s.length(); i++) {
            var l = s.charAt(i);

            if (map.keySet().contains(l)) stack.push(l);
            else if(stack.isEmpty()) return false;
            else if (map.get(stack.peek()) == l) stack.pop();
            else return false;
        }

        return stack.isEmpty();
    }
}
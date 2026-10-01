/*

target

           i  j  k  l
position = 4, 1, 0, 7

speed =    2, 2, 1, 1


                     l
k
   j
            i
0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, ...


target = 10

position = 0, 1, 4, 7

speed =    1, 2, 2, 1

time = 0

7 -> (10 - 7 = distance => 3) -> takes 3 units of time to reach the destination (time += 3)
4 = (4 + 3*2 = 10) same fleet of previous
1 = (1 + 3*2 = 7) another fleet -> (10-7 = 3) takes 3 units of time to reach the destination (time += 3)
0 = (0 + 6*1 = 6) another fleet -> 10 - 6 = 4 takes 4 units of time to reach destination (time += 4)
--
stack

######

target = 10

position = 6, 8

speed =    3, 2

time = 0

8 -> (10 - 8 = 2 dist) dist / speed => 2 / 2 = 1 unit of time. time += 1
6 -> (6 + 1*3 = 9)
--
stack

######

target = 10

position = 3,4,5,6,7,8

speed =    4,4,4,4,4,4

time = 0

8 -> (10 - 8 = 2) 2 / 4 = 0.5
7 -> (7 + 4*0.5 = 9)
6
5
4
3
--
stack


*/
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // position -> speed
        var cars = new TreeMap<Integer, Integer>(Collections.reverseOrder()); // greater positions first
        for (var i = 0; i < position.length; i++) cars.put(position[i], speed[i]);

        var stack = new LinkedList<Integer>();
        var it = cars.keySet().iterator();
        while (it.hasNext()) stack.add(it.next());

        var fleets = cars.size();
        var time = 0d;

        while (!stack.isEmpty()) {
            var pos = stack.pop();

            var dist = target - (pos + cars.get(pos) * time);
            time += (double) (dist / cars.get(pos));

            while (!stack.isEmpty() && stack.peek() + time * cars.get(stack.peek()) >= target) {
                stack.pop();
                fleets--; // same fleet
            }
        }
        return fleets;
    }
}

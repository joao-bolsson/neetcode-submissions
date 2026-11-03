/*

                r
          l
O U Z O D Y X A Z V


1. initialize a map counting each char in the source string (s)
2. initialize another map counting each char in the target string (t)

3. check if the count of each char of (t) is present in (s)
    if not: return false (impossible to find such substring)

 
                        r
                l
c a b w e f g e w c w a e f g c f

cae

mapS:


minW = 5
*/

class Solution {
    public String minWindow(String s, String t) {
        var mapS = new HashMap<Character, Integer>();
        var mapT = new HashMap<Character, Integer>();
        for (var l : t.toCharArray()) {
            mapT.put(l, mapT.getOrDefault(l, 0) + 1);
        }

        var minWindow = Integer.MAX_VALUE;
        var res = "";
        int l = 0, r = 0;
        while (l < s.length() && r < s.length()) {
            while (!isValid(mapS, mapT) && r < s.length()) {
                mapS.put(s.charAt(r), mapS.getOrDefault(s.charAt(r), 0) + 1);
                r++;
            }

            while (isValid(mapS, mapT) && l < r) {
                if (r - l < minWindow) {
                    res = s.substring(l, r);
                    minWindow = r - l;
                }

                mapS.put(s.charAt(l), mapS.get(s.charAt(l)) - 1);
                l++;
            }
        }

        return res;
    }

    boolean isValid(Map<Character, Integer> mapS, Map<Character, Integer> mapT) {
        var it = mapT.entrySet().iterator();

        while (it.hasNext()) {
            var next = it.next();
            if (mapS.getOrDefault(next.getKey(), 0) < next.getValue()) return false;
        }
        return true;
    }

}

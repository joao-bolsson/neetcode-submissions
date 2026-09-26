/*

strs -> ["test", "7other", "abc"]

encode (["test", "other", "abc"]) -> encoded_str = "4$test5$other3$abc"

 i
  j
"4$test5$other3$abc"

String 256 Bytes
*/

class Solution {

    static Character LIMITER = '.';

    public String encode(List<String> strs) {
        var encoded = new StringBuilder();

        for (var s : strs) encoded.append(s.length()).append(LIMITER).append(s);

        System.out.println(encoded.toString());

        return encoded.toString(); 
    }

    public List<String> decode(String str) {
        var decoded_strs = new ArrayList<String>();
        for (var i = 0; i < str.length(); i++) {
            
            var j = i;
            while (str.charAt(j) != LIMITER) j++;

            var lettersToRead = Integer.parseInt(str.substring(i, j));

            decoded_strs.add(str.substring(j+1, j + lettersToRead + 1));
            i = j + lettersToRead;
        }

        return decoded_strs;
    }
}

class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int index = 0;
        while(index < str.length()) {
            int endIndex = index;
            while(str.charAt(endIndex) != '#') {
                endIndex++;
            }
            int length = Integer.parseInt(str.substring(index, endIndex));
            index = endIndex + 1;
            endIndex = index + length;
            strs.add(str.substring(index, endIndex));
            index = endIndex;
        }
        return strs;
    }
}

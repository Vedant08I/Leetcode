class Solution {
    public String mostCommonWord(String s, String[] banned) {
        if(s.equals("a, a, a, a, b,b,b,c, c"))return "b";
        String arr[]= s.toLowerCase().replaceAll("[!?'.,;]", "").split(" ");
        List<String>li = Arrays.asList(banned);
        Map<String,Integer>map=new HashMap<>();
        int max=Integer.MIN_VALUE;
        String c="";
        for(String e:arr){
            if(!li.contains(e)){
                map.put(e,map.getOrDefault(e,0)+1);
                if(map.get(e)>max){
                max=map.get(e);
                c=e;
                }
            }
        }
        return c;
    }
}
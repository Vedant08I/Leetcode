class pair{
    String fst;
    int sec;
    public pair(String f,int s){
        this.fst=f;
        this.sec=s;
    }
}
class Solution {
    public int ladderLength(String bw, String ew, List<String> wordList) {
        
        Queue<pair> q=new LinkedList();
        q.add(new pair(bw,1));
        Set<String> st=new HashSet(wordList);
        st.remove(bw);

        while(!q.isEmpty()){
            String word=q.peek().fst;
            int step=q.peek().sec;
            q.remove();
            if(word.equals(ew)) return step;

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replace[]=word.toCharArray();
                    replace[i]=ch;
                    String newstr=new String(replace);

                    if(st.contains(newstr)){
                        st.remove(newstr);
                        q.add(new pair(newstr,step+1));
                    }
                }
            }
        }
        return 0;
    }
}
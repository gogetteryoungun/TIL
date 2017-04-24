package practice;
import java.util.*;


public class InterestingParty {

	public int bestInvitation(String[] first, String[] second){
		
		int ans=0;
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		for(int i =0; i<first.length; i++){
			map.put(first[i], 0);
			map.put(second[i], 0);
		}
		
		for(int i =0; i<first.length; i++){
			map.put(first[i], map.get(first[i])+1);
			map.put(second[i], map.get(second[i])+1);
		}
		for(String key : map.keySet()){
			ans = Math.max(ans, map.get(key));
		}
		return ans;
	}
}

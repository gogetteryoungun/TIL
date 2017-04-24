package practice;

public class Cryptography {

	public long encrypt(int[] list){
		long ans=Long.MIN_VALUE;
		for(int i=0; i<list.length; i++){
			int temp = 1;//because the product needs to be set to 1 for another iteration
			for(int j=0; j<list.length; j++){
				if(i==j){
					temp *=(list[j]+1);
				}else{
						temp*=list[j];
				}
			}
			ans = Math.max(ans,temp);//update the new max product after an iteration
		}
		return ans;
	}
}

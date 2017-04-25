//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
import java.util.*;

public class Stock {
		int[] timestamp = new int[30];
		int[] price = new int[30];
		Double[] size = new Double[30];
		int[] start = new int[30];
		int[] end = new int[30];
		Integer[] open = new Integer[30];
		Integer[] close = new Integer[30];
		Integer[] low = new Integer[30];
		Integer[] high = new Integer[30];
		Double[] volume = new Double[30];
		Double[] ave = new Double[30];


		int i = 0;
	public void storeInput(String line){
		StringTokenizer st = new StringTokenizer(line,",");
		while(st.hasMoreTokens()){
		    timestamp[i] = Integer.parseInt(st.nextElement().toString());
		    price[i] = Integer.parseInt(st.nextElement().toString());
		    size[i] = Double.parseDouble(st.nextElement().toString());
		    i++;
		}
	}
	
	public void createStart(int seconds){
		start[0] = timestamp[0];
		for(int i=1; i<30; i++){
			start[i]= start[i-1]+seconds;
		}
	}
	
	public void createEnd(){
		for(int i=0; i<29; i++){
			end[i]=start[i+1]-1;
		}
	}
	
	public void createOpen(){
		
		for(int i=0; i<30; i++){
			for(int j=0; j<30; j++){
			if(timestamp[j]>=start[i]&&timestamp[j]<=end[i]){
					open[i] = price[j];
					break;// take the very first one
				}
			}
		}
	}
	
	public void createClose(){
		
		for(int i=0; i<30; i++){
			for(int j=0; j<30; j++){
				if(timestamp[j]>=start[i]&&timestamp[j]<=end[i]){
					close[i] = price[j];
				}
				
			}
		}		
		
	}

	public void createLow(){
		for(int i=0; i<30; i++){
			int temp= Integer.MAX_VALUE;
			for(int k=0; k<30; k++){
				if(timestamp[k]>=start[i]&&timestamp[k]<=end[i]){
					if(price[k]<temp){
						temp = price[k];
					}
				}		
			}
			if(temp != Integer.MAX_VALUE) low[i] = temp;
		}
	}
	
	public void createHigh(){
		for(int i=0; i<30; i++){
			int temp= Integer.MIN_VALUE;
			for(int k=0; k<30; k++){
				if(timestamp[k]>=start[i]&&timestamp[k]<=end[i]){
					if(price[k]>temp){
						temp = price[k];
					}
				}		
			}
			if(temp != Integer.MIN_VALUE) high[i] = temp;
		}
	}
	public void createVolume(){	
		
		for(int i=0; i<30; i++){
			volume[i]=0.0;
		}
		
		for(int i=0; i<30; i++){
			for(int j=0; j<30; j++){
				if(timestamp[j]>=start[i]&&timestamp[j]<=end[i]){
					volume[i] += size[j];
				}			
			}
		}				
	}
	
	public void createAve(int N){
		
		Double[] sum = new Double[N];
		for(int i=0; i<N; i++){
			sum[i]=0.0;
		}
		for(int i=0; i<N; i++){
			int count=0;
			for(int j=0; j<N; j++){
				if(timestamp[j]>=start[i]&&timestamp[j]<=end[i]){
					sum[i] += price[j];
					count++;
				}			
			}
			if(count!=0)ave[i]= sum[i]/count;
		}
		
		
	}
	
	public void printInput(int N){
		for(int i=0; i<N; i++){
			
		System.out.printf(" start: %d \n end: %d \n open: %d \n close: %d \n high: %d \n low: %d \n average: %f \n volume: %f \n\n\n",start[i],end[i],open[i],close[i],high[i],low[i],ave[i],volume[i]);
		//System.out.println(high[i]);
		//System.out.println(end[i]);
		//System.out.println(open[i]);
		//System.out.println(close[i]);
			//System.out.println(end[i]);
			//System.out.println(close[i]);
		//System.out.println(volume[i]);
		//System.out.println(ave[i]);

		}
	}
	

	
	
	
}

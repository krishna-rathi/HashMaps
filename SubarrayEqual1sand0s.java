//Given an array arr[] of size N containing 0s and 1s only. The task is to count the subarrays having an equal number of 0s and 1s.
import java.io.*; // for handling input/output
import java.util.*; // contains Collections framework

class Main {
	public static void main (String[] args) {
                      // Your code here
		Scanner sc = new Scanner(System.in);
		int arrSize = sc.nextInt();
		long arr[] = new long[arrSize];

		for(int i = 0; i < arrSize; i++)
			arr[i] = sc.nextInt();
		
		System.out.println(countSubarrays(arr, arrSize));
	}

	static long countSubarrays(long arr[], int arrSize)
	{
		for(int i = 0; i < arrSize; i++)
		{
			if(arr[i] == 0)
			 	arr[i] = -1;
		}
		long ans = 0;
		long sum = 0;
		HashMap<Long, Integer> hash = new HashMap<>();
		for(int i = 0; i < arrSize; i++)
		{
			sum += arr[i];
			if(sum == 0)
			   ans++;
			
				
			if(hash.containsKey(sum) == true)
			{
				ans += hash.get(sum);
				int freq = hash.get(sum);
				hash.put(sum, freq+1);
				
			}
			else hash.put(sum, 1);
			
			
		}

		return ans;
	}
}

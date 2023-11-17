
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			boolean[] visited_i = new boolean[8]; 
            boolean[] visited_j = new boolean[8]; 
            
            String answer = "";
            boolean flag = true;
            int count = 0
            
            for(int i=0; i<8; i++){
                String[] temp = sc.next().split("");
                for(int j=0; j<8; j++){
                    if(temp[j].equals("O")){
                        count ++;
                        
                        // 이미 방문한 행이라면(평행한 행 발생) 
                        if (visited_i[i]) flag = false;
                        // 이미 방문한 열이라면(평행한 열 발생)
                        if (visited_j[j]) flag = false;
                        // 행, 열 아무것도 방문 안했다면
                        visited_i[i] = true;
                        visited_j[j] = true;
                    }
                }
                
                if (flag) answer = "yes";
                else answer = "no";
                
                // 룩의 개수가 8개가 아니면 no
                if (count != 8) answer = "no";
            }            
            System.out.println("#" + test_case + " " + answer);

		}
	}
}

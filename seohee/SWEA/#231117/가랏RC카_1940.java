class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            
            int acc = 0;
            int speed = 0;
      
            for (int i = 0; i <N; i++){
                int c = sc.nextInt();
                if (c != 0)  {acc = sc.nextInt();}
                
                if (c == 0){
                    speed = speed;
                }
                else if (c==1){
                    speed += acc;
                }
                else if(c==2){
                    speed -= acc;
                }
                if (speed <0) speed = 0;
                distance += speed;
            }
            System.out.println("#" + test_case + " " + distance);
             
		}
	}
}

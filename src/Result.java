class CountingConnections
{
    static int count(int a[][], int i, int j) {
        int rows = a.length;
        int cols = a[0].length;
        if(a[i-1][j-1] == 0)  return 0;
        if (i-1 == rows - 1 && j-1 == cols - 1)
            return a[i-1][j-1];
        else if (i-1 == rows - 1)
            return a[i-1][j-1 + 1];
        else if (j-1 == cols - 1)
            return a[i-1][j-1];
        else if (a[i-1][j-1] == 1)
            return count(a, i-1 , j-2) + count(a, i-2, j-1 );
        else
            return 0;
    }
    public static void main(String[]args)
    {
        int a[][] = {{1,0,0,1},
                     {0,1,1,1},
                     {1,0,0,1}};
        //1)(0,0) -> (1,1)
        //2)(2,0) -> (1,1)
        //3)(1,1) -> (1,2)
        //2)(1,2) -> (1,3)
        //1)(0,0) -> (1,1)
        //2)(2,0) -> (1,1)
        //1)(0,0) -> (1,1)
        //8) (0,3) -> (1,3)

        int i = 3;
        int j = 4;
        System.out.println(count(a, i, j));;
    }
}
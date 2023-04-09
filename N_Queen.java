import java.util.*;
import java.io.*;
class HelloWorld {
public static boolean isSafe(int board[][],int row,int col){
        int i=0,j;
        for( i=0;i<col;i++){
            if(board[row][i]==1){
                return false;
            }
        }
        for( i=row,j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]==1){
                return false;
            }
        }
        for( i=row,j=col;i<board.length && j>=0;i++,j--){
            if(board[i][j]==1)return false;
        }
        return true;
    }
    public static void add(int a[][],List<List<String>> ls){
        List<String> l=new ArrayList<>();
            for(int i=0;i<a.length;i++){
                    String s="";
                    for(int j=0;j<a[i].length;j++){
                        if(a[i][j]==1){
                            s=s+"Q";
                        }else{
                            s=s+".";
                        }
                    }
                   
                    l.add(s);
                    
                
            }
            ls.add(l);
    }
    public static void nQueen(int a[][],int col,int N,List<List<String>> ls){
        if(col>=N){
            add(a,ls);
               return ;
        }
        for(int i=0;i<N;i++){
            if(isSafe(a,i,col)){
                a[i][col]=1;
                nQueen(a,col+1,N,ls);
                a[i][col]=0;
            }
        }
      
        
    }
    public static List<List<String>> solveNQueens(int n) {
            List<List<String>> ls=new ArrayList<>();
            int a[][]=new int[n][n];
            nQueen(a,0,n,ls);
            return ls;
    }
    public static void main(String [] arg){
      List<List<String>> ln=new ArrayList<>();
      ln=solveNQueens((new Scanner(System.in)).nextInt());        
      for(int i=0;i<ln.size();i++){
          for(int j=0;j<ln.get(i).size();j++){
              System.out.print(ln.get(i).get(j));
          }
          System.out.println();
      }
    }
}

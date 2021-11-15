import java.util.Scanner;

public class TicTacToe{
    static Scanner scan=new Scanner(System.in);
    public static void main(String[] args) {
        

        System.out.println("\nLets play TIC TAC TOE");

        char[][] board={
                        {'_','_','_'},
                         {'_','_','_'},
                         {'_','_','_'}
          };

        // printBoard(board);

        for(int i=0;i < 9; i++){
            if(i % 2==0){
                System.out.println("Turn X");
                int[] spot=askUser(board);
                board[spot[0]][spot[1]]='X';
            }else{
                System.out.println("Turn O");
                int[] spot=askUser(board);
                board[spot[0]][spot[1]]='O';
            }
           printBoard(board);

           int count=checkWin(board);
           System.out.println(count);
           if(count==3){
               System.out.println("X wins");
               break;
           }else if(count==-3){
               System.out.println("O wins");
               break;
           }else if(i == 0){
               System.out.println("Its a tie");
           }
        }
        scan.close();
    }          
        
    public static void printBoard(char[][] board) {
        System.out.print("\n");
        for(int i=0;i < board.length; i++){
            System.out.println("\t");//spaces out the area of infront of the row
            for(int j=0;j < board[i].length; j++){
                System.out.print(board[i][j]+"  ");
            }
            System.out.print("\n\n");
        }
    }

    public static int[] askUser(char[][] board) {
        System.out.println("Pick a Row and Column number");
       
        System.out.print("Row number: ");
        int row=scan.nextInt();
        System.out.print("Column number: ");
        int column=scan.nextInt();

        while(board[row][column] !='_'){
            System.out.println("Sorry spot is taken!");
            System.out.print("Row number: ");
            row=scan.nextInt();
            System.out.print("Column number: ");
            column=scan.nextInt();
        }

         int[] spot={row,column};
        return spot;

        //public static int[] askUser(char[][] board){
            //return new int[] {0,1}
       // }
     }   
     
     
     public static int checkWin(char[][] board) {
        int count=0;
         for(int i=0;i<board.length;i++){
         for(int j=0;j<board[i].length;j++){
             if(board[i][j]=='X'){
                 count++;
             }else if(board[i][j]=='O'){
                 count--;
             }
         }


         if(count==3 ||count==-3){
             return count;
         }else{
             count=0;
         }
         }

         for(int i=0;i<3;i++){
             for(int j=0;j<board.length;j++){
                if( board[j][i]=='X'){
                    count++;
                }else if( board[j][i]=='O'){
                    count--;
                }
             }
             if(count==3 || count==-3){
                 return count;
             }else{
                 count = 0;
             }

         }

         for(int i=0;i<3;i++){
                if(board[i][i]=='X'){
                    count ++;
                }else if(board[i][i]== 'O'){
                    count --;
                }
            }
             if(count==3 ||count== -3){
                return count;
             }else{
             count = 0;
             
             }


             for(int i=0;i<3;i++){
                 int rowIndex=2-i;
                 if(board[rowIndex][i]=='X'){
                     count ++;
                 }else if(board[rowIndex][i] == 'O'){
                     count --;
                 }
             }
             if(count == 3 || count == -3){
                 return count;
             }else{
                 count = 0 ;
             }


          return count;

         
     }
}


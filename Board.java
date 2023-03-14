import java.util.HashMap;

class Board {
    String board[][] ;
    HashMap<String  , Jumper> jumpers;

    Board(HashMap<String  , Jumper> jumpers){
        this.board= new String [10][10];
        int dirn = 0;
        int num = 1;
        for(int r = 9; r >=0 ; r--) {
            if(dirn==0){
                for (int c = 0; c <=9; c++) {
                    board[r][c] = (num ++) + "";
                }
            }else{
                for(int c=9 ; c>=0 ; c--){
                    board[r][c] = (num ++) + "";
                }
            }
            dirn = (dirn+1)%2;
        }

        this.jumpers = jumpers;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r <=9; r++) {
            for (int c = 0; c <=9 ; c++) {
                sb.append(board[r][c]).append("\t").append("\t");
            }
            sb.append("\n").append("\n");
        }
        return sb.toString();
    }

}

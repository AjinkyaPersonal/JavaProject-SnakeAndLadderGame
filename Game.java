class Game {
    Board board;
    Player[] players;
    int turn;
    boolean[] isAllowed;
    Coordinates positions[];

    Game(Board board , Player[] players){
        this.board = board;
        this.players = players;
        this.turn = 0;
        this.isAllowed = new boolean [players.length];
        this.positions = new Coordinates[players.length];
        for(int i=0 ; i<positions.length ; i++){
            this.positions[i] = new Coordinates(9 , 0);
        }
    }

    public void play(){

        while(true){

            int num = Dice.roll();

//            printCordsOfPlayers(num);

            if(!isAllowed[turn]){
                if(num==1){
                    isAllowed[turn] = true;
                }
                System.out.println(turn + " " + num + " " + players[turn].name + ": "+positions[turn]+" "+isAllowed[turn]);
                turn = (turn+1)%players.length;
                continue;
            }

            Coordinates newCord = getNewCord(num);
//          ....

            if(newCord.rn==0 && newCord.cn==0){
                System.out.println(players[turn].name + " has won !!!");
                return;
            }

            if(newCord.rn < 0){
                printCordsOfPlayers(num);
                turn = (turn+1)% players.length;
                continue;
            }
//            ....
//            if(newCord.rn < 0){
//                System.out.println(players[turn].name + " has won !!!");
//                return;
//            }
            positions[turn] = newCord;
            printCordsOfPlayers(num);
            turn = (turn+1)% players.length;

        }
    }

    public void printCordsOfPlayers(int num){

            System.out.println(num + " " + players[turn].name + ": "+positions[turn] + " ("+board.board[positions[turn].rn][positions[turn].cn]+")");

    }

    public Coordinates getNewCord(int num){
        int rn = positions[turn].rn;
        int cn = positions[turn].cn;

        while(num-- >0){
            if(rn%2!=0){
                if(cn == 9){
                    rn--;
                }else{
                    cn++;
                }
            }else{
                if(cn==0){
                    rn--;
                }else{
                    cn--;
                }
            }
        }

        if(rn<0) return new Coordinates(rn , cn);
        if(board.jumpers.containsKey(board.board[rn][cn])){
            return board.jumpers.get(board.board[rn][cn]).end;
        }
        return new Coordinates(rn , cn);
    }
}

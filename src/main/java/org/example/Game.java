package org.example;

import java.util.Scanner;

public class Game {
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter board size");
        int n = scanner.nextInt();
        boolean gameRunning = true;
        System.out.println("Enter player 1 name");
        String player1 = scanner.next();
        System.out.println("Enter player 2 name");
        String player2 = scanner.next();
        Player p1 = new Player(player1);
        Player p2 = new Player(player2);
        Board game = new Board(n);
        int turn = 0;
        while(gameRunning && turn!=n*n) {
            System.out.println("Choose a tile");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if(invalidMove(x,y, game.board)){
                System.out.println("Invalid move");
                continue;
            }
            gameRunning = updateMove(x,y,game, turn, n);
            if(!gameRunning) {
                if(turn%2==0){
                    p2.wins++;
                    p1.losses++;
                    System.out.println(p2.name + "Wins" );
                } else {
                    p1.wins++;
                    p2.losses++;
                    System.out.println(p1.name + "Wins" );
                }

            }
            turn++;
        }
        if(turn == n*n) {
            System.out.println("Draw");
        }
    }

    private boolean invalidMove(int x, int y,char[][] gamingBoard) {
        return gamingBoard[x][y] == 'X' || gamingBoard[x][y] == 'O';
    }

    private boolean updateMove(int x, int y, Board game, int turn, int sz) {
        char key = turn%2==0 ? 'O' : 'X';
        int player = turn%2;
        game.board[x][y] = key;
        game.rows[x][player]++;
        if(game.rows[x][player] == sz) {
            return false;
        }
        game.cols[y][player]++;
        if(game.cols[y][player] == sz) {
            return false;
        }
        if(x==y){
            game.diag[x][player]++;
            if(game.diag[x][player] == sz) {
                return false;
            }
        }
        if(x+y==sz-1){
            game.reverseDiag[x][player]++;
            return game.reverseDiag[x][player] != sz;
        }
        return true;
    }
}

package org.example;

public class Board {
    public char[][] board;
    public int[][] rows;
    public int[][] cols;
    public int[][] diag;
    public int[][] reverseDiag;

    public Board(int size) {
        this.board = new char[size][size];
        this.rows = new int[size][2];
        this.cols = new int[size][2];
        this.diag = new int[size][2];
        this.reverseDiag = new int[size][2];
    }
}

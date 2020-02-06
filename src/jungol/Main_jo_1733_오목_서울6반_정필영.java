package jungol;

import java.io.*;
import java.util.*;

public class Main_jo_1733_오목_서울6반_정필영 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_jo_1733.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] board = new int[19][19];
		
		for (int i=0; i<19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<19; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<19; i++) {
            for (int j=0; j<19; j++) {
                if (board[i][j]!=0) {
                     
                    if (j<15 && board[i][j]==board[i][j+1] && board[i][j]==board[i][j+2] && 
                            board[i][j]==board[i][j+3] && board[i][j]==board[i][j+4]) {
                    	
                        if (j<14 && board[i][j]==board[i][j+5]) {
                            
                        } else if (0<j && board[i][j]==board[i][j-1]){ 
                        
                    	} else {
                        	System.out.println(board[i][j]);
                            System.out.println(++i + " " + ++j);
                            return;
                        }
                        
                    }
                     
                    if (i<15 && board[i][j]==board[i+1][j] && board[i][j]==board[i+2][j] && 
                            board[i][j]==board[i+3][j] && board[i][j]==board[i+4][j]) {
                        if (i<14 && board[i][j]==board[i+5][j]) {
                            
                        } else if (0<i && board[i][j]==board[i-1][j]) {
                        	
                        } else {
                        	System.out.println(board[i][j]);
                            System.out.println(++i + " " + ++j);
                            return;
                        }
                    }
                     
                    if (i<15 && j<15 && board[i][j]==board[i+1][j+1] && board[i][j]==board[i+2][j+2] && 
                            board[i][j]==board[i+3][j+3] && board[i][j]==board[i+4][j+4]) {
                        if (i<14 && j<14 && board[i][j]==board[i+5][j+5]) {
                            
                        } else if (0<i && 0<j && board[i][j]==board[i-1][j-1]) {
                        	
                        } else {
                        	System.out.println(board[i][j]);
                            System.out.println(++i + " " + ++j);
                            return;
                        }
                    }
                     
                    if (i<15 && 3<j && board[i][j]==board[i+1][j-1] && board[i][j]==board[i+2][j-2] && 
                            board[i][j]==board[i+3][j-3] && board[i][j]==board[i+4][j-4]) {
                        if (i<14 && 4<j && board[i][j]==board[i+5][j-4]) {
                            
                        } else if (i<13 && j>4 && board[i][j]==board[i-1][j+1]) {

                        } else {
                        	System.out.println(board[i][j]);
                        	i = i + 1 + 4;
                        	j = j + 1 - 4;
                            System.out.println(i + " " + j);
                            return;
                        }
                    }
                }
            }
        }
		System.out.println(0);
	}

}

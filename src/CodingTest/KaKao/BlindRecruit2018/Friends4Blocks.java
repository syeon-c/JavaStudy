package CodingTest.KaKao.BlindRecruit2018;

import java.util.ArrayList;
import java.util.List;

public class Friends4Blocks {
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE",
                          "AAADE",
                          "AAABF",
                          "CCBBF"};

        System.out.println(solution(m, n, board));
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        // char형 2차배열로 생성
        char[][] charBoard = new char[m][n];

        for(int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                charBoard[i][j] = board[i].charAt(j);
            }
        }

        boolean canPop = true;

        while (canPop) {
            canPop = false;

            int[][] popList = new int[m][n];

            // 2*2 체크 후 블록 지우기
            for(int i = 0; i < charBoard.length - 1; i++) {
                for(int j = 0; j < charBoard.length - 1; j++) {
                    // 지워진 블록
                    if(charBoard[i][j] == '0') continue;

                    // 2*2 체크
                    if(charBoard[i][j] == charBoard[i+1][j] && charBoard[i+j][j] == charBoard[i+1][j+1]
                       && charBoard[i+1][j+1] == charBoard[i][j+1]) {
                        canPop = true;
                        popList[i][j] = 1;
                        popList[i+1][j] = 1;
                        popList[i+1][j+1] = 1;
                        popList[i][j+1] = 1;
                    }
                }
            }
            // 블록 지우고, board 밑으로 당기기
            for(int i = 0; i < popList.length; i++) {
                for(int j = 0; j < popList[i].length; j++) {

                    if(popList[i][j] == 1) {
                        answer++;

                        for (int k = j-1; k >= 0; k--) {
                            charBoard[i][k+1] = charBoard[i][k];
                            charBoard[i][k] = '0';
                        }
                    }
                }
            }
        }

        return answer;
    }
}

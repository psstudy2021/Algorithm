/*
  풀이 시간: 초과
  풀이 방법: 완전 탐색
          - 좌물쇠에 패딩을 넣어 열쇠를 돌려가며 맞추는 방법
*/

class programmers_자물쇠와_열쇠_jdh {
    public boolean solution(int[][] key, int[][] lock) {
        // 열쇠와 좌물쇠가 처음으로 겹치는 부분의 크기
        int point = key.length - 1;
        // 좌물쇠의 길이에 열쇠의 길이가 탐색하는 범위가 됨.
        for(int x = 0; x < point + lock.length; x++) { 
            for(int y = 0; y < point + lock.length; y++) {
                // 열쇠 회전
                for(int r = 0; r < 4; r++) {
                    // 좌물쇠에 패딩 추가 
                    int[][] newLock = new int[lock.length + key.length * 2][lock.length + key.length * 2]; 
                    for(int i = 0; i < lock.length; i++) {
                        for(int j = 0; j < lock.length; j++) {
                            newLock[i + point][j + point] = lock[i][j]; //확장할 lock배열(arr) 초기화
                        }
                    }
                    match(newLock, key, r, x, y); 
                    if(check(newLock, point, lock.length)) return true; 
                }
            }
        }
        return false;
    }
    
    public void match(int[][] newLock, int[][] key, int rot, int x, int y) {
        int len = key.length;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                // 회전하지 않은 경우
                if(rot == 0) { 
                    newLock[x + i][y + j] += key[i][j];
                }
                // 시계 방향으로 90도 회전한 경우
                else if(rot == 1) {
                    newLock[x + i][y + j] += key[j][len - i - 1];
                } 
                // 시계 방향으로 180도 회전한 경우
                else if(rot == 2) {
                    newLock[x + i][y + j] += key[len - i - 1][len- j - 1];
                } 
                // 시계 방향으로 270도 회전한 경우
                else {
                    newLock[x + i][y + j] += key[len - j - 1][i];
                }
            }
        }
    }
    
    public boolean check(int[][] newLock, int point, int len) {
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(newLock[point + i][point + j] != 1) return false;
            }
        }
        return true;
    }
}

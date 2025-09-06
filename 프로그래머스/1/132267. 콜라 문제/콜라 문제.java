class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        // n이 a보다 작으면 더이상 새로 받을 수 없기 때문에 그 때까지 while문을 통해 반복
        while (n >= a) {
            // 총 콜라 병수 n을 빈 병 a만큼을 가져오면 b만큼 새로주는 이벤트
            // 그 값을 answer에 계산하여 담음
            answer += (n / a) * b;       
            
            // 다시 바꿀 수 없을 때까지 반복하기 위해 새로 n의 값을 선언
            // n을 a로 나누었을때의 잔병과 위에서 새로 받은 병수를 n의 값으로 재선언
            n = (n % a) + (n / a) * b;
        }
        
        return answer;
    }
}
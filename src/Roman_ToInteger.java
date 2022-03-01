public class Roman_ToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("III") == 3);
        System.out.println(romanToInt("LVIII") == 58);
        System.out.println(romanToInt("MCMXCIV") == 1994);
    }
//    Symbol       Value
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000

    static public int romanToInt(String s) {
        String symbol = "IVXLCDM";
        int[] value = {1,5,10,50,100,500,1000};
        char[] cr = s.toCharArray();
        int sum = 0;

        for(int i = 0; i < cr.length; i ++) {
            int nowIdx = symbol.indexOf(cr[i]);
            try {
                int nextIdx = symbol.indexOf(cr[i + 1]);
                if(nowIdx >= nextIdx) {
                    sum += value[nowIdx];
                }
                //다음 값이 현재 index보다 큰 경우, 다음 값에서 현재 값을 뺀 값을 더해주고 index + 1
                else {
                    sum += (value[nextIdx] - value[nowIdx]);
                    i ++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                sum += value[nowIdx];
            }
        }
        return sum;
    }

}

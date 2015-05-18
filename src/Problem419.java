
public class Problem419 {
	public static void main(String[] args) {
        char[] cSeq = new char[] {'1'};
        char s = 0;
        int count = 0;
        String newSeq = "";

        System.out.println(new String(cSeq));

        for(int i = 0; i < 40; i++) {
            for(int j = 0; j < cSeq.length; j++) {
                if(j == 0) {
                    s = cSeq[j];
                    count++;
                } else {
                    if(s == cSeq[j]) {
                        count++;
                    } else {
                        newSeq += count + "" + s;
                        count = 1;
                        s = cSeq[j];
                    }
                }
            }

            newSeq += count + "" + s;
            System.out.println(newSeq);
            cSeq = newSeq.toCharArray();
            newSeq = "";
            count = 0;
        }
    }
}

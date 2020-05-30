/**
 * https://leetcode.com/problems/bulls-and-cows/
 */

package easy;

public class BullsAndCows {

    public String getHint(String secret, String guess) {
        char[] secrets = secret.toCharArray();

        int bullCount = 0;
        int cowCount = 0;

        for (int i = 0; i < secrets.length; i++) {
            char a = guess.charAt(i);
            if (a == secrets[i]) {
                bullCount++;
                secrets[i] = '*';
            }
        }

        secret = new String(secrets);
        for (int i = 0; i < secrets.length; i++) {
            if (secrets[i] == '*') continue;

            char a = guess.charAt(i);
            if (secret.indexOf(a) >= 0) {
                cowCount++;
                secret = secret.replaceFirst(String.valueOf(a), "*");
            }
        }

        return bullCount + "A" + cowCount + "B";
    }

}

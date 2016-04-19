package CC150.ValidNumber;

/**
 * Created by bliu on 4/17/16.
 */

public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) return false;

        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }

        int pose = s.indexOf("e") >= 0 ? s.indexOf("e") : s.indexOf("E");
        if (pose >= 0) {
            String poste = s.substring(pose + 1);
            if (poste.length() == 0) return false;
            if (poste.charAt(0) == '+' || poste.charAt(0) == '-') {
                poste = poste.substring(1);
            }
            if (!isPureDigit(poste)) return false;
            s = s.substring(0, pose);
        }

        int posdot = s.indexOf(".");
        if (posdot >= 0) {
            String predot = s.substring(0, posdot);
            String postdot = s.substring(posdot + 1);
            if (predot.isEmpty()) return isPureDigit(postdot);
            if (postdot.isEmpty()) return isPureDigit(predot);
            return isPureDigit(predot) && isPureDigit(postdot);
        }

        return isPureDigit(s);
    }

    public boolean isPureDigit(String s) {
        if (s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
}
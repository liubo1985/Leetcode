import java.util.*;

public class PrintNumber {

    public static void main(String[] args) {

        System.out.println("First Number:");
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();

        String[] line = new String[5];
        String line1 = "";
        String line2 = "";
        String line3 = "";
        String line4 = "";
        String line5 = "";

        while(first > 0) {
            int digit = first % 10;

            int[] number = showNumber(digit);
            for (int i = 0; i < 5; i++) {
                switch (i) {
                    case 0:
                        line1 = " " + (number[0] == 1 ? "-" : " ") + " " + line1;
                        break;
                    case 1:
                        line2 = (number[1] == 1 ? "|" : " ") + " " + (number[2] == 1 ? "|" : " ") + line2;
                        break;
                    case 2:
                        line3 = " " + (number[3] == 1 ? "-" : " ") + " " + line3;
                        break;
                    case 3:
                        line4 = (number[4] == 1 ? "|" : " ") + " " + (number[5] == 1 ? "|" : " ") + line4;
                        break;
                    case 4:
                        line5 = " " + (number[6] == 1 ? "-" : " ") + " " + line5;
                        break;
                }
            }
            first /= 10;
        }
        System.out.println();
        line[0] = line1;
        line[1] = line2;
        line[2] = line3;
        line[3] = line4;
        line[4] = line5;
        for (int i = 0; i < 5; i++){
            System.out.println(line[i]);
        }

    }

    //数字数码管显示方法，參数为要显示的数字
    public static int[] showNumber(int a){
        int []n = {0,0,0,0,0,0,0};
        switch (a) {
            case 0:
                n[0]=1;n[1]=1;n[2]=1;n[4]=1;n[5]=1;n[6]=1;
                break;
            case 1:
                n[2]=1;n[5]=1;
                break;
            case 2:
                n[0]=1;n[2]=1;n[3]=1;n[4]=1;n[6]=1;
                break;
            case 3:
                n[0]=1;n[2]=1;n[3]=1;n[5]=1;n[6]=1;
                break;
            case 4:
                n[1]=1;n[2]=1;n[3]=1;n[5]=1;
                break;
            case 5:
                n[0]=1;n[1]=1;n[3]=1;n[5]=1;n[6]=1;
                break;
            case 6:
                n[0]=1;n[1]=1;n[3]=1;n[4]=1;n[5]=1;n[6]=1;
                break;
            case 7:
                n[0]=1;n[2]=1;n[5]=1;
                break;
            case 8:
                n[0]=1;n[1]=1;n[2]=1;n[3]=1;n[4]=1;n[5]=1;n[6]=1;
                break;
            case 9:
                n[0]=1;n[1]=1;n[2]=1;n[3]=1;n[5]=1;n[6]=1;
                break;
            default:
                break;
        }
        return n;//返回int数组
    }

}

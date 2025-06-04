import java.util.Scanner;

public class day5p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter  the string : ");
        String s = sc.nextLine();
        sc.close();

        int[] freq = new int[26];

        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int i = 0;
        for(int count : freq) {
            if(count != 0) {
                i = count;
                break;
            }
        }

        boolean j = true;
        for(int count : freq) {
            if(count != 0 && count != i) {
                j = false;
                break;
            }
        }

        if(j) {
            System.out.println("AAshriya smiles: Emotional balance found.");
        } else {
            System.out.println("Aashriya wonders: These thoughts were scattered.");
        }
    }
}

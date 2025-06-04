import java.util.*;

public class day6p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of patient entries for the day : ");
        int n = sc.nextInt();
        sc.nextLine();
        String[] pname = new String[n];
        System.out.println("Enter the patients name : ");
        for(int i = 0; i < n; i++) {
            pname[i] = sc.nextLine().trim();
        }
        sc.close();

        List<String> uniqueVowelNames = new ArrayList<>();
        String vowels = "aeiou";

        for (int i = 0; i < n; i++) {
            String name = pname[i];

            if (!name.isEmpty() && vowels.indexOf(name.charAt(0)) != -1) {
                // Check for uniqueness manually
                boolean alreadyAdded = false;
                for (String added : uniqueVowelNames) {
                    if (added.equals(name)) {
                        alreadyAdded = true;
                        break;
                    }
                }
                if (!alreadyAdded) {
                    uniqueVowelNames.add(name);
                }
            }
        }

        // Output
        System.out.println(uniqueVowelNames.size());
        for (String name : uniqueVowelNames) {
            System.out.println(name);
        }
    }
}


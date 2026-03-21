package _012_Greedy_Algorithms._01_Easy;

public class _02_Lemonade_Change {

    // Function to check if change can be given
    public boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten = 0;

        for (int bill : bills) {

            // Case 1: $5 bill
            if (bill == 5) {
                five++;
            }

            // Case 2: $10 bill
            else if (bill == 10) {

                // Need to give $5
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            }

            // Case 3: $20 bill
            else {

                // Prefer giving 10 + 5
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                }

                // Else give 5 + 5 + 5
                else if (five >= 3) {
                    five -= 3;
                }

                // Cannot give change
                else {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        _02_Lemonade_Change obj = new _02_Lemonade_Change();

        int[] bills1 = {5, 5, 10, 5, 20};
        int[] bills2 = {5, 5, 10, 10, 20};
        int[] bills3 = {5, 5, 10, 20};

        System.out.println("Example 1: " + obj.lemonadeChange(bills1)); // true
        System.out.println("Example 2: " + obj.lemonadeChange(bills2)); // false
        System.out.println("Test Case: " + obj.lemonadeChange(bills3)); // true
    }
}
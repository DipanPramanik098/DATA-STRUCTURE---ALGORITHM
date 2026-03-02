package _07_Basic_String;

public class _01_String_DEMO {

    public static void main(String[] args) {

        // ================================
        // 1️⃣ String Creation
        // ================================
        String s1 = "Java";                 // String Literal (SCP)
        String s2 = new String("Java");     // Heap Object

        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);

        // ================================
        // 2️⃣ length()
        // ================================
        System.out.println("Length: " + s1.length());

        // ================================
        // 3️⃣ charAt()
        // ================================
        System.out.println("charAt(2): " + s1.charAt(2));

        // ================================
        // 4️⃣ toUpperCase() & toLowerCase()
        // ================================
        System.out.println("Upper: " + s1.toUpperCase());
        System.out.println("Lower: " + s1.toLowerCase());

        // ================================
        // 5️⃣ trim()
        // ================================
        String s3 = "   Hello   ";
        System.out.println("Trim: '" + s3.trim() + "'");

        // ================================
        // 6️⃣ equals() & equalsIgnoreCase()
        // ================================
        System.out.println("equals: " + s1.equals(s2));
        System.out.println("equalsIgnoreCase: " + s1.equalsIgnoreCase("java"));

        // ================================
        // 7️⃣ compareTo()
        // ================================
        System.out.println("compareTo: " + "apple".compareTo("banana"));

        // ================================
        // 8️⃣ contains()
        // ================================
        String s4 = "Java Programming";
        System.out.println("contains: " + s4.contains("Program"));

        // ================================
        // 9️⃣ startsWith() & endsWith()
        // ================================
        System.out.println("startsWith: " + s4.startsWith("Java"));
        System.out.println("endsWith: " + s4.endsWith("ing"));

        // ================================
        // 🔟 indexOf() & lastIndexOf()
        // ================================
        String s5 = "banana";
        System.out.println("indexOf(a): " + s5.indexOf('a'));
        System.out.println("lastIndexOf(a): " + s5.lastIndexOf('a'));

        // ================================
        // 1️⃣1️⃣ substring()
        // ================================
        String s6 = "Programming";
        System.out.println("substring(3): " + s6.substring(3));
        System.out.println("substring(3,7): " + s6.substring(3, 7));

        // ================================
        // 1️⃣2️⃣ replace()
        // ================================
        System.out.println("replace: " + s1.replace('a', 'o'));

        // ================================
        // 1️⃣3️⃣ replaceAll() (Regex)
        // ================================
        String s7 = "abc123";
        System.out.println("replaceAll digits: " + s7.replaceAll("[0-9]", ""));

        // ================================
        // 1️⃣4️⃣ split()
        // ================================
        String s8 = "Java,Python,C++";
        String[] arr = s8.split(",");
        System.out.println("Split Result:");
        for (String str : arr) {
            System.out.println(str);
        }

        // ================================
        // 1️⃣5️⃣ concat()
        // ================================
        System.out.println("concat: " + s1.concat(" Language"));

        // ================================
        // 1️⃣6️⃣ isEmpty() & isBlank()
        // ================================
        String emptyStr = "";
        String blankStr = "   ";
        System.out.println("isEmpty: " + emptyStr.isEmpty());
        System.out.println("isBlank: " + blankStr.isBlank());

        // ================================
        // 1️⃣7️⃣ toCharArray()
        // ================================
        char[] charArray = s1.toCharArray();
        System.out.println("toCharArray:");
        for (char c : charArray) {
            System.out.print(c + " ");
        }
        System.out.println();

        // ================================
        // 1️⃣8️⃣ valueOf()
        // ================================
        int num = 100;
        String numStr = String.valueOf(num);
        System.out.println("valueOf: " + numStr);

        // ================================
        // 1️⃣9️⃣ join()
        // ================================
        String joined = String.join("-", "2026", "03", "02");
        System.out.println("join: " + joined);

        // ================================
        // 2️⃣0️⃣ matches()
        // ================================
        System.out.println("matches: " + s7.matches("[a-z0-9]+"));

        // ================================
        // 2️⃣1️⃣ String Traversal
        // ================================
        System.out.println("Traversal:");
        for (int i = 0; i < s1.length(); i++) {
            System.out.print(s1.charAt(i) + " ");
        }
        System.out.println();

        // ================================
        // 2️⃣2️⃣ Reverse String
        // ================================
        String original = "Java";
        String reverse = "";
        for (int i = original.length() - 1; i >= 0; i--) {
            reverse += original.charAt(i);
        }
        System.out.println("Reverse: " + reverse);

        // ================================
        // 2️⃣3️⃣ Palindrome Check
        // ================================
        String palindrome = "madam";
        String rev = new StringBuilder(palindrome).reverse().toString();
        System.out.println("Is Palindrome: " + palindrome.equals(rev));

        // ================================
        // 2️⃣4️⃣ ASCII Value
        // ================================
        char ch = 'A';
        System.out.println("ASCII of A: " + (int) ch);

        // ================================
        // 2️⃣5️⃣ Character Frequency
        // ================================
        String freqStr = "apple";
        int[] freq = new int[256];

        for (char c : freqStr.toCharArray()) {
            freq[c]++;
        }

        System.out.println("Frequency of 'p': " + freq['p']);

        // ================================
        // 2️⃣6️⃣ StringBuilder (Mutable String)
        // ================================
        StringBuilder sb = new StringBuilder("Java");
        sb.append(" Programming");
        System.out.println("StringBuilder: " + sb);

        // ================================
        // 2️⃣7️⃣ Reference Comparison (== vs equals)
        // ================================
        String a = "Hello";
        String b = "Hello";
        String c = new String("Hello");

        System.out.println("a == b: " + (a == b));       // true (SCP)
        System.out.println("a == c: " + (a == c));       // false (Heap)
        System.out.println("a.equals(c): " + a.equals(c)); // true (Content)
    }
}
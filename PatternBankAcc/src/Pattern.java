public class Pattern {
    static int pattern;

    static void squarePattern() {
        for (int i = 0; i < pattern; i++) {
            for (int j = 0; j < pattern; j++) {
                if (i > 0 && i < pattern - 1 && j > 0 && j < pattern - 1) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    static void ellipsePattern() {
        for (int i = 0; i < pattern; i++) {
            for (int j = 0; j < pattern; j++) {
                if ((i == 0 || i == pattern - 1) && (j < 3 || j > 5)) {
                    System.out.print(" ");
                } else if () {

                }
                else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    static void rhombusPattern() {
        for (int i = 0; i < pattern; i++) {
            int noOfSpaces = i < pattern / 2 ? (pattern / 2) - i : i - (pattern / 2);
            int spaceBetween = i < pattern / 2 + 1 ? 2 * i - 1 : 2 * (pattern - i) - 3;
            for (int j = 0; j < noOfSpaces; j++)
                System.out.print(" ");
            System.out.print("*");
            for (int j = 0; j < spaceBetween; j++)
                System.out.print(" ");
            if (i > 0 && i < pattern - 1) 
                System.out.print("*");
            System.out.println();
        }
    }

    static void arrowUpPattern() {
        for (int i = 0; i < pattern; i++) {
            int noOfSpaces = i < 3 ? 2 - i : 2;
            for (int j = 0; j < noOfSpaces; j++)
                System.out.print(" ");
            for (int j = 0; j <= 2 * i; j++) {
                if (i >= 3)
                    break;
                System.out.print("*");
            }
            if (i >= 3)
                System.out.print("*");
            System.out.println();
        }
    }

    Pattern(int pattern) {
        Pattern.pattern = pattern;
    }
}

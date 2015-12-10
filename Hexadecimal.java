public class Hexadecimal {

    private int _decNum;
    private String _hexNum;
    private final static String HEXDIGITS = "0123456789ABCDEF";

    /*=====================================
      default constructor
    pre:  n/a
    post: initializes _decNum to 0, _hexNum to "0"
    =====================================*/
    public Hexadecimal() {
        /****** YOUR IMPLEMENTATION HURRR ******/
        _decNum = 0;
        _hexNum = "0";
    }


    /*=====================================
      overloaded constructor
    pre:  n >= 0
    post: sets _decNum to n, _hexNum to equiv string of nibbles
    =====================================*/
    public Hexadecimal(int n) {
        /****** YOUR IMPLEMENTATION HURRR ******/
        _decNum = n;
        _hexNum = decToHex(n);
    }


    /*=====================================
      overloaded constructor
    pre:  s is String representing non-negative hexadecimal number
    post: sets _hexNum to input, _decNum to decimal equiv
    =====================================*/
    public Hexadecimal(String s) {
        /****** YOUR IMPLEMENTATION HURRR ******/
        _decNum = hexToDec(s);
        _hexNum = s;
    }


    /*=====================================
      String toString() -- returns String representation of this Object
    pre:  n/a
    post: returns String representing the hexadecimal value of this Object
    =====================================*/
    public String toString() {
        /****** YOUR IMPLEMENTATION HURRR ******/
        return _hexNum;
    }


    /*=====================================
      String decToHex(int) -- converts base-10 input to hexadecimal
    pre:  n >= 0
    post: returns String of nibbles
    =====================================*/
    public static String decToHex(int n) {
        /****** YOUR IMPLEMENTATION HURRR ******/
        String hex = "";
        while (n > 0) {
            hex = HEXDIGITS.substring(n%16, (n%16)+1) + hex;
            n /= 16;
        }
        return hex;
    }


    /*=====================================
      String decToHexR(int) -- converts base-10 input to hexadecimal, recursively
    pre:  n >= 0
    post: returns String of nibbles
    =====================================*/
    public static String decToHexR(int n) {
        /****** YOUR IMPLEMENTATION HURRR ******/
        if (n < 16) {
            return HEXDIGITS.substring(n,n+1);
        }
        int temp = n / 16;
        return  HEXDIGITS.substring(temp, temp+1) + decToHexR(n - (temp * 16));
    }


    /*=====================================
      String HexToDec(String) -- converts base-10 input to hexadecimal
    pre:  s represents non-negative hexadecimal number
    post: returns String of nibbles
    =====================================*/
    public static int hexToDec(String s) {
        /****** YOUR IMPLEMENTATION HURRR ******/
        int dec = 0;
        for (int i = 0; i < s.length(); i++) {
            String chr = s.substring(i, i+1);
            int temp = HEXDIGITS.indexOf(chr);
            dec = dec*16 + temp;
        }
        return dec;
    }


    /*=====================================
      String HexToDecR(String) -- converts base-10 input to hexadecimal, recursively
    pre:  s represents non-negative hexadecimal number
    post: returns String of nibbles
    =====================================*/
    public static int hexToDecR(String s) {
        /****** YOUR IMPLEMENTATION HURRR ******/
        String hex = s.substring(0,1);
        if (s.length() == 1) {
            return HEXDIGITS.indexOf(hex);
        }
        return 16 * HEXDIGITS.indexOf(hex) + hexToDecR(s.substring(1));
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
    pre:  other is an instance of class Hexadecimal
    post: Returns true if this and other are aliases (pointers to same
    Object), or if this and other represent equal hexadecimal values
    =============================================*/
    public boolean equals(Object other) {
        /****** YOUR IMPLEMENTATION HURRR ******/
        return compareTo(other) == 0;
    }


    /*=============================================
      int compareTo(Object) -- tells which of two Hexadecimal objects is greater
    pre:  other is instance of class Hexadecimal
    post: Returns 0 if this Object is equal to the input Object,
    negative integer if this<input, positive integer otherwise
    =============================================*/
    public int compareTo(Object other) {
        /****** YOUR IMPLEMENTATION HURRR ******/
        try{
        Hexadecimal hex = (Hexadecimal) other;
        int theirs = hex._decNum;
        int ours = this._decNum;
        if(theirs == ours) {
            return 0;
        } else if(theirs > ours) {
            return -1;
        }
        return 1;
        }
      catch (NullPointerException){
      System.err.println("Input is null");
      }
      catch (ClassCastException){
      System.err.println("Input is not Binary");
      }
    }


    //main method for testing
    public static void main(String[] args) {
        System.out.println(decToHex(123));
        System.out.println(decToHexR(123));
        System.out.println(hexToDec("7B"));
        System.out.println(hexToDecR("7B"));
        
        System.out.println("Testing...");
        Hexadecimal h1 = new Hexadecimal(123);
        Hexadecimal h2 = new Hexadecimal(123);
        Hexadecimal h3 = h1;
        Hexadecimal h4 = new Hexadecimal(321);

        System.out.println(h1);
        System.out.println(h2);
        System.out.println(h3);
        System.out.println(h4);

        System.out.println("\n==...");
        System.out.println(h1 == h2); //should be false
        System.out.println(h1 == h3); //should be true

        System.out.println("\n.equals()...");
        System.out.println(h1.equals(h2)); //should be true
        System.out.println(h1.equals(h3)); //should be true
        System.out.println(h3.equals(h1)); //should be true
        System.out.println(h4.equals(h2)); //should be false
        System.out.println(h1.equals(h4)); //should be false

        System.out.println("\n.compareTo...");
        System.out.println(h1.compareTo(h2)); //should be 0
        System.out.println(h1.compareTo(h3)); //should be 0
        System.out.println(h1.compareTo(h4)); //should be neg
        System.out.println(h4.compareTo(h1)); //should be pos
    }//end main()

} //end class

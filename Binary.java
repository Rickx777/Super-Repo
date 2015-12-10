public class Binary {

    private int _decNum;
    private String _binNum;


    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _binNum to "0"
      =====================================*/
    public Binary() { 
	_decNum = 0;
	_binNum = "0";
    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _binNum to equiv string of bits
      =====================================*/
    public Binary( int n ) {
	_decNum = n;
	_binNum = this.decToBin(_decNum);
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative binary number
      post: sets _binNum to input, _decNum to decimal equiv
      =====================================*/
    public Binary( String s ) {
	_binNum = s;
	_decNum = this.binToDec(_binNum);
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	return _binNum;   
    }


    /*=====================================
      String decToBin(int) -- converts base-10 input to binary
      pre:  n >= 0
      post: returns String of bits
      eg  decToBin(0) -> "0"
      decToBin(1) -> "1"
      decToBin(2) -> "10"
      decToBin(3) -> "11"
      decToBin(14) -> "1110"
      =====================================*/
    public static String decToBin( int n ) {
      String retstr = "";
      int high = 0;
      while (high < n){
        if (high == 0){
          high = 1;
        }
        else high *= 2;
      }
      for (int x = (high / 2); x > 0; x /= 2){
        if (n - x  >= 0){
          retstr += 1;
          n -= x;
        }
        else retstr += 0;
      }
      return retstr;
    }


    /*=====================================
      String decToBinR(int) -- converts base-10 input to binary, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToBinR(0) -> "0"
      decToBinR(1) -> "1"
      decToBinR(2) -> "10"
      decToBinR(3) -> "11"
      decToBinR(14) -> "1110"
      =====================================*/
    static String retstr = "";
    static int ctr = 0;
    public static String decToBinR( int n ) {
      
    if (ctr == 0){
      retstr = "";
      ctr = 1;
    }
    
    if ((ctr >= n) && (n > 0)){
      if (ctr > n){
        ctr /= 2;
      }
      
      if (n >= ctr){
        retstr += 1;
        n -= ctr;
      }
    }
    
    if (ctr < n && (ctr != 0) && (n != 0)){
      ctr *= 2;
    }
    
    if (ctr != 0 && (n == 0)){
      ctr /= 2;
      retstr += 0;
    }
    
    if (n < 2 && ctr == 0){
      ctr = 0;
      return retstr;
    }
    return decToBinR(n);
  }


    /*=====================================
      String binToDec(String) -- converts base-10 input to binary
      pre:  s represents non-negative binary number
      post: returns String of bits
      eg  
      binToDec("0") -> 0
      binToDec("1") -> 1
      binToDec("10") -> 2
      binToDec("11") -> 3
      binToDec("1110") -> 14
      =====================================*/
    public static int binToDec( String s ) {
      int sum = 0;
      while (s.length() > 0){
        if ((s.substring(1,2)).equals("1")){
          sum += Math.pow(2, s.length() - 1);
          s = s.substring(1);
        }
        else s = s.substring(1);
      }
      return sum;
    }


    /*=====================================
      String binToDecR(String) -- converts base-10 input to binary, recursively
      pre:  s represents non-negative binary number
      post: returns String of bits
      eg  
      binToDecR("0") -> 0
      binToDecR("1") -> 1
      binToDecR("10") -> 2
      binToDecR("11") -> 3
      binToDecR("1110") -> 14
      =====================================*/
    static int sum;
    public static int binToDecR( String s ) { 
      if (s.length() < 2) {
        sum += Integer.parseInt(s.substring(0));
        return sum;
      }
      
      else {
        sum += Integer.parseInt(s.substring(0,1)) * Math.pow(2,s.length() - 1);
        return binToDecR(s.substring(1));
      }
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Binary
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals( Object other ) { 
      boolean retval = this == other;
      if (!retval){
        retval = other instanceof Binary
                && this._binNum.equals( ((Binary)other)._binNum);
      }
      return retval;
    }


    /*=============================================
      int compareTo(Object) -- tells which of two Binary objects is greater
      pre:  other is instance of class Binary
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other ) {
      try{
      return (this._decNum - ((Binary)other)._decNum);
      }
      catch (NullPointerException){
      System.err.println("Input is null");
      }
      catch (ClassCastException){
      System.err.println("Input is not Binary");
      }
    }


    //main method for testing
    public static void main( String[] args ) {

	System.out.println();
	System.out.println( "Testing ..." );

	Binary b1 = new Binary(5);
	Binary b2 = new Binary(5);
	Binary b3 = b1;
	Binary b4 = new Binary(14);

	System.out.println( b1 );
	System.out.println( b2 );
	System.out.println( b3 );       
	System.out.println( b4 );       

	System.out.println( "\n==..." );
	System.out.println( b1 == b2 ); //should be false
	System.out.println( b1 == b3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( b1.equals(b2) ); //should be true
	System.out.println( b1.equals(b3) ); //should be true
	System.out.println( b3.equals(b1) ); //should be true
	System.out.println( b4.equals(b2) ); //should be false
	System.out.println( b1.equals(b4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( b1.compareTo(b2) ); //should be 0
	System.out.println( b1.compareTo(b3) ); //should be 0
	System.out.println( b1.compareTo(b4) ); //should be neg
	System.out.println( b4.compareTo(b1) ); //should be pos
    }//end main()

} //end class

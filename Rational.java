public class Rational
{
    private int numerator;
    private int denominator;
    public Rational(){
        numerator = 0;
        denominator = 1;
    }
    public Rational(int num, int den){
        if (den == 0)
        {
            System.out.print("Denominator cannot be zero");
            numerator=0;
            denominator=1;
            return;
        }
        numerator=num;
        denominator=den;
        reduce();
    }
    public String toString(){
        return numerator + "/" + denominator;
    }
    public double floatValue(){
        return (double)numerator / denominator;
    }

   
    public static int gcd(int p, int q) {
        if(p>q){
        if (q == 0) return p;
        else return gcd(q, p % q);
        }
        else{
        if (p == 0) return q;
        else return gcd(p, q % p);
         }
    }
    public int gcd() {
        if(denominator>numerator){
        if (denominator == 0) return numerator;
        else return gcd(denominator, numerator % denominator);
    }
        else{
             if (numerator == 0) return denominator;
            else return gcd(numerator, denominator % numerator);
        }
    }
    public void multiply(Rational other){
        numerator *= other.numerator;
        denominator *= other.denominator;
        reduce();
    }
    public void divide(Rational other){
        numerator *= other.denominator;
        denominator *= other.numerator;
        reduce();
    }
    public void reduce(){
        int gcd = gcdER(numerator,denominator);
        numerator = numerator/gcd;
        denominator = denominator/gcd;
    }
    public static int gcdER(int a, int b){

	int theGcd = 1;
	
	if (a>b) {
	    if (a%b==0) { //done, yay!
		theGcd = b;
	    } else { //implement algorithm
		a -= b;
		theGcd = gcdER(a, b);
	    }}
	
	else {
	    theGcd = gcdER(b,a); //instead of rewriting code, switch maxes
	}
	return theGcd;
    }
    /*public void reduce(){
        if(numerator > denominator){
        numerator= numerator/ gcd(numerator, denominator);
        denominator= denominator/gcd(numerator,denominator);
        return;
        }
        else{
        numerator= numerator/ gcd(numerator, denominator);
        denominator= denominator/gcd(numerator,denominator);
        return;
        }
        
    }*/
    public void  add(Rational other){
    	//must be void!
    	int lcm = 0;
    	lcm= denominator * other.denominator;
    	numerator = numerator * (lcm/denominator);
    	numerator += other.numerator*(lcm/other.denominator);
     denominator=lcm;	
    }
    public int compareTo(Rational other){
        if(other.floatValue()> floatValue()){
            return -1;
        }
        if(other.floatValue()< floatValue()){
            return 1;
        }
        else {
            return 0;
        }
    }
    public boolean equals(Rational x){
        this.reduce();
        x.reduce();
        //System.out.println(x.numerator);
        //System.out.println(x.denominator);
        //System.out.println(numerator);
        //System.out.println(denominator);
        return (numerator==x.numerator&&denominator==x.denominator);

    }
    public static void main(String[] args) {
	    Rational r = new Rational(2,3); //Stores the rational number 2/3
	    System.out.println(r.toString());
	    Rational s = new Rational(1,2); //Stores the rational number 1/2
    	System.out.println(s.toString());
    	Rational t = new Rational(4,18);
    	Rational w = new Rational(4,8);//Stores the rational number 4/8
    	r.add(s);  //Adds r to s, changes r to 7/6.  s remains 1/2
    	System.out.println(r.toString());
    	t.reduce(); //Changes t to 2/9
    	System.out.println(t.toString());
    	System.out.println(r.compareTo(s));
    	System.out.println(w.equals(s));//true
    	System.out.println(w.equals(r));//false

    }

}
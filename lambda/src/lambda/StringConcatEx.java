package lambda;

public class StringConcatEx {
	public static void main(String[] args) {
//		StringConCat sc = new StringConcatImpl();
//		sc.makeString("Hello", "Interface");
		
		
		StringConCat sc = (s1, s2) -> System.out.println(s1+", "+s2);
		sc.makeString("hello", "world");
	}
}

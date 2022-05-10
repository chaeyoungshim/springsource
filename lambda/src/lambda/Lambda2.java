package lambda;

//함수형 인터페이스 : 단 하나의 추상 메서드만 정의되어 있어야 함(default, static 여부는 상관없음)
//				 기존의 인터페이스도 추상메소드가 하나만 있다면 항수형 인터페이스
//				 @FunctionalInterface : 안전하게 함수형 인터페이스를 구현할 수 있도록 도와줌

@FunctionalInterface
public interface Lambda2 {
	//람다식으로 구현할 메소드 선언
//	public void method(int x);
	public int max(int num1, int num2);
}

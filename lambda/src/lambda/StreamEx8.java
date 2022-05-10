package lambda;

import java.util.Arrays;
import java.util.List;

public class StreamEx8 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("사과","딸기","배","바나나","수박","참외","바나나"); 
		
		list.stream()
			.skip(2)  //2개 건너뛰기
			.limit(3) //2개 건너뛴 후 다음에 오는 3개만 가져오기(제한해서 일부만 가져오기)
			.forEach(s -> System.out.println(s));
		
		
	}
}





















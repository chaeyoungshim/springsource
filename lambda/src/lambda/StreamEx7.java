package lambda;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx7 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("사과","딸기","배","바나나","수박","참외","바나나");
		
		list.stream().distinct().forEach(s -> System.out.println(s));
		
		Stream<File> stream = Stream.of(new File("file1.txt"), new File("file2.txt"),new File("Ex1"),
						new File("Ex2.bak"),new File("test.java"));
		
		//파일명을 모아서(map) 확장자가 없는 파일명은 제외하고(filter), 확장자만 모으고(map)
		//확장자 중복 제거(distinct) 후 확장자 출력(forEach)
		stream.map(File::getName)								// "file1.txt","file2.txt","Ex1","Ex2.bak","test.java"
				.filter(f -> f.indexOf(".") > -1)				 //-1보다 크냐는건 .(확장자)이 존재하냐는 의미,  "file1.txt","file2.txt","Ex2.bak","test.java"
				.map(f -> f.substring(f.lastIndexOf(".")+1))	//"txt","txt","bak","java"
				.distinct()										//"txt","bak","java"
				.forEach(s -> System.out.println(s));			//반복문 이용해서 출력하기
		
		
	}
}





















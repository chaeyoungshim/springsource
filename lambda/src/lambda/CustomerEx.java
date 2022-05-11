package lambda;

import java.util.ArrayList;
import java.util.List;

public class CustomerEx {
	public static void main(String[] args) {
		List<Customer> customerList = new ArrayList<Customer>();
		customerList.add(new Customer("이순신", 40, 100));
		customerList.add(new Customer("김유신", 20, 100));
		customerList.add(new Customer("홍길동", 13, 50));
		customerList.add(new Customer("성춘향", 18, 70));
		
		//고객 명단 출력
		customerList.stream().map(n -> n.getName()).forEach(n -> System.out.println(n));
		
		System.out.println();
		
		//총 여행 경비 계산 
		long total = customerList.stream().mapToInt(c -> c.getPrice()).sum();
		System.out.println("총 여행 경비 : "+total);
		
		System.out.println();
		
		//고객 중 20세 이상인 사람의 이름을 정렬하여 출력
		System.out.println("--- 20세 이상 고객 명단 ---");
		customerList.stream().filter(c -> c.getAge() >= 20).map(c -> c.getName()).sorted().forEach(c -> System.out.println(c));
	
	
	}
}

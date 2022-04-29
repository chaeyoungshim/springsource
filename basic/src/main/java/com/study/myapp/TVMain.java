package com.study.myapp;

public class TVMain {
	public static void main(String[] args) {
		//TV tv = new SamsungTV(new SonySpeaker()); //이걸 주입 이라고 함
		
		SamsungTV tv = new SamsungTV(); //디폴트 객체 생성
		
//		tv.setSpeaker(new SonySpeaker()); //이건 세터 이용해서 초기화 해주기
		tv.setSpeaker(new AppleSpeaker());
		
		tv.powerOn();
		tv.volumeUp();
		tv.powerOff();
		
//		String str = null;
//		System.out.println(str); //찍어내는거에서 널포인터가 나는게 아니라
//		System.out.println(str.toString()); //객체를 불러서 호출할 때 널포인터가 나는 것
		
	}
}

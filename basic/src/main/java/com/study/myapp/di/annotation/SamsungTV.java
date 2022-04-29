package com.study.myapp.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("samsung")
public class SamsungTV implements TV {
	
	@Autowired
	@Qualifier("apple") //특정 객체 찾기 위한 이름 지정
	private Speaker speaker; //부모로 잡아야 자식이 뭔지에 따라 따라가기 때문에 인터페이스 사용
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV 전원 On");
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV 전원 Off");
	}

	@Override
	public void volumeUp() {
		//System.out.println("SamsungTV Volume Up");
		speaker.volumeUp(); //스피커 이용해서 볼륨 업, null인 상태에서 메소드 불러들여서 널포인터이셉션이 발생
	}

	@Override
	public void volumeDown() {
		//System.out.println("SamsungTV Volume Down");
		speaker.volumeDown(); //스피커 이용해서 볼륨 다운
	}
}

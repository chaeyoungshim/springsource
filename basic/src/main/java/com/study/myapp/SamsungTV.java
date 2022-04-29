package com.study.myapp;

public class SamsungTV implements TV {
	
	//private SonySpeaker speaker; //스피커 달기 => 여기는 null, 초기화를 해줘야하맘(생성자,setter 이용)
//	private AppleSpeaker speaker;
	private Speaker speaker; //부모로 잡아야 자식이 뭔지에 따라 따라가기 때문에 인터페이스 사용
	
	
	public SamsungTV() { //디폴트 생성자
		
	}
	//생성자 : 멤버변수의 초기화
	public SamsungTV(Speaker speaker) {
		super();
		this.speaker = speaker;
	}
	
	// 초기화, 변경
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	
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

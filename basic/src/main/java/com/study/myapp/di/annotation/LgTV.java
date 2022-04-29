package com.study.myapp.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lg") //아이디와 같은 역할
public class LgTV implements TV {
	
	@Autowired //생성된 객체 주입하라는 것, speaker 객체(AppleSpeaker, SonySpeaker)
	@Qualifier("sony")
	private Speaker speaker;

	@Override
	public void powerOn() {
		System.out.println("LgTV 전원 On");
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV 전원 Off");
	}

	@Override
	public void volumeUp() {
		//System.out.println("LgTV Volume Up");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		//System.out.println("LgTV Volume Down");
		speaker.volumeDown();
	}
}

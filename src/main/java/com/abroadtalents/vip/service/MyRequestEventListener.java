package com.abroadtalents.vip.service;

import org.springframework.context.annotation.Bean;

import com.stormpath.sdk.servlet.account.event.RegisteredAccountRequestEvent;
import com.stormpath.sdk.servlet.account.event.VerifiedAccountRequestEvent;
import com.stormpath.sdk.servlet.authc.FailedAuthenticationRequestEvent;
import com.stormpath.sdk.servlet.authc.LogoutRequestEvent;
import com.stormpath.sdk.servlet.authc.SuccessfulAuthenticationRequestEvent;
import com.stormpath.sdk.servlet.event.RequestEventListener;
import com.stormpath.sdk.servlet.event.RequestEventListenerAdapter;

public class MyRequestEventListener implements RequestEventListener{
	@Bean
	public RequestEventListener stormpathRequestEventListener() {
	    return new RequestEventListenerAdapter();
	}
	@Override
	public void on(FailedAuthenticationRequestEvent e) {
		System.out.println("aaaaaaaaaaaaaa");
	}
	@Override
	public void on(LogoutRequestEvent e) {
		System.out.println("bbbbbbbb");
	}
	@Override
	public void on(SuccessfulAuthenticationRequestEvent e) {
		System.out.println("cccccc");
	}

	@Override
	public void on(RegisteredAccountRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void on(VerifiedAccountRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

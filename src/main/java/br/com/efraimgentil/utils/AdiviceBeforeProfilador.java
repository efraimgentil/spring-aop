package br.com.efraimgentil.utils;

import java.io.File;
import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class AdiviceBeforeProfilador implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object tagert)
			throws Throwable {
		// TODO Auto-generated method stub
		
		if(method.getName().equals("persistAll") && args[1] != null){
			File file = (File) args[1];
			if(file.exists()){
				System.err.println("Before Advice: File aready exists");
				args[1] = null;
			}
		}
		
	}

}

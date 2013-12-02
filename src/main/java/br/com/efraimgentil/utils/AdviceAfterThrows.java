package br.com.efraimgentil.utils;

import java.io.IOException;

import org.springframework.aop.ThrowsAdvice;

public class AdviceAfterThrows implements ThrowsAdvice{

	/*
	 * Por convenção do Spring os nomes dos metodos tem que ser afterThrowing
	 * e devem receber como parametro alguma exceção
	 */
	public void afterThrowing(IllegalArgumentException ex){
		//Executa alguma ação paleativa ou avisa o suporte
	}
	
	public void afterThrowing(IOException ex){
		
	}
	
}

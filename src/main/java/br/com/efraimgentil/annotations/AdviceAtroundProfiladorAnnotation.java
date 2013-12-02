package br.com.efraimgentil.annotations;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AdviceAtroundProfiladorAnnotation {

	private List<Long> tempos = new ArrayList<>();
	
	public List<Long> getTempos(){ return tempos; }
	
	@Around("execution(* br.com.efraimgentil.daos.PersonDAO.* (..))")
	public Object prifilar(ProceedingJoinPoint joinPoint) throws Throwable{
		long momentoInicial = System.currentTimeMillis();
		Object resultado = joinPoint.proceed();
		long tempo = System.currentTimeMillis() - momentoInicial;
		tempos.add(tempo);
		System.out.println("Execution time = " + tempo + "ms" );
		return resultado;
	}
	
	//Is possible to add more than one tipe of advice using annotations 
	@Before("execution(* br.com.efraimgentil.daos.PersonDAO.readFile(..) )")
	public void colectStatistics(JoinPoint joinPoint){
		File file  = (File) joinPoint.getArgs()[1];
	}
	
	@AfterThrowing( pointcut="execution(* br.com.efraimgentil.daos.PersonDAO.*(..))",
			throwing = "ex")
	public void sendInformation(IOException ex){
		//sendEmail(ex)
	}
	
}

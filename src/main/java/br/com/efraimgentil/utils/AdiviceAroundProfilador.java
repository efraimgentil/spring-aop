package br.com.efraimgentil.utils;

import java.util.ArrayList;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.hibernate.mapping.Array;

public class AdiviceAroundProfilador implements MethodInterceptor {
	
	private List<Long> intervals = new ArrayList<>();
	
	public List<Long> getIntervals(){ return intervals; }
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		long initialTime = System.currentTimeMillis();
		
		
		Object result = invocation.proceed();
		long endTime = System.currentTimeMillis() - initialTime;;
		intervals.add( endTime );
		System.out.println("Execution time " + endTime + " ms");
		
		return result;
	}

}

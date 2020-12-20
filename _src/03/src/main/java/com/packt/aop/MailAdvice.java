package com.packt.aop;
import org.aspectj.lang.ProceedingJoinPoint;
public class MailAdvice {
	 public void advice(final ProceedingJoinPoint proceedingJoinPoint) {
	        new Thread(new Runnable() {
	            public void run() {
	               System.out.println("proceedingJoinPoint:"+proceedingJoinPoint);
	                try {
	                	proceedingJoinPoint.proceed();
	                } catch (Throwable t) {
	                    // All we can do is log the error.
	                    System.out.println(t);
	                }
	            }
	        }).start();
	    }
	}


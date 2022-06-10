package com.team2.docgram.aop;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.team2.docgram.dto.UserDto;

@Aspect
@Component
public class SignInAspect {
	
	@Pointcut("execution(* com.team2.docgram.controller.UserController.login*(..))")
	private void login() {}
	
	@Pointcut("execution(* com.team2.docgram.controller.UserController.signup*(..))")
	private void signup() {}
	
	@Pointcut("execution(* com.team2.docgram.controller.UserController.userTos(..))")
	private void tos() {}
	
	@Pointcut("execution(* com.team2.docgram.controller.UserController.admin*(..))")
	private void admin() {}
	
	@Pointcut("execution(* com.team2.docgram.controller.BoardController.mainPage(..))")
	private void main() {}
	
	@Around("!main() && !tos() && !signup() && !login() && execution(* com.team2.docgram.controller.*Controller.*(..))")
	public Object sesssionCheck(ProceedingJoinPoint point) throws Throwable {
		Object result = null;
		HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest().getSession();
		UserDto user = (UserDto) session.getAttribute("user");
		if(user == null) {
			result = "redirect:/user/signin";
		}else {
			result = point.proceed();
		}
		return result;
	}
}

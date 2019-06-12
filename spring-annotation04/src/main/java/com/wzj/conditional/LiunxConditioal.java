package com.wzj.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LiunxConditioal implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// 获取操作系统的名字 os:operator system
		String osName = context.getEnvironment().getProperty("os.name");
		if (osName.contains("liunx")) {
			return true;
		}
		return false;
	}

}

package com.wzj.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class LiunxConditioal implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// ��ȡ����ϵͳ������ os:operator system
		String osName = context.getEnvironment().getProperty("os.name");
		if (osName.contains("liunx")) {
			return true;
		}
		return false;
	}

}

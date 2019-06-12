package com.wzj.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsConditioal implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// ��ȡ����ϵͳ������ os:operator system
		String osName = context.getEnvironment().getProperty("os.name");
		if (osName.contains("Windows")) {
			return true;
		}
		return false;
	}

}

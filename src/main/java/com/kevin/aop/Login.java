package com.kevin.aop;

public @interface Login {
	ResultTypeEnum value() default ResultTypeEnum.page;
}

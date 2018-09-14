package com.peony.microcloudstock.common.aop;


/**
 * 缓存注解，加了这个注解的入口方法，都会使用aop切入，环绕通知
 * 1.如果调用参数没有发生变化，直接从缓存中提取数据
 * 2.如果调用参数发生变化，则进入业务逻辑层，提到数据后再缓存数据
 * 3.缓存有效期为10分钟
 * */
public @interface Ehcache {
}

package cn.itcast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import cn.itcast.service.UserService;

/**
 * 自动装配：
 * 		spring利用依赖注入(DI),完成对IOC容器中各个组件的依赖关系 赋值
 * 
 * 1. @autoWired 自动注入
 * 	  a. 默认优先按照类型去容器中找对应的组件 ioc.getBean(UserService.class) 找到就赋值
 *    b. 如果找到多个相同类型的组件, 再将属性的名称作为组件的id去容器查找 ioc.getBean("userService");
 *    c. @Qualifier("userService") 使用@Qualifier组件指定需要装配组件的id,而不是使用属性名
 *    d. 自动装配默认一定要将属性赋值好，没有就会报错
 *    	 	可以使用@AutoWired(required = false)
 *    e. @primary, 让Spring进行自动装配的时候,默认使用首选的bean
 *    		也可以继续使用@Qualifier指定需要装配的bean的名字
 *    UserController{
 *    	@autoWired
 *    	UserService userService;
 *    }
 * 
 * 2. spring还支持@Resource(JSR250)和@Inject(JSR330)[java规范的注解]
 * @Resource
 * 		可以和@AutoWired一样的实现自动装配功能, 默认是按照组件名称进行装配的
 * 		没有支持@primary功能也没有支持@AutoWired(required=false)
 * 
 * @Inject
 * 		需要导入javax.injext的包,和@AutoWired注解一样,只是没有@AutoWired(required=false)
 * 
 * @AutoWired: Spring定义的 , @Resource, @Inject是java规范
 * AutowiredAnnotationBeanPostProcessor: 解析完成自动装配功能
 * 
 * 3.@AutoWired: 构造器, 参数, 方法, 属性; 都是从容器中获取参数组件的值
 * 	 a.标在方法位置: @Bean+方法参数: 参数从容器中获取; 默认不写@Autowired效果是一样的,都能自动装配
 *   b.标在构造器上: 如果组件只有一个有参构造器,这个有参构造器的@AutoWired可以省略,参数位置的组件还是可以自动从容器中获取时
 *   c.放在参数位置:
 * @author 王志坚
 *
 */

@Controller
public class UserController {
	//默认按类型自动注入
//	@Qualifier("service02")
	@Autowired
	private UserService service;
	
	

	public UserService getService() {
		return service;
	}


	public void setService(UserService service) {
		this.service = service;
	}



	@Override
	public String toString() {
		return "UserController [service=" + service + "]";
	}
	
}

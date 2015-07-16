/**
 * 和MyPropertiesPlaceholderConfigurer一起实现了一个功能
 * 在代码中仅仅需要使用MyPropertiesUtil.getValue(key)就可以获得myprop.properties中的属性值
 */
package cn.xyz.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 类MyPropertyUtil.java的实现描述：TODO 类实现描述
 * 
 * @author xuyizhen 2014年12月26日 下午8:06:22
 */
//@Component
public class MyPropertiesUtil implements ApplicationContextAware {
    public static final String        KEY = "propertyConfigurer"; //自定义配置文件的bean的Id
    private static ApplicationContext applicationContext;
    public void setApplicationContext(ApplicationContext applicationContext) {
        MyPropertiesUtil.applicationContext = applicationContext;
    }
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    /**
     * 获取配置文件myconfig.properties中的内容
     *
     * @param key
     * @return
     */
    public static String getValue(String key) {
        MyPropertyPlaceholderConfigurer cp = (MyPropertyPlaceholderConfigurer) applicationContext.getBean(KEY);
        String result = cp.getContextProperty(key).toString();
        return result;
    }

}

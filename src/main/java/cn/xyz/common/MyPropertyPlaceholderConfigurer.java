package cn.xyz.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;


public class MyPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    private static Map<String, String> myProperties;
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
            throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        myProperties = new HashMap<String, String>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            myProperties.put(keyStr, value);
        }
    }
    public  static Object getContextProperty(String name) {
        return myProperties.get(name);
    }
}

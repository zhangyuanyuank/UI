package util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyUtil {

        private static Map<String,String> property_data = new HashMap<String,String>();

        static{
            Properties prop = new Properties();
            InputStream in = BaseUtil.class.getClassLoader()
                    .getResourceAsStream("test.properties");
            try {
                prop.load(in);
                for(Object key : prop.keySet()){
                    String keyStr = String.valueOf(key);
                    property_data.put(keyStr, prop.getProperty(keyStr));
                }
            }catch(Exception e){

            }
        }

        public static String getPropertyValue(String key)
        {
            if(property_data.containsKey(key)){
                return property_data.get(key);
            }
            return "";
        }
}



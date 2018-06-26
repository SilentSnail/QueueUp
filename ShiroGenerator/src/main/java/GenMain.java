import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liusong on 2018/4/3.
 */
public class GenMain {

    public static void main(String[] args){
        try {
            List<String> slist = new ArrayList<String>();
            boolean overwrite = true;
            File file = new File(GenMain.class.getResource("/generatorConfig.xml").getFile());
            Configuration config = new ConfigurationParser(slist).parseConfiguration(file);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, slist);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

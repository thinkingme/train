import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @ProjectName: 题目代码
 * @Package: PACKAGE_NAME
 * @ClassName: Proxy
 * @Author: huige
 * @Description: 代理类
 * @Date: 2021/12/13 13:14
 * @Version: 1.0
 */
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Proxy {
    String name;
    String server;
    String port;
    String type;
}

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * @ProjectName: 题目代码
 * @Package: PACKAGE_NAME
 * @ClassName: ProxyGroups
 * @Author: huige
 * @Description:
 * @Date: 2021/12/13 11:50
 * @Version: 1.0
 */
@Data
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProxyGroups {
    String name;
    String type;
    List<String> proxies;
}

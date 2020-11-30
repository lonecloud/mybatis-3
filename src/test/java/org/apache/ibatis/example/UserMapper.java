package org.apache.ibatis.example;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author lonecloud
 * @version v1.0
 * @Package org.apache.ibatis.example
 * @Description: TODO
 * @date 2020/11/243:31 PM
 */
public interface UserMapper {
  List<Map<String, Object>> query(@Param(value = "maxLng") BigDecimal maxLng, @Param(value = "minLng") BigDecimal minLng, @Param(value = "maxLat") BigDecimal maxLat, @Param(value = "minLat") BigDecimal minLat, @Param(value = "limitSize") Integer limitSize);
}

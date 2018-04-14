package utils;

import java.util.UUID;

/**
 *@author chenjibao
 *@date2018年3月31日上午9:48:02
 *@description:生成随机字符串的工具类
 */
public class UUIDUtils {
	/**
	 * 获得随机的字符串
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}

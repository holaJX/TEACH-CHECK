package com.hlzt.common.utils.uuid;

import com.github.yitter.contract.IdGeneratorOptions;
import com.github.yitter.idgen.YitIdHelper;

/**
 * ID生成器工具类
 *
 * @author ruo-yi
 */
public class IdUtils {
    /**
     * 1-漂移算法，2-传统算法
     */
    final static short method = 1;
    public static final IdGeneratorOptions options = new IdGeneratorOptions();

    /**
     * 获取随机UUID
     *
     * @return 随机UUID
     */
    public static String randomUUID() {
        return UUID.randomUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线
     *
     * @return 简化的UUID，去掉了横线
     */
    public static String simpleUUID() {
        return UUID.randomUUID().toString(true);
    }

    /**
     * 获取随机UUID，使用性能更好的ThreadLocalRandom生成UUID
     *
     * @return 随机UUID
     */
    public static String fastUUID() {
        return UUID.fastUUID().toString();
    }

    /**
     * 简化的UUID，去掉了横线，使用性能更好的ThreadLocalRandom生成UUID
     *
     * @return 简化的UUID，去掉了横线
     */
    public static String fastSimpleUUID() {
        return UUID.fastUUID().toString(true);
    }

    public static Long getNextId() {
        options.Method = method;
        options.WorkerId = 1;
        // 首先测试一下 IdHelper 方法，获取单个Id
        YitIdHelper.setIdGenerator(options);
        return YitIdHelper.nextId();
    }
}

package com.hlzt.common.utils.list;

import com.hlzt.common.utils.StringUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ListUtil {
    /**
     * 获取list键的最大值
     * @param list
     * @param key
     * @return
     */
    public static double listMapMaxDouble(List<Map<String,Object>> list, String key) {
        double max = 0;
        for (Map<String, Object> map : list) {
            if (map.get(key) != null) {
                double value =  ((BigDecimal) map.get(key)).doubleValue();
                if (value > max) {
                    max = value;
                }
            }
        }
        return max;
    }
    public static int listMapMaxInt(List<Map<String,Object>> list, String key) {
        int max = 0;
        for (Map<String, Object> map : list) {
            if (map.get(key) != null) {
                int value =  Integer.parseInt((StringUtils.trans(map.get(key))));
                if (value > max) {
                    max = value;
                }
            }
        }
        return max;
    }

    public static void markRepeatElement(List<Map<String,Object>> listMap,String previousKey) {
        for (int i = 0; i < listMap.size(); i++) {
            String pvi = StringUtils.trans(listMap.get(i).get(previousKey));
            for (int j = i+1; j < listMap.size(); j++) {
                String pvj = StringUtils.trans(listMap.get(j).get(previousKey));
                if (!"".equals(pvi) && pvi.equals(pvj)) {
                    listMap.get(i).put("repeat_"+previousKey,"1");
                    listMap.get(j).put("repeat_"+previousKey,"1");

                }
            }
        }
        markRepeatStart(listMap,previousKey);
    }

    /**
     * start_key 为0不做合并，重复
     * @param listMap
     * @param key
     */
    public static void markRepeatStart(List<Map<String, Object>> listMap, String key) {
        boolean flag = false;
        for (Map<String, Object> map : listMap) {
            String repeatFlag = (String) map.get("repeat_"+key);
            if ("1".equals(repeatFlag)) {
                map.put("start_"+key,"0");
                if (!flag) {
                    flag = true;
                    map.put("start_"+key,"1");
                }
            } else {
                flag = false;
            }
        }

    }

    public static void markRepeat(List<Map<String,Object>> listMap) {
        Set<Map.Entry<String, Object>> entries = listMap.get(0).entrySet();
        for (Map.Entry<String, Object> entry : entries) {
//            markRepeatElement(listMap, entry.getKey());
//            markRepeatStart(listMap, entry.getKey());
        }
    }
}

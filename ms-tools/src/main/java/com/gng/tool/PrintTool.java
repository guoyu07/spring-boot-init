package com.gng.tool;

import com.google.common.base.Joiner;
import com.google.common.collect.Multimap;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class PrintTool {

    public static void printMultiMap(Map<String, List<Integer>> map) {
        if (CollectionUtils.isEmpty(map)) {
            return ;
        }

        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<Integer> values = entry.getValue();
            String valueStr = Joiner.on(",").join(values);
            System.out.println(key + " : " + valueStr);
        }
    }

    public static void printMultiMap(Multimap<String, Integer> map) {
        if (null == map || map.isEmpty()) {
            return ;
        }

        for (Map.Entry<String, Collection<Integer>> entry : map.asMap().entrySet()) {
            String key = entry.getKey();
            Collection<Integer> values = entry.getValue();
            String valueStr = Joiner.on(",").join(values);
            System.out.println(key + " : " + valueStr);
        }
    }
}

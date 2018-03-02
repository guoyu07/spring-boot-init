package com.gng.collections;


import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MultiMapSample {
    Map<String, List<Integer>> nameScoresMap = Maps.newHashMap();
    Multimap<String, Integer> nameScoresMultiMap = ArrayListMultimap.create();

    // 反例
    public void addScore(final String name, int score) {
        List<Integer> scores = nameScoresMap.get(name);
        if (null == scores) {
            scores = Lists.newArrayList();
            nameScoresMap.put(name, scores);
        }
        scores.add(score);
    }

    // 正解
    public void addScoreByMultiMap(final String name, int score) {
        nameScoresMultiMap.put(name, score);
    }


}

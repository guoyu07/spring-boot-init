package com.gng.collections;

import com.gng.tool.PrintTool;
import org.junit.Test;

public class MultiMapSampleTest {

    @Test
    public void test_addScore() {
        MultiMapSample mapSample = new MultiMapSample();
        mapSample.addScore("foo", 80);
        mapSample.addScore("foo", 90);
        mapSample.addScore("foo", 99);
        mapSample.addScore("tai", 60);
        mapSample.addScore("tai", 70);
        mapSample.addScore("tai", 79);
        PrintTool.printMultiMap(mapSample.getNameScoresMap());
    }

    @Test
    public void test_addScoreByMultiMap() {
        MultiMapSample mapSample = new MultiMapSample();
        mapSample.addScoreByMultiMap("foo", 80);
        mapSample.addScoreByMultiMap("foo", 90);
        mapSample.addScoreByMultiMap("foo", 99);
        mapSample.addScoreByMultiMap("tai", 60);
        mapSample.addScoreByMultiMap("tai", 70);
        mapSample.addScoreByMultiMap("tai", 79);
        PrintTool.printMultiMap(mapSample.getNameScoresMultiMap());
    }
}

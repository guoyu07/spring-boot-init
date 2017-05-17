package com.kyee.crawler.localdata;

import lombok.Data;

@Data
public class CrawlStat {
    private int totalProcessedPages;
    private long totalLinks;
    private long totalTextSize;

    public void incProcessedPages() {
        this.totalProcessedPages++;
    }

    public void incTotalLinks(int count) {
        this.totalLinks += count;
    }

    public void incTotalTextSize(int count) {
        this.totalTextSize += count;
    }
}
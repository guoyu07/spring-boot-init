package com.kyee.crawler.localdata;


import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * this example demonstrates how the controller can collect data/statistics from crawling threads.
 */
@Slf4j
public class LocalDataCollectorController {

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            log.info("Needed parameters: ");
            log.info("\t rootFolder (it will contain intermediate crawl data)");
            log.info("\t numberOfCralwers (number of concurrent threads)");
            return;
        }

        String rootFolder = args[0];
        int numberOfCrawlers = Integer.parseInt(args[1]);

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(rootFolder);
        config.setMaxPagesToFetch(10);
        config.setPolitenessDelay(1000);

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        controller.addSeed("http://www.ics.uci.edu/");
        controller.start(LocalDataCollectorCrawler.class, numberOfCrawlers);

        List<Object> crawlersLocalData = controller.getCrawlersLocalData();
        long totalLinks = 0;
        long totalTextSize = 0;
        int totalProcessedPages = 0;
        for (Object localData : crawlersLocalData) {
            CrawlStat stat = (CrawlStat) localData;
            totalLinks += stat.getTotalLinks();
            totalTextSize += stat.getTotalTextSize();
            totalProcessedPages += stat.getTotalProcessedPages();
        }

        log.info("Aggregated Statistics:");
        log.info("\tProcessed Pages: {}", totalProcessedPages);
        log.info("\tTotal Links found: {}", totalLinks);
        log.info("\tTotal Text Size: {}", totalTextSize);
    }
}
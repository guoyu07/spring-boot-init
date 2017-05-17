package com.kyee.crawler.imagecrawler;


import lombok.extern.slf4j.Slf4j;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

@Slf4j
public class ImageCrawlController {

    public static void main(String[] args) throws Exception {
        if (args.length < 3) {
            log.info("Needed parameters: ");
            log.info("\t rootFolder (it will contain intermediate crawl data)");
            log.info("\t numberOfCralwers (number of concurrent threads)");
            log.info("\t storageFolder (a folder for storing downloaded images)");
            return;
        }

        String rootFolder = args[0];
        int numberOfCrawlers = Integer.parseInt(args[1]);
        String storageFolder = args[2];

        CrawlConfig config = new CrawlConfig();

        config.setCrawlStorageFolder(rootFolder);

    /*
     * Since images are binary content, we need to set this parameter to
     * true to make sure they are included in the crawl.
     */
        config.setIncludeBinaryContentInCrawling(true);

        String[] crawlDomains = {"http://uci.edu/"};

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
        for (String domain : crawlDomains) {
            controller.addSeed(domain);
        }

        ImageCrawler.configure(crawlDomains, storageFolder);

        controller.start(ImageCrawler.class, numberOfCrawlers);
    }
}
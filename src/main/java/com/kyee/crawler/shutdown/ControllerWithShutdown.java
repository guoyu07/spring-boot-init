package com.kyee.crawler.shutdown;


import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import lombok.extern.slf4j.Slf4j;

/**
 *  this example shows have crawling can be terminated gracefully by sending the 'shutdown' command to the controller.
 */
@Slf4j
public class ControllerWithShutdown {

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            log.info("Needed parameters: ");
            log.info("\t rootFolder (it will contain intermediate crawl data)");
            log.info("\t numberOfCralwers (number of concurrent threads)");
            return;
        }

        /*
         * crawlStorageFolder is a folder where intermediate crawl data is
         * stored.
         */
        String crawlStorageFolder = args[0];

        /*
         * numberOfCrawlers shows the number of concurrent threads that should
         * be initiated for crawling.
         */
        int numberOfCrawlers = Integer.parseInt(args[1]);

        CrawlConfig config = new CrawlConfig();

        config.setCrawlStorageFolder(crawlStorageFolder);

        config.setPolitenessDelay(1000);

        // Unlimited number of pages can be crawled.
        config.setMaxPagesToFetch(-1);

        /*
         * Instantiate the controller for this crawl.
         */
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        /*
         * For each crawl, you need to add some seed urls. These are the first
         * URLs that are fetched and then the crawler starts following links
         * which are found in these pages
         */
        controller.addSeed("http://www.ics.uci.edu/~welling/");
        controller.addSeed("http://www.ics.uci.edu/~lopes/");
        controller.addSeed("http://www.ics.uci.edu/");

        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        controller.startNonBlocking(BasicCrawler.class, numberOfCrawlers);

        // Wait for 30 seconds
        Thread.sleep(30 * 1000);

        // Send the shutdown request and then wait for finishing
        controller.shutdown();
        controller.waitUntilFinish();
    }
}
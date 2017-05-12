package com.kyee.crawler.first;


import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.crawler.WebCrawler;

//Using a factory can be convenient to integrate crawler4j in a IoC environement (like Spring, Guice)
// or to pass information or a collaborator to each WebCrawler instance.

public class MyCrawlerFactory implements CrawlController.WebCrawlerFactory{

//    Map<String, String> metadata;
//    SqlRepository repository;
//
//    public CsiCrawlerCrawlerControllerFactory(Map<String, String> metadata, SqlRepository repository) {
//        this.metadata = metadata;
//        this.repository = repository;
//    }
//
    @Override
    public WebCrawler newInstance() {
//        return new MyCrawler(metadata, repository);
        return new MyCrawler();
    }


    /**
     * To use a factory just call the right method in the CrawlController
     *(probably you will want to use the startNonBlocking if you are in Spring or Guice):
     */
//    MyCrawlerFactory factory = new MyCrawlerFactory(metadata, repository);
//    controller.startNonBlocking(factory, numberOfCrawlers);
}

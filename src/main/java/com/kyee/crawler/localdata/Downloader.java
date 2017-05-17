package com.kyee.crawler.localdata;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.fetcher.PageFetchResult;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.parser.ParseData;
import edu.uci.ics.crawler4j.parser.Parser;
import edu.uci.ics.crawler4j.url.WebURL;

/**
 * This class is a demonstration of how crawler4j can be used to download a
 * single page and extract its title and text.
 */
@Slf4j
public class Downloader {

    private final Parser parser;
    private final PageFetcher pageFetcher;

    public Downloader() throws InstantiationException, IllegalAccessException {
        CrawlConfig config = new CrawlConfig();
        parser = new Parser(config);
        pageFetcher = new PageFetcher(config);
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Downloader downloader = new Downloader();
        downloader.processUrl("http://en.wikipedia.org/wiki/Main_Page/");
        downloader.processUrl("http://www.yahoo.com/");
    }

    public void processUrl(String url) {
        log.debug("Processing: {}", url);
        Page page = download(url);
        if (page != null) {
            ParseData parseData = page.getParseData();
            if (parseData != null) {
                if (parseData instanceof HtmlParseData) {
                    HtmlParseData htmlParseData = (HtmlParseData) parseData;
                    log.debug("Title: {}", htmlParseData.getTitle());
                    log.debug("Text length: {}", htmlParseData.getText().length());
                    log.debug("Html length: {}", htmlParseData.getHtml().length());
                }
            } else {
                log.warn("Couldn't parse the content of the page.");
            }
        } else {
            log.warn("Couldn't fetch the content of the page.");
        }
        log.debug("==============");
    }

    private Page download(String url) {
        WebURL curURL = new WebURL();
        curURL.setURL(url);
        PageFetchResult fetchResult = null;
        try {
            fetchResult = pageFetcher.fetchPage(curURL);
            if (fetchResult.getStatusCode() == HttpStatus.SC_OK) {
                Page page = new Page(curURL);
                fetchResult.fetchContent(page, pageFetcher.getConfig().getMaxDownloadSize());
                parser.parse(page, curURL.getURL());
                return page;
            }
        } catch (Exception e) {
            log.error("Error occurred while fetching url: " + curURL.getURL(), e);
        } finally {
            if (fetchResult != null) {
                fetchResult.discardContentIfNotConsumed();
            }
        }
        return null;
    }
}
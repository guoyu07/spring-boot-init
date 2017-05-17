package com.kyee.crawler.multiplecrawler;


import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.regex.Pattern;

@Slf4j
public class BasicCrawler extends WebCrawler {

    private static final Pattern FILTERS = Pattern.compile(
            ".*(\\.(css|js|bmp|gif|jpe?g" + "|png|tiff?|mid|mp2|mp3|mp4" +
                    "|wav|avi|mov|mpeg|ram|m4v|pdf" + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

    private String[] myCrawlDomains;

    @Override
    public void onStart() {
        myCrawlDomains = (String[]) myController.getCustomData();
    }

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        if (FILTERS.matcher(href).matches()) {
            return false;
        }

        for (String crawlDomain : myCrawlDomains) {
            if (href.startsWith(crawlDomain)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void visit(Page page) {
        int docid = page.getWebURL().getDocid();
        String url = page.getWebURL().getURL();
        int parentDocid = page.getWebURL().getParentDocid();

        log.debug("Docid: {}", docid);
        log.info("URL: {}", url);
        log.debug("Docid of parent page: {}", parentDocid);

        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String text = htmlParseData.getText();
            String html = htmlParseData.getHtml();
            Set<WebURL> links = htmlParseData.getOutgoingUrls();

            log.debug("Text length: {}", text.length());
            log.debug("Html length: {}", html.length());
            log.debug("Number of outgoing links: {}", links.size());
        }

        log.debug("=============");
    }
}
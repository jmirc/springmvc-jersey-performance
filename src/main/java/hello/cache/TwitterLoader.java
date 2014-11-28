package hello.cache;

import com.hazelcast.core.IList;
import com.hazelcast.core.IMap;
import hello.configuration.CacheConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

@Component
@AutoConfigureAfter(CacheConfiguration.class)
public class TwitterLoader {

    private Logger logger = LoggerFactory.getLogger(TwitterLoader.class);

    @Resource
    private IList<Tweet> tweetCache;

    @PostConstruct
    public void loader() {
        logger.info("Start loading the cache from twitter");
        Twitter twitter = new TwitterTemplate("iOGpCj3OJ33n4aMJyBkb9vxWo", "Y5ni93pyIcYAfFWwgIomS0if3riOtwTTqaBrRRhMu4L0JoW1K3");
        final SearchResults search = twitter.searchOperations().search("#jhipster");

        final List<Tweet> tweets = search.getTweets();

        tweets.stream()
                .forEach(tweetCache::add);

        logger.info("The cache is loaded.");
    }

}

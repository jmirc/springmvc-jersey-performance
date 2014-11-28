package hello.controller;

import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/")
public class TwitterController {

    @Resource
    @Qualifier(value = "tweetCache")
    private IMap<Object, Tweet> tweetCache;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUniqueTweet() {
        return ResponseEntity.ok(tweetCache.values().iterator().next());
    }

    @RequestMapping(
            value = "/random",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getRandomTweet() {
        return random()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null));
    }

    public Optional<Tweet> random() {
        long count = tweetCache.size();
        if (count == 0) return Optional.empty();
        Random r = new Random();
        long randomIndex = count <= Integer.MAX_VALUE ? r.nextInt((int) count) :
                r.longs(1, 0, count).findFirst().orElseThrow(AssertionError::new);
        return tweetCache.values().parallelStream().skip(randomIndex).findFirst();
    }
}

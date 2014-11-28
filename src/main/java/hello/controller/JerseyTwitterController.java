package hello.controller;

import com.hazelcast.core.IList;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;
import java.util.Random;

@Component
@Path("/")
public class JerseyTwitterController {

    @Resource
    @Qualifier(value = "tweetCache")
    private IList<Tweet> tweetCache;

    @GET
    public Response getUniqueTweet() {
        return Response.ok().type(MediaType.APPLICATION_JSON).entity(tweetCache.get(0)).build();
    }

    @GET
    @Path("random")
    public Response getRandomTweet() {
        return random()
                .map(tweet -> Response.ok().type(MediaType.APPLICATION_JSON).entity(tweet).build())
                .orElse(Response.serverError().build());
    }

    public Optional<Tweet> random() {
        long count = tweetCache.size();
        if(count==0) return Optional.empty();
        Random r = new Random();
        long randomIndex=count<=Integer.MAX_VALUE? r.nextInt((int)count):
                r.longs(1, 0, count).findFirst().orElseThrow(AssertionError::new);
        return Optional.of(tweetCache.get((int) randomIndex));
    }

}

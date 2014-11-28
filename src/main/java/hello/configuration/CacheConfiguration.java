package hello.configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.SerializerConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IList;
import com.hazelcast.core.IMap;
import com.hazelcast.instance.HazelcastInstanceFactory;
import hello.cache.KryoTwitterSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class CacheConfiguration {

    private static HazelcastInstance hazelcastInstance;

    @PreDestroy
    public void destroy() {
        hazelcastInstance.shutdown();
    }

    @PostConstruct
    public void initialize() {
        System.setProperty("hazelcast.local.localAddress", "127.0.0.1");
        final Config config = new Config();
        config.getNetworkConfig().setPort(5701);
        config.getNetworkConfig().setPortAutoIncrement(true);
        config.getNetworkConfig().getJoin().getAwsConfig().setEnabled(false);
        config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
        config.getNetworkConfig().getJoin().getTcpIpConfig().setEnabled(false);

        config.setInstanceName("default");
        config.setConfigurationUrl(CacheConfiguration.class.getResource("hazelcast.xml"));
        config.getSerializationConfig().getSerializerConfigs().add(
                new SerializerConfig().
                        setTypeClass(Twitter.class).
                        setImplementation(new KryoTwitterSerializer()));
        hazelcastInstance = HazelcastInstanceFactory.newHazelcastInstance(config);
    }

    @Bean
    public IList<Tweet> tweetCache() {
        return hazelcastInstance.getList("tweets");
    }
}

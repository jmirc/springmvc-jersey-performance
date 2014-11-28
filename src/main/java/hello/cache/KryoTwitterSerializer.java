package hello.cache;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.StreamSerializer;
import org.objenesis.strategy.StdInstantiatorStrategy;
import org.springframework.social.twitter.api.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class KryoTwitterSerializer implements StreamSerializer<Tweet> {

    // A thread local is used to cache the created Kryo instance
    // at each thread level since Kryo is not thread safe
    private static ThreadLocal<Kryo> kryoInstance = new ThreadLocal<Kryo>();

    /**
     * This method is used to get the instance of  kryo associated
     * with the running thread.
     *
     * @return a dedicated Kryo instance per thread
     */
    private static Kryo getKryoIntance() {
        Kryo kryo = kryoInstance.get();

        if (kryo == null) {
            kryo = new Kryo();
            kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());

            // Static registration of domain classes which object instances
            // could be serialized or deserialized using Kryo library.
            kryo.register(Tweet.class, 1);
            kryo.register(Entities.class, 2);
            kryo.register(TwitterProfile.class, 3);
            kryo.register(UrlEntity.class, 4);
            kryo.register(HashTagEntity.class, 5);
            kryo.register(MentionEntity.class, 6);
            kryo.register(MediaEntity.class, 7);
            kryo.register(TickerSymbolEntity.class, 8);

            // Cache the kryo instance ...
            kryoInstance.set(kryo);
        }

        return kryo;
    }

    @Override
    public void write(ObjectDataOutput out, Tweet tweet) throws IOException {
        final Output output = new Output((OutputStream) out);
        getKryoIntance().writeObject(output, tweet);
        output.flush();
    }

    @Override
    public Tweet read(ObjectDataInput in) throws IOException {
        final Input input = new Input((InputStream) in);
        return getKryoIntance().readObject(input, Tweet.class);
    }

    @Override
    public int getTypeId() {
        return 3;
    }

    @Override
    public void destroy() {

    }
}

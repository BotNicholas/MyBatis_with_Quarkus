import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
import org.nicholas.mybatiswithquarkus.mappers.BlogMapper;
import org.nicholas.mybatiswithquarkus.mappers.PostMapper;
import org.nicholas.mybatiswithquarkus.mappers.UserMapper;

@QuarkusMain
public class Main implements QuarkusApplication {
    @Inject
    private PostMapper postMapper;
    @Inject
    private BlogMapper blogMapper;
    @Inject
    private UserMapper userMapper;

    @Override
    public int run(String... args) throws Exception {
        postMapper.findAll().forEach(System.out::println);
        System.out.println();
        blogMapper.findAll().forEach(System.out::println);
        System.out.println();
        userMapper.findAll().forEach(System.out::println);
        System.out.println();

        System.out.println(userMapper.findById(1));
        return 0;
    }
}
//OR
//@QuarkusMain
//public class Main {
//    public static void main(String[] args) {
//        Quarkus.run(args);
//    }
//}

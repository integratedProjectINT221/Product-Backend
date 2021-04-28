//package integrated.project.models;
//
////import com.example.jpa.model.Post;
////import com.example.jpa.model.Tag;
////import com.example.jpa.repository.PostRepository;
////import com.example.jpa.repository.TagRepository;
//import integrated.project.repositories.ProductsJpaRepository;
//import integrated.project.repositories.ColorsJpaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class test implements CommandLineRunner {
//
////    @Autowired
//    private ProductsJpaRepository ProductsJpaRepository;
//
////    @Autowired
//    private ColorsJpaRepository ColorsJpaRepository;
//
//    public static void main(String[] args) {
//        SpringApplication.run(test.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Cleanup the tables
//        ColorsJpaRepository.deleteAllInBatch();
//        ProductsJpaRepository.deleteAllInBatch();
//
//        // =======================================
//
//        // Create a Post
//        Product post = new Product("asdas","asdsd", 50.00,"aas","asd");
//
//        // Create two tags
//        Color tag1 = new Color("Spring Boot");
//        Color tag2 = new Color("Hibernate");
//
//
//        // Add tag references in the post
//        post.getColors().add(tag1);
//        post.getColors().add(tag2);
//
//        // Add post reference in the tags
//        tag1.getProduct().add(post);
//        tag2.getProduct().add(post);
//
//        ProductsJpaRepository.save(post);
//
//        // =======================================
//
//    }
//}

package integrated.project.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;



@ConfigurationProperties("integrated.upload")
@Getter
@Setter
public class StorageProperties {
//   @Value("${integrated.project.upload.location}")
   private String location;

   public String getLocation() {
      return location;
   }

   public void setLocation(String location) {
      this.location = location;
   }
}

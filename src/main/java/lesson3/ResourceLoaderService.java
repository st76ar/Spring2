package lesson3;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component("resourceLoaderService")
public class ResourceLoaderService implements ResourceLoaderAware {
    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void showResourceData() throws IOException {
        Resource resource = resourceLoader.getResource("file:src/users_data/users.txt");

        if (resource.exists()) {
            if (resource.isReadable()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            } else {
                System.out.println("Нет доступа на чтение файла users.txt");
            }
        } else {
            System.out.println("Файл users.txt не найден");
        }
    }
}


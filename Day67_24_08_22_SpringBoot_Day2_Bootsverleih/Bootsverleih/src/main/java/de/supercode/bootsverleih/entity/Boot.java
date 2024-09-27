package de.supercode.bootsverleih.entity;

import de.supercode.bootsverleih.reposetory.BootRepository;
import jdk.jfr.Enabled;
import org.springframework.stereotype.Component;

@Component
public class Boot {
    private Long id;
    private String name;
    private String category;
    private String capacity;
    private boolean available;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Boot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }
}

package com.example.eatgo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.core.convert.support.GenericConversionService;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String regionName;  // Seoul

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String categoryName;    // Korean

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String tagNames;    // #JMT

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<MenuItem> menuItems;

    public String getInformation() {
        return name + " in " + address;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = new ArrayList<>(menuItems);
    }


    public void updateInformation(String name, String address) {
        this.name = name;
        this.address = address;
    }
}

package com.gmail.jeanchristophe.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.templatemodel.TemplateModel;

import javax.annotation.PostConstruct;

/**
 * Simple template example.
 */
@Tag("example-map-template")
@HtmlImport("src/example-map-template.html")
@SpringComponent
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ExampleMapTemplate extends PolymerTemplate<ExampleMapTemplate.ExampleModel> {

    /**
     * Template model which defines the single "value" property.
     */
    public interface ExampleModel extends TemplateModel {

        void setApikey(String apikey);
        void setLatitude(String latitude);
        void setLongitude(String longitude);
        void setLatitudeMarker(String latitudeMarker);
        void setLongitudeMarker(String longitudeMarker);
    }
    @Value(value = "${custom.googlemap.apikey}")
    private String apikey;


    public ExampleMapTemplate() {

    }
    @PostConstruct
    private void init(){
        getModel().setApikey(apikey);
        getModel().setLatitude("5.99");
        getModel().setLongitude("38.99");

        getModel().setLatitudeMarker("5.94");
        getModel().setLongitudeMarker("38.94");

    }


}

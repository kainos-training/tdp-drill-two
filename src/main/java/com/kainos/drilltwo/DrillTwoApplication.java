package com.kainos.drilltwo;

import com.kainos.drilltwo.config.DrillTwoConfiguration;
import com.kainos.drilltwo.resources.BookResource;
import com.kainos.drilltwo.resources.HomeResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

public class DrillTwoApplication extends Application<DrillTwoConfiguration> {
    @Override
    public void initialize(Bootstrap<DrillTwoConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle<DrillTwoConfiguration>());
        bootstrap.addBundle(new AssetsBundle("/assets", "/assets"));
        bootstrap.addBundle(new MultiPartBundle());
    }

    public void run(DrillTwoConfiguration discoveryDiaryConfiguration, Environment environment) throws Exception {
        final HomeResource homeResource = new HomeResource();
        final BookResource bookResource = new BookResource(new DataStore(), discoveryDiaryConfiguration);

        environment.jersey().register(homeResource);
        environment.jersey().register(bookResource);
    }

    public static void main(String[] args) throws Exception {
        new com.kainos.drilltwo.DrillTwoApplication().run(args);
    }
}

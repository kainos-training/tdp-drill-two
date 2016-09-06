package com.kainos.drilltwo.config;

import com.google.common.collect.ImmutableMap;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotNull;

public class DrillTwoConfiguration extends Configuration {

    @NotNull
    private ImmutableMap<String, ImmutableMap<String, String>> viewRendererConfiguration = ImmutableMap.of();
}

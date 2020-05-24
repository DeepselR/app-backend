package com.app.shared.configuration;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Properties;
import java.util.stream.Stream;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.StringUtils;

@Configuration
@ComponentScan("com.app.shared")
@AutoConfigureBefore(PropertyPlaceholderAutoConfiguration.class)
public class SharedAutoConfiguration {

  /**
   * Collecting all properties and combining them in order of priorities for testing.
   */
  @Bean
  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {

    PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();

    ClassLoader cl = SharedAutoConfiguration.class.getClassLoader();
    ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);

    //Collect all files to application.yml pattern and put them to resources
    Properties properties = getProperties("classpath*:application.yml", resolver);

    String activeProfiles = System.getProperty("spring.profiles.active");
    if (StringUtils.hasLength(activeProfiles) && !activeProfiles.contains("null")) {
      Stream.of(activeProfiles.split(","))
          .map(String::trim)
          .filter(StringUtils::hasLength)
          .map(activeProfile -> "classpath*:application-" + activeProfile + ".yml")
          .map(pattern -> getProperties(pattern, resolver))
          .forEach(properties::putAll);
    }

    configurer.setProperties(properties);
    return configurer;
  }

  private static Properties getProperties(String propertiesFilename,
      ResourcePatternResolver resolver) {
    try {
      YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
      yaml.setResources(resolver.getResources(propertiesFilename));
      return yaml.getObject();
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

}

package com.product.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import brave.sampler.Sampler;

@Configuration
public class AppConfig {

       //Collects data from Sleuth and provides it to Zipkin Client
       @Bean
       public Sampler samplerOb() {
             //return Sampler.NEVER_SAMPLE;
            return Sampler.ALWAYS_SAMPLE;
       }

   //Creates RestTemplate Object
      @Bean
      public RestTemplate rt() {
           return new RestTemplate();
      }
}

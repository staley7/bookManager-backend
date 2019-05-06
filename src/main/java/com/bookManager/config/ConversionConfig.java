package com.bookManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

import com.bookManager.converter.AuthorDtoToAuthorConverter;
import com.bookManager.converter.AuthorToAuthorDtoConverter;
import com.bookManager.converter.BookDtoToBookConverter;
import com.bookManager.converter.BookToBookDtoConverter;

/**
 * The Conversion Config class for the conversionService.
 * @author Lance Staley
 *
 */
@Configuration(value = "bookManagerConversionConfig")
public class ConversionConfig {

    /**
     * Converter Service for BookManager.
     *
     * @return the conversion service
     */
    @Bean(name = "bookManagerConverter")
    public ConversionService fcConverter() {
        DefaultConversionService converterService = new DefaultConversionService();
        converterService.addConverter(new AuthorToAuthorDtoConverter());
        converterService.addConverter(new AuthorDtoToAuthorConverter());
        converterService.addConverter(new BookToBookDtoConverter());
        converterService.addConverter(new BookDtoToBookConverter());
        return converterService;
    }

}

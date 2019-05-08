package com.bookManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

import com.bookManager.converter.AuthorDtoToAuthorConverter;
import com.bookManager.converter.AuthorToAuthorDtoConverter;
import com.bookManager.converter.BookDtoToBookConverter;
import com.bookManager.converter.BookToBookDtoConverter;
import com.bookManager.converter.CollectionDtoToCollectionConverter;
import com.bookManager.converter.CollectionToCollectionDtoConverter;
import com.bookManager.converter.GenreDtoToGenreConverter;
import com.bookManager.converter.GenreToGenreDtoConverter;
import com.bookManager.converter.SeriesDtoToSeriesConverter;
import com.bookManager.converter.SeriesToSeriesDtoConverter;

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
        converterService.addConverter(new CollectionToCollectionDtoConverter());
        converterService.addConverter(new CollectionDtoToCollectionConverter());
        converterService.addConverter(new SeriesToSeriesDtoConverter());
        converterService.addConverter(new SeriesDtoToSeriesConverter());
        converterService.addConverter(new GenreToGenreDtoConverter());
        converterService.addConverter(new GenreDtoToGenreConverter());
        return converterService;
    }

}

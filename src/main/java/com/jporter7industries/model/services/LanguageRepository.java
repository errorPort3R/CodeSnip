package com.jporter7industries.model.services;

import com.jporter7industries.model.entities.CodeSnippet;
import com.jporter7industries.model.entities.Language;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jeffryporter on 8/29/16.
 */
public interface LanguageRepository  extends CrudRepository<Language, Integer>
{
}

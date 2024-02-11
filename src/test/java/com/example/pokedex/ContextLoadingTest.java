package com.example.pokedex;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContextLoadingTest {

    @Test
    public void testContextLoading() {
        // Create a generic application context
        GenericApplicationContext context = new GenericApplicationContext();

        // Create a reader for XML bean definitions
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);

        // Load the bean definitions from the XML file
        reader.loadBeanDefinitions("/pokemon-controller-test-context.xml");

        // Refresh the application context to load the bean definitions
        context.refresh();

        // Check if the necessary beans are present in the context
        assertTrue(context.containsBean("pokemonController"), "pokemonController bean should be present");
        assertTrue(context.containsBean("pokemonService"), "pokemonService bean should be present");

        // Close the context
        context.close();
    }
}


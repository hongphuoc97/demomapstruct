package com.green.org.demomapstruct.query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.Set;

public class SqlLocator {
    private static Logger logger = LogManager.getLogger(SqlLocator.class);

    public static void main(String[] args) {
        findAllQueryClasses("com.green.org.demomapstruct.query");
    }

    private static void findAllQueryClasses(String prefixes) {
        Reflections reflections = new Reflections(prefixes);
        Set<Class<? extends SqlQuery>> queryClasses = reflections.getSubTypesOf(SqlQuery.class);
        queryClasses.stream().filter(queryClass -> !Modifier.isAbstract(queryClass.getModifiers())).forEach(queryClass ->
                logger.info(queryClass)
        );
    }
}

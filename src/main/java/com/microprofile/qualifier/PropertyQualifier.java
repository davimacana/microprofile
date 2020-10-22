/**
 * 
 */
package com.microprofile.qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.util.Nonbinding;
import javax.inject.Qualifier;

/**
 * @author Davi Maçana
 *
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
public @interface PropertyQualifier {
 
    @Nonbinding String key() default "";
 
    @Nonbinding boolean container() default true;
 
    @Nonbinding String fileName() default "";
 
}

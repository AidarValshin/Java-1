package main.ru.mephi.java.part6.injection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // only for
@Retention(RetentionPolicy.RUNTIME) // use in runtime
public @interface TryInject {
}

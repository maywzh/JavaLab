@Target({ ElementType.METHOD, ElementType.FIELD })
public @interface Report {
    int type() default 0;

    String level() default "info";

    String value() default "";
}

public class Hello {
    @Check(min = 0, max = 100, value = 55)
    @Report(type = 1, level = "1")
    public int n;

    @Check(value = 99)
    public int p;

    @Check(99) // @Check(value=99)
    public int x;

    @Check
    public int y;
}
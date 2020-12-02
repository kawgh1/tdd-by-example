package guru.springframework;

/**
 * created by kw on 12/2/2020 @ 11:58 AM
 */
public interface Expression {

    Money reduce(Bank bank, String to);

    public Expression plus(Expression addend);

    Expression times(int multiplier);
}

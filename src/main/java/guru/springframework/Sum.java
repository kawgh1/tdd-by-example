package guru.springframework;

/**
 * created by kw on 12/2/2020 @ 12:09 PM
 */
public class Sum implements Expression {

    final Expression augmend;
    final Expression addmend;

    // split a Sum operation into two parts
    public Sum(Expression augmend, Expression addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }

    @Override
    // reduce two Money objects (of a Sum operation) into a single Money object added together - this is to avoid casting
    public Money reduce(Bank bank, String to) {
        int amount = augmend.reduce(bank, to).amount + addmend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addmend);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augmend.times(multiplier), addmend.times(multiplier));
    }
}

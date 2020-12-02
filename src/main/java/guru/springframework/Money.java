package guru.springframework;


/**
 * created by kw on 12/2/2020 @ 11:10 AM
 */
public class Money implements Expression {

    final int amount;
    private final String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    protected String currency() {
        return currency;
    };


    // new dollar
    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    // new franc
    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }


    public boolean equals(Object object) {

        Money money = (Money) object;

        return amount == money.amount && this.currency.equals(money.currency) ;
    }


    @Override
    public Money reduce(Bank bank, String to) {
//        return this;
//        int rate = (currency.equals("CHF") && to.equals("USD")) ? 2 : 1;
        // call the bank.rate method for this currency and the to currency so bank can tell us the rate
        // normally it's the same currency, but this allows reduce with different currencies
        return new Money(amount/bank.rate(this.currency, to), to);
    }

    @Override
    public Expression times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}

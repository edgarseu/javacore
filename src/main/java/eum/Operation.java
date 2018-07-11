package eum;

/**
 * @author caozy
 * @create 2018/5/24
 */
public enum Operation {

    PLUS("+"){
        double apply(double x, double y) {
            return x+y;
        }
    };

    private final String symbol;
    Operation(String symbol){
        this.symbol = symbol;
    }

    abstract double apply(double x, double y);
}

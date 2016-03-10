/**
 * Created by renju on 3/9/16.
 */
public class CalculationVisitor  implements  Visitor{

    @Override
    public Integer addVisit(Integer first, Integer second) {
        return first + second;
    }

    @Override
    public Integer subVisit(Integer first, Integer second) {
        return first - second;
    }

    @Override
    public Integer multVisit(Integer first, Integer second) {
        return first * second;
    }

    @Override
    public Integer divideVisit(Integer first, Integer second) {
        return first / second;
    }
}

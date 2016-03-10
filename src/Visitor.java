/**
 * Created by renju on 3/9/16.
 */
public interface Visitor {
    public Integer addVisit(Integer first, Integer second);
    public Integer subVisit(Integer first, Integer second);
    public Integer multVisit(Integer first, Integer second);
    public Integer divideVisit(Integer first, Integer second);
}

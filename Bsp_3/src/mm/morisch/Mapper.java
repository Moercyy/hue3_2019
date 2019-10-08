package mm.morisch;

import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<S, T> {
    T map(S s);
    default List<T> mapAll(List<S> s){
        return  s.stream().map(s1 -> map(s1)).collect(Collectors.toList());
    };
}
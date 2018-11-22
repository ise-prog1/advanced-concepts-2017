import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MultipleChoice {

	public static void main(String[] args) {
		//List<Number> l = new ArrayList<Integer>();
		List<Integer> l = new ArrayList<>();
		foo(new LinkedList<Double>(), new ArrayList<Object>());
		HashSet<byte[]> set = new HashSet<>();
	}
	
	public static void foo(List<? extends Number> src, 
			List<? super Number> dest) {
		dest.addAll(src);
	}
	
	
}

<<<<<<< HEAD
<<<<<<< HEAD
import java.util.*;

=======
>>>>>>> 24b83f11c2b042ee44983cc8473a2954a6ab6504
=======
>>>>>>> 24b83f11c2b042ee44983cc8473a2954a6ab6504
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class EfficientMarkov extends BaseMarkov{
	
	private Map<String, ArrayList<String>> myMap;
	
	
	
	public EfficientMarkov(int order)
	{
		super(order);
		myMap = new HashMap<String, ArrayList<String>>();
	}
	public EfficientMarkov()
	{
		this(3);
<<<<<<< HEAD
<<<<<<< HEAD
		myMap = new HashMap<>();
=======
>>>>>>> 24b83f11c2b042ee44983cc8473a2954a6ab6504
=======
>>>>>>> 24b83f11c2b042ee44983cc8473a2954a6ab6504
	}
	
	
	@Override
	public void setTraining(String text) {
<<<<<<< HEAD
<<<<<<< HEAD
		myText = text;
=======
		
>>>>>>> 24b83f11c2b042ee44983cc8473a2954a6ab6504
=======
		
>>>>>>> 24b83f11c2b042ee44983cc8473a2954a6ab6504
		myMap = new HashMap<String, ArrayList<String>>();
		for (int k=0; k<text.length()-myOrder+1; k++) {
			
			String key = text.substring(k, k+myOrder);
			
			ArrayList<String> list = new ArrayList<String>();
			if (k==text.length()-myOrder) {
				myMap.putIfAbsent(key, list);
				myMap.get(key).add(PSEUDO_EOS);
			}
			else {
			myMap.putIfAbsent(key, list);
			myMap.get(key).add(text.substring(k+myOrder, k+myOrder+1));
			
		}
		}
	}
	
	@Override
	public ArrayList<String> getFollows(String key){
		
		if (! (myMap.keySet().contains(key))) {
			throw new NoSuchElementException(key+" not in map");

		}
		else
			return myMap.get(key);
	}

}

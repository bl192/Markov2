import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class EfficientWordMarkov extends BaseWordMarkov {

	HashMap<WordGram, ArrayList<String>> myMap;
	public EfficientWordMarkov() {
		this(2);
	}
	
	public EfficientWordMarkov(int order){
		super(order);
		myMap = new HashMap<WordGram, ArrayList<String>>();
	}
	
	@Override
	public void setTraining(String text){
		myWords = text.split("\\s+");
		myMap = new HashMap<WordGram, ArrayList<String>>();
		for (int k=0; k<myWords.length-myOrder; k++) {
			String[] toconvert = new String[myOrder];
			for (int j=0; j<myOrder; j++) {
				toconvert[j] = myWords[k];
			}
			
			WordGram toAdd = new WordGram(toconvert, 0, myOrder);
			ArrayList<String> add = new ArrayList<String>();
			if (k==text.length()-myOrder) {
				myMap.putIfAbsent(toAdd, add);
				myMap.get(toAdd).add(PSEUDO_EOS);
			}
			else {
			myMap.putIfAbsent(toAdd, add);
			myMap.get(toAdd).add(myWords[k+1]);
			}
		}
	}
	
	@Override
	public ArrayList<String> getFollows(WordGram kGram) {

		int pos = 0;            
		ArrayList<String> follows = new ArrayList<String>();
		while (true) {
			int index = indexOf(myWords,kGram,pos);
			if (index == -1) {
				break;
			}
			int start = index + kGram.length();
			if (start >= myWords.length) {
				follows.add(PSEUDO_EOS);
				break;
			}
			
			follows.add(myWords[start]);
			pos = index+1;
		}
		return follows;
	}
}

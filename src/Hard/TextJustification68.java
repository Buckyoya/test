package Hard;

import java.util.ArrayList;
import java.util.List;
//似懂非懂
public class TextJustification68 {
	
	public List<String> fullJustify(String[] words, int L){

		for(int i = 0; i < words.length; i++){
			if( words[i].length() > L){
				return null;
			}
		}
		
		List<String> lines = new ArrayList<String>();
	
		int index = 0;
	
		while(index < words.length){
			int countLength = words[index].length();
			int countIndex = index + 1;
			while(countLength < words.length){
				if(countLength + 1 + words[countIndex].length() > L){
					break;
				}
				countLength = countLength + 1 + words[countIndex].length();
				countIndex++;
			}
			
			StringBuilder sb = new StringBuilder(L);
			sb.append(words[index]);
			
			int slot = countIndex - index - 1;
			if(countIndex != words.length && slot != 0){
				int spaces = (L - countLength)/slot;
				int right = (L-countLength)%slot;
				for(int i = index + 1; i < countIndex; i++){
					for(int j = spaces; j > 0; j--){
						sb.append(" ");
					}
					if(right > 0){
						sb.append("");
						right--;
					}
					sb.append(" ");
					sb.append(words[i]);
				}
			}else{
				for(int i =index + 1; i < countLength; i++){
					sb.append(" ");
					sb.append(words[i]);
				}
				for(int i = sb.length(); i < L; i++){
					sb.append(" ");
				}
			}
			
			lines.add(sb.toString());
			index = countIndex;
				
		}
		
		return lines;
			
			
		
	}
}

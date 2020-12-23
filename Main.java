//careers@cognitree.com


import java.util.*;

class TusharArrayList{
	int []data = new int[100];
	int size = 0; 
	long check = 0;
	
	int size() {
		return size;
	}
	
	void add(int value) {
		data[size] = value;
		size+=1;
		check += 1;
	}
	
	int remove(int idx) {
		int value = data[idx];
		data[idx] = -1;
		check += 1;
		//size-=1;
		return value;
	}
	
	
	class tusIterator implements Iterator{
		int i=0;
		long validate = check;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			if(i>=size)
				return false;
			else
				return true;
		}

		@Override
		public Object next() {
			if(validate != check) {
				throw new ConcurrentModificationException();
			}
			int val = data[i];
			i+=1;
			return val;
		}
		
	}

	Iterator iterator() {
		return new tusIterator() {
		};
	}
	
}

public class Main {

    public static void main(String[] args) throws Exception {
    		
    		TusharArrayList arr = new TusharArrayList();
    		arr.add(3);
    		arr.add(45);
    		arr.add(345);
    		arr.add(65);
    		arr.add(375);
    		
    		Iterator<Integer> it = arr.iterator();
    		arr.add(420);
    		Iterator<Integer> it1 = arr.iterator();
    		while(it.hasNext()) {
    			System.out.println(it.next());
    			
    		}
    		
    		//TusharArrayList tan = new TusharArrayList<>();

    }
}




package bloomfilter;

import java.util.BitSet;

public class BloomFilter {

	//determine the size of bit array
	private int size = 2<< 24 ;
	//determine the number of hash function (different seeds)
	private int[] seeds = new int[]{5,7,11,13,31,37,61};
	private BitSet bits = new BitSet(size);
    private  SimpleHash[]  func = new  SimpleHash[seeds.length];
	public BloomFilter() {
	    for(int i =0;i<seeds.length;i++){
          func[i]=new SimpleHash(size);
        }
    }

	//add an element to Bloom Filter
	public void add(String str) {
    for(int i= 0;i<func.length;i++){
        bits.set(func[i].hash(seeds[i],str),true);
    }
	}

	//query whether Bloom Filter contains the element
	public boolean query(String str) {
	    if(str == null){
	        return false;
        }
	    boolean ret = true;
        for(int i= 0;i<func.length;i++){
           ret = ret && bits.get(func[i].hash(seeds[i],str));
        }
		return ret;
	}

	//Your hash function

	public static class SimpleHash{
        private int  cap;
        public  SimpleHash( int cap) {
            this.cap= cap;
        }
        private int hash(int seed, String str) {
            int result = 0;
            for(int i=0;i<str.length();i++){
                result = seed * result + str.charAt(i);
            }
            return (cap -1) & result;
        }
    }


}

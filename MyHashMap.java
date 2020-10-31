class MyHashMap {
    static int p;
    static int m;
    static int[] k;
    static int[] v;
    static Integer myInf;

    /** Initialize your data structure here. */
    public MyHashMap() {
        p = 1000001;
        m = 10000;
        k = new int[m];
        v = new int[m];
        myInf = Integer.MAX_VALUE;
        Arrays.fill(k,0,m,myInf);
        Arrays.fill(v,0,m,myInf);
    }
    public static int h(int k, int i) {
        return (h1(k) + i*h2(k))%m;
    }
    public static int h1(int k) {
        int a=501,b=1039;
        return ((a*k+b)%p)%m;
    }
    public static int h2(int k) {
        int c=51,d=52679;
        return ((c*k+d)%p)%m;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        for (int l=0;l<m;l++) {
            int j=h(key,l);
            if (k[j]==myInf || k[j]==key) {
                k[j]=key;
                v[j]=value;
                break;
            }
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        for (int l=0;l<m;l++) {
            int j=h(key,l);
            if (k[j]==key) {
                return v[j];
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        for (int l=0;l<m;l++) {
            int j=h(key,l);
            if (k[j]==key) {
                k[j]=myInf;
                v[j]=myInf;
                break;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

    //hashmap with key as string and value of arraylist with composite elemets
 
 
 class TimeStampedValue{   //composite element which is gaonna be inside ArrayList
    
    public int timeStamp;
    public String value;


    public TimeStampedValue(int timeStamp,String value){
        this.timeStamp = timeStamp;
        this.value = value;
    }
 }




class TimeMap {
    Map<String,ArrayList<TimeStampedValue>> entriesByKey;

    public TimeMap() {
        entriesByKey = new HashMap<>();
    }
    
    public void set(String key, String value, int timeStamp) {
        if(!entriesByKey.containsKey(key)){
            entriesByKey.put(key,new ArrayList<>());
        }
        ArrayList<TimeStampedValue> timeStampedValues = entriesByKey.get(key);
        timeStampedValues.add(new TimeStampedValue(timeStamp,value));
        
    }
    
    public String get(String key, int timeStamp) {
        if(!entriesByKey.containsKey(key))  {return "";}

        ArrayList<TimeStampedValue> timeStampedValues = entriesByKey.get(key);
        Optional<TimeStampedValue> optional = binarySearchTimestamp(timeStampedValues,timeStamp);

        if(optional.isEmpty()){
            return "";
        }

                return optional.get().value;
    }

    private Optional<TimeStampedValue> binarySearchTimestamp(
      ArrayList<TimeStampedValue> arr, int target) {
    int left = 0, right = arr.size() - 1;
    int matchIndex = -1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      TimeStampedValue cur = arr.get(mid);
      if(cur.timeStamp <= target) {
        matchIndex = mid;
        left = mid + 1;   // becuase we haveb to choose val equal to or lower . so check if another value exists thats bigger but lower than the tarrget timestamp that is why we r moving left imdex forward
      }
      else {
        right = mid - 1;
      }
    }

    if(matchIndex == -1) {
      return Optional.empty();
    }
    return Optional.of(arr.get(matchIndex));
  }
}

class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        /*
        Not very efficient solution. 
        Some interval elements in the intervals can generate a new bigger interval with the newInterval. So find them, 
        merge them with newInterval as a bigger interval, remove old interval elements and add this new bigger interval into the intervals.

        I use a lot of time to implement it because I forgot many corner cases. Like if intervals is a []. Like newInterval can be [0,0]. 
        And the newInterval can be the last element in the intervals.

        这个方法是能通过的，只是效率不高。我的想法是newInterval和一些intervals里面的interval可以组成一个更大的interval。只要找出这些个体，
        生成一个更大的interval插入到intervals里面，然后再删除这些个体就可以了。
        但是我在实现的时候忘记了很多个别情况，比如当intervals是空的时候（[]）；比如newInterval可以是[0,0]，但我的算法里默认所有的start和end都大于0；比如
        newInterval可以是这个intervals里面最后的元素。
        */
        int len = intervals.size();
        int intervalsStart = intervals.get(0).start;
        int intervalsEnd = intervals.get(len - 1).end;
        int s = Integer.MIN_VALUE, e = Integer.MIN_VALUE;
        
        if(intervals.size() == 0){
            intervals.add(newInterval);
            return intervals;
        }
        
        if (newInterval.end < intervalsStart){
            intervals.add(0, newInterval);
            return intervals;
        }
        
        if (newInterval.start > intervalsEnd){
            intervals.add(newInterval);
            return intervals;
        }
        
        for (int i=0; i< intervals.size(); i++){
            if(newInterval.start <= intervals.get(i).end && newInterval.start > preEnd){
                s = Math.min(newInterval.start,intervals.get(i).start);
            }
            
            if(newInterval.end < intervals.get(i).start && newInterval.end > preEnd){
                e = newInterval.end;
                intervals.add(i, new Interval(s, e));
                break;
            }else if(newInterval.end >= intervals.get(i).start && newInterval.end <= intervals.get(i).end){
                e = intervals.get(i).end;
                intervals.set(i, new Interval(s, e));
                break;
            }
            
            preEnd = intervals.get(i).end;
            
            if (s > Integer.MIN_VALUE && e == Integer.MIN_VALUE) {
                if (i == intervals.size() - 1){
                    e = newInterval.end;
                    intervals.set(i, new Interval(s, e));
                    break;
                }
                intervals.remove(i);
                i--;
            }
        }
        return intervals;
    }
}
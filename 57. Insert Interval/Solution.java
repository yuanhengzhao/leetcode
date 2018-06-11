class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
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